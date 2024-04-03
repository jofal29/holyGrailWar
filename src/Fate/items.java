package Fate;

import java.util.ArrayList;
import java.util.Random;

public class items {
	
	heroic_Spirits focus = new heroic_Spirits();
	heroic_Spirits target;
	
	public void randomPlay(heroic_Spirits f,heroic_Spirits t) {
		this.focus = f; this.target = t;
		
		//Turn
		if(this.focus.turnCheck()==true)
		{
			randomItem(); 
		}		
		else {
			System.out.println(this.focus.getName()+" is unable to make a move.");
		}
	}
	

	private void randomItem() {
		Random randomGenerator = new Random();
		int randomChoice = randomGenerator.nextInt(12);
		//System.out.println(randomChoice);
		switch(randomChoice) {
		case 0: {
			npCharge();
		}
		break;
		case 1: {
			heal();
		}
		break;
		case 2: {
			attack();
		}
		break;
		case 3: {
			curse();
		}
		break;
		case 4: {
			attack();
		}
		break;
		case 5: {
			shield();
		}
		break;
		case 6: {
			addNp();
		}
		break;
		case 7: {
			if(this.target.turnsFrozen==0)
			{
			charm(1);
			}
			else{System.out.println(this.target.getName()+" cannot be charmed again.");}
		}
		break;
		case 8:{
			npSeal();
		}
		break;
		case 9:{
			stun();			
		}
		break;
		case 10:{
			if(this.focus.usableSkill=="Move") {
			skillUse();			
			}
			else {
				randomItem();
			}
		}
		break;
		case 11:{
			np();			
		}
		break;
		default: {
			System.out.println("Oops");
		}
		break;
		}		
	}
	public void chooseAction(String action,heroic_Spirits s2) {
		if(s2.checkImmune(action)=="not immune") {
		this.target=s2;
		switch(action) {
		case "npCharge": {
			npCharge();
		}
		break;
		case "heal": {
			heal();
		}
		break;
		case "attack": {
			attack();
		}
		break;
		case "curse": {
			curse();
		}
		break;
		case "shield": {
			shield();
		}
		break;
		case "takeLife": {
			s2.takeLife();
		}
		break;
		case "charm": {
			if(s2.turnsFrozen==0)
			{
			charm(1);
			}
			else{System.out.println(s2.getName()+" cannot be charmed again.");}
		}
		break;
		case "protectFromNP":{
			protectFromNP();
		}break;
		default: {
			System.out.println("Oops");
		}
		break;
		}		}
		else {
			System.out.println(s2.getName()+ " is immune to " + action);
		}
	}
	private void addNp() {
		double randomOfTwo = new Random().nextBoolean() ? 1 : 2;
		for (int i=0; i<randomOfTwo; i++) {
		System.out.println(this.focus.getName() + " +1NP");
		this.focus.npHeld++;
		}
		
	}
	private void np() {
		if(this.focus.npSeals>0)
		{
			System.out.println("Noble Phantasm Sealed. "+this.focus.getName()+ " cannot activate NP.");
		}
		else {
				noblePhantasm hogu = new noblePhantasm(this.focus,this.target);
				hogu.activate(this.focus.getName());
		 	 }
		}
	public void curse() {
		this.target.curses++;
		this.target.maxHealth--;
		System.out.println(this.target.getName()+" Cursed (-1 Max Health) by Master " + this.focus.master);
		if(this.target.maxHealth <= this.target.hearts) {
			this.target.hearts--;
		}
		else {System.out.println("Max Health: "+this.target.maxHealth);}
		this.target.checkHealth();
	}
	public void npCharge() {
		double randomOfTwo = new Random().nextBoolean() ? 1 : 2;
		for (int i=0; i<randomOfTwo; i++) {
		System.out.println(this.focus.getName() + " +1np charge");
		this.focus.npCharge++;
		}
		if(this.focus.npCharge>=this.focus.npMaxCharges) {
			this.focus.npHeld++;
			this.focus.npCharge = (this.focus.npCharge-this.focus.npMaxCharges);
			np();
			}
		else	{
				int npNeed = this.focus.npMaxCharges - this.focus.npCharge;
				System.out.println(this.focus.getName() + " needs " + npNeed + " np charges.");
			}
		}
	public void attack() {
		
		System.out.println(this.focus.getName() + " attacks " + this.target.getName());
		if(this.target.defense > 0)
		{
			this.target.defense--;
			System.out.println(this.target.getName()+" -1 Shield");
		}
		else {
			this.target.loseHearts();
		}
		this.target.checkHealth();
		
		if(this.target.hearts==0) {
			this.target.deathbyAttack = true;
		}
	}
	public void skillUse() {
		skill useSkill = new skill();
		useSkill.movePlay(this.focus.getName(), focus);
	}
	public void heal() {
		if(this.focus.curses > 0)
		{
			this.focus.curses--;
			this.focus.maxHealth++;
			this.focus.checkHealth();
		}
		else {
			if(this.focus.hearts==this.focus.maxHealth)
			{
				npCharge();
			}
				else {
					this.focus.gainHearts();
					this.focus.checkHealth();
					}
			}
		}
	public void charm(int numberOfCharms) {
		for(int i=0;i<numberOfCharms;i++) {
		this.target.turnsFrozen++;}
		System.out.println(this.target.getName()+" has been charmed.");
	}
	public void shield() {
		if(this.focus.defense==this.focus.maxHealth)
		{
			System.out.println(this.focus.getName()+": Max Shields Held");
		}
		else
		{
		System.out.println(this.focus.getName()+" +1 Shield");
		this.focus.defense++;
		}
		this.focus.checkHealth();
	}
	public void stun() {
		for(int v=0; v<holyGrailWar.masters().size();v++) {
			if(holyGrailWar.masters().get(v).masterNumber==this.target.master)
			{
				holyGrailWar.masters().get(v).turnsFrozen++;
				System.out.println("Master "+holyGrailWar.masters().get(v).masterNumber+" has been stunned by Master "+this.focus.master);
			}
			else
			{}
		}
	}
	public void npSeal() {
		this.target.npSeals++;
		System.out.println(this.target.getName()+"'s NP has been sealed by Master " + this.focus.master);
	}
	public void protectFromNP() {
		this.target.npProtection++;
		System.out.println(this.target.getName()+" gains protection for NP for one turn.");
	}

	
	
	
	
	
	public void chooseOngoing(String string, heroic_Spirits ser, int loops) {
	if(ser.checkImmune(string)=="not immune") {
		switch(string) {
	case "ongoingCurses": {
		ser.ongoingCurses = ser.ongoingCurses+loops;
		System.out.println("Ongoing Curses +"+loops);
	}
	break;
	case "disableNP": {
		ser.npSealed="Disabled";
		System.out.println(ser.getName()+"'s NP has been disabled.");
	}
	break;
	case "attack": {
		attack();
	}
	break;
	case "curse": {
		curse();
	}
	break;
	case "shield": {
		shield();
	}
	break;
	case "takeLife": {
		ser.takeLife();
	}
	break;
	case "charm": {
		if(ser.turnsFrozen==0)
		{
		charm(1);
		}
		else{System.out.println(ser.getName()+" cannot be charmed again.");}
	}
	break;
	default: {
		System.out.println("Oops");
	}
	break;
	}}
	else{			
		System.out.println(ser.getName()+ " is immune to " + string);
}}
}

