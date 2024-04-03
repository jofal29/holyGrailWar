package Fate;

import java.util.Random;

public class noblePhantasm {
	
	//Attributes
	String name;
	int ongoing = 0;

	private heroic_Spirits user;
	private heroic_Spirits targeted;
	effect servantDeath = new effect();
	
	public noblePhantasm(heroic_Spirits focusServant, heroic_Spirits targetServant) {
		this.user = focusServant; this.targeted = targetServant;
	}
	public noblePhantasm() {
	}
	public noblePhantasm(String servantName) {
		this.name = servantName;
	}
	
	keywords searchFor = new keywords();
	play check = new play();
	items cause = new items();
	
	private void ongoingHit(String string, int numOfHits) {

		if(searchFor.status==true)
		{
			for(int j=0;j<holyGrailWar.totalServants().size();j++)
			{
				if(holyGrailWar.totalServants().get(j).getName().toString()==searchFor.assignedServant.getName().toString())
				{
					System.out.println("Target Found: "+searchFor.assignedServant.getName().toString());
						cause.chooseOngoing(string, holyGrailWar.totalServants().get(j), numOfHits);
						check.updateMasters();
						check.checkLives(holyGrailWar.totalServants().get(j));				}
				else {}}}
		else {			
			}
	}		
	private void addRestriction(String servantInControl) {
		if(searchFor.status==true)
		{
			for(int j=0;j<holyGrailWar.totalServants().size();j++)
			{
				if(holyGrailWar.totalServants().get(j).getName().toString()==searchFor.assignedServant.getName().toString())
				{
					System.out.println("Target Found: "+searchFor.assignedServant.getName().toString());
						holyGrailWar.totalServants().get(j).restrictions.add(servantInControl);
						check.updateMasters();
						check.checkLives(holyGrailWar.totalServants().get(j));				}
				else {}}}
		else {			
			}
	
	}
	public void hitTarget(String np) {
		if(searchFor.status==true)
		{
			for(int j=0;j<holyGrailWar.totalServants().size();j++)
			{
				if(holyGrailWar.totalServants().get(j).getName().toString()==searchFor.assignedServant.getName().toString())
				{
					System.out.println("Target Found: "+searchFor.assignedServant.getName().toString());
						cause.chooseAction(np, holyGrailWar.totalServants().get(j));
						check.playAnalysis();
//						check.updateMasters();
//						check.checkDeathEffects();
//						check.checkLives(holyGrailWar.totalServants().get(j));				
						}
				else {}}}
		else {			
			}
	}	
	public void assignNPs(String n, heroic_Spirits h) {                                                                      
		switch(n) {
		case "Achilles":{
			h.noble_Phantasm="1NP:Eliminate One || 2NP(Required):Protect self and teammates for one turn from NPs";
			h.npRequired=0;
	}	break;
		case "Arash":{
			h.noble_Phantasm="1NP:Choose a master. Elimate all servants on their deck then discard Arash";
			h.npRequired=1;
	}	break;
		case "Atalante":{
			h.noble_Phantasm="1NP:Eliminate One Servant From Each Master then discard Atalante";
			h.npRequired=1;
	}	break;
		case "Artoria":{
			h.noble_Phantasm="2NP:Eliminate All Servants From All Enemy Masters";
			h.npRequired=2;
		}	break;
		case "Cu Chulainn":{
			h.noble_Phantasm="(NP Required) Eliminate One";
			h.npRequired=1;
		}	break;
		case "Emiya":{
			h.noble_Phantasm="";
		}	break;
		case "Euryale":{
			h.noble_Phantasm="";
		}	break;
		case "Heracles":{
			h.noble_Phantasm="";
			h.npRequired=1;
		}	break;
		case "Jason":{
			h.noble_Phantasm="";
		}	break;
		case "Kama":{
			h.noble_Phantasm="";
		}	break;
		case "Nitocris":{
			h.noble_Phantasm="1NP(Required):Repeat Master's Turn||2NP(Required):Eliminate all king servants except Nitocris and Ozymandias.";
		}	break;
		case "William Shakespeare":{
			h.noble_Phantasm="";
		}	break;
		default:
			System.out.println("None");
		}		
	}	
	public void activate(String npName) {
		
		if(this.user.npSealed=="Disabled") {
			System.out.println("Noble Phantasm Disabled. "+this.user.getName()+" cannot use NP.");
		}
		else {
			if(this.user.npHeld==0 && this.user.npRequired==0) 
			{
				this.user.selfSacrifice();
			}	
			else {}
			if(this.user.npHeld==0 && this.user.npRequired>0)
			{System.out.println(this.user.getName()+" cannot use NP. Need "+(this.user.npRequired-this.user.npHeld)+" more.");}
			else {
				if(this.targeted.npProtection>0) {
					System.out.println(this.targeted.getName()+" cannot be targeted for NP. (-1 NP Protection).");
				}
				else {
		System.out.println(this.user.getName()+" uses ");
		System.out.println("*****************************************************************************");
		System.out.println("*                                                                           *");
		System.out.println("*                                                                           *");


		switch(npName) {
		case "Achilles":{
				achillesNP();
		}	break;
		case "Arash":{
			arashNP();
		}	break;
		case "Atalante":{
			atalanteNP();
		}	break;
		case "Artoria":{
				artoriaNP();
				check.pause();
		}	break;
		case "Emiya":{
				emiyaNP();
		}	break;
		case "Euryale":{
				euryaleNP();
		}	break;
		case "Heracles":{
				heraclesNP();	
		}	break;
		case "Jason":{
				jasonNP();	
		}	break;
		case "Kama":{
				kamaNP();	
		}	break;
		case "Nitocris":{
				nitocrisNP();
		}	break;
		case "William Shakespeare":{
				williamShakespeareNP();
		}	break;
		default:{
			System.out.println("				   None");}
		}		
		checkSelfSacrifice();
		System.out.println("*                                                                           *");
		System.out.println("*                                                                           *");
		System.out.println("*****************************************************************************");
			}}
		}
	}
	public void override(String npName, heroic_Spirits hes) {
		this.user=hes;
		switch(npName) {
		case "Arash":{
			arashNP();
		}	break;
		default:
			System.out.println("None");
		}		
	}
	private void checkSelfSacrifice() {
		if(this.user.sacrifice==true) {
			this.user.takeLife();
			System.out.println(this.user.getName()+" has used their spirit origin to use their NP. Fading away...");
			check.playAnalysis();
		}
	}
	//Library of Servants' Noble Phantasms=======================================================================================================================================	
	private void achillesNP() {
		int randomNP = new Random().nextBoolean() ? 1 : 2;
		if(this.user.npHeld==0) {
			randomNP=1;
		}
		switch(randomNP) {
		case 1:{
			System.out.println("			 "+"Noble Phantasm, Troias Tragōidia!");
			searchFor.excludingSelf("Any","Any","Achilles");
			searchFor.servantChoice();
			hitTarget("takeLife");	
			check.playAnalysis();
			searchFor.clearList();
			this.user.npHeld--;
		}break;
		case 2:{
			if(this.user.npHeld<2)
			{
				System.out.println("Insufficient Mana. Need "+(2-this.user.npHeld)+" more NP card.");
			}else {
			System.out.println("			 "+"Noble Phantasm, Akhilleus Kosmos");
			{
			searchFor.selfAndTeammates(this.user.master);
			for(int i=0; i<searchFor.temp.size(); i++)
			searchFor.servantChoice();
			hitTarget("protectFromNP");	
			check.playAnalysis();
			}			
			this.user.npHeld--;
			this.user.npHeld--;
			searchFor.clearList();
			}
		}break;
		default:
		}			
	}
	private void arashNP() {
		System.out.println("			"+"Noble Phantasm... STELLAAAAA!!");
		searchFor.excludingSelf("Master","AnyMaster","Arash");
		int numTimes = searchFor.temp.size();
		for(int i=0; i<numTimes;i++) 
		{
		searchFor.servantChoice();
		hitTarget("takeLife");	
		check.playAnalysis();
		}
		searchFor.clearList();
 
		this.user.selfSacrifice();
	}
	private void artoriaNP() {
		if(this.user.npHeld<2)
		{
			System.out.println("Insufficient Mana. Need "+(2-this.user.npHeld)+" more NP card.");
		}else {
			System.out.println("			  "+"Noble Phantasm... EXCALIBUR!!");
		{
		searchFor.excludingSelf("Any", "Any", "Artoria");
		for(int i=0; i<searchFor.temp.size(); i++)
		searchFor.servantChoice();
		hitTarget("takeLife");	
		check.playAnalysis();
		}			
		this.user.npHeld--;
		this.user.npHeld--;
		searchFor.clearList();
		}
	}
	private void atalanteNP() {
		System.out.println("  "+"Noble Phantasm...  Phoebus Catastrophe:Complaint Message on the Arrow!!");
		searchFor.excludingSelf("Master","EachMaster","Atalante");
		if(this.user.npSealed=="Enabled")
		{
		searchFor.removeType("Child");
		}
		
		if(searchFor.temp.size()>0) {
		int numTimes = searchFor.temp.size();
		for(int i=0; i<numTimes;i++) 
		{
		searchFor.servantChoice();
		hitTarget("takeLife");	
		check.playAnalysis();
		}
		searchFor.clearList();
		this.user.npHeld--;
		this.user.selfSacrifice();}
		else {}
	
	}
	private void heraclesNP() {
			System.out.println("	Noble Phantasm... Nine Lives: Shooting the Hundred Heads");
			searchFor.excludingSelf("Any","Any","Heracles");
			searchFor.servantChoice();
			hitTarget("takeLife");	
			check.playAnalysis();
			searchFor.clearList();
			this.user.npHeld--;
		}
	private void emiyaNP() {
		System.out.println("	 "+"I am the bone of my sword... Unlimited BladeWorks");
		for(int i=0; i<3; i++) {
			searchFor.excludingSelf("Species","Human","Emiya");
			searchFor.servantChoice();
			hitTarget("takeLife");
			check.playAnalysis();
			searchFor.clearList();
		}
		this.user.npHeld--;
}
	private void euryaleNP() {
		System.out.println("			 "+"==Noble Phantasm==");
		searchFor.excludingSelf("Any","Any","Euryale");
		searchFor.servantChoice();
		hitTarget("takeLife");	
		check.playAnalysis();
		searchFor.clearList();
		this.user.npHeld--;
}	
	private void jasonNP() {
		System.out.println("			 "+"==Astrapste Argo==");
		System.out.println("		    	"+"==COME MY ARGONAUTS==");
		for(int i=0;i<holyGrailWar.totalServants().size();i++)
		{
			for(int a=0;a<holyGrailWar.totalServants().get(i).extraTraits.size();a++)
			{
				if(holyGrailWar.totalServants().get(i).extraTraits.get(a)=="Argonaut") {
					if(holyGrailWar.totalServants().get(i).master==this.user.master) {
					}
					
					else{
					System.out.println(holyGrailWar.totalServants().get(i).getName()+
							" has changed masters ("+holyGrailWar.totalServants().get(i).master+"->"+this.user.master+")");
					
					for(int m=0;m<holyGrailWar.masters().size();m++) {
						if(holyGrailWar.masters().get(m).masterNumber==holyGrailWar.totalServants().get(i).master) {
							holyGrailWar.masters().get(m).numOfServants--;					
							System.out.println("Master "+holyGrailWar.masters().get(m).masterNumber+
									" has "+holyGrailWar.masters().get(m).numOfServants + " left.");
						}
					}
					
					holyGrailWar.totalServants().get(i).master=this.user.master;

					check.updateMasters();
						}	
				}
			}
		}
		this.user.npHeld--;
	}
	private void kamaNP() {		
		System.out.println("				"+"--Noble Phantasm.--");
		searchFor.includingSelf("Gender", "M");
		int numTimes = searchFor.temp.size();
		for(int i=0; i<numTimes;i++) {
			searchFor.servantChoice();
			hitTarget("charm");
			check.playAnalysis();
		}
		searchFor.clearList();
		this.user.npHeld--;
	}
	private void nitocrisNP() {
	int randomNP = new Random().nextBoolean() ? 1 : 2;
	switch(randomNP) {
	case 1:{
		System.out.println("	     "+"Noble Phantasm... Anpu Neb Ta Djeser...");
		for(int m=0;m<holyGrailWar.masters().size();m++) {
			if(holyGrailWar.masters().get(m).masterNumber==this.user.master) {
				holyGrailWar.masters().get(m).extraTurns++;
			}
		}
		check.playAnalysis();
		this.user.npHeld--;
	}break;
	case 2:{
		if(this.user.npHeld<2)
		{
			System.out.println("Insufficient Mana. Need "+(2-this.user.npHeld)+" more NP Card.");
		}
		else {
		System.out.println("	     "+"Noble Phantasm... ANPU NEB TA DJESER!!");
		for(int i=0; i<2; i++)
		{
		searchFor.excludingSelf("Extra","King","Nitocris");
		searchFor.removeServant("Ozymandias");
		searchFor.servantChoice();
		hitTarget("takeLife");	
		check.playAnalysis();
		this.user.npHeld--;
		}searchFor.clearList();
		this.user.selfSacrifice();}
	}break;
	default:{}}
	}	
	private void williamShakespeareNP() {
		System.out.println("				 "+"==Noble Phantasm==");
		
		searchFor.excludingSelf("Any","Any","William Shakespeare");
		searchFor.servantChoice();
		
		addRestriction("William Shakespeare");
		ongoingHit("disableNP",1);
		
		check.playAnalysis();
		this.user.npHeld--;

		searchFor.clearList();
	}

	
	
}
