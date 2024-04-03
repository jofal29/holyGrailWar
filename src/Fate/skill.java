package Fate;

public class skill {
	String firstCheck = "";
	String secondCheck = "";
	skill(){}
	
	public void checkSkills(String servantCheck, heroic_Spirits heroicSpirit) {
		onSummon(servantCheck, heroicSpirit);
		onGoing(servantCheck, heroicSpirit);
	}
	
	public String returnCheck() {
		if(firstCheck == "None" && secondCheck == "None")
		{
			return "";
		}
		else {
			return "";
		}
	}
	
	public void onSummon(String servant, heroic_Spirits familiar) {
		switch(servant) {
		case "Heracles":{
			heraclesSkill(familiar);
		}break;
		default:{}
		}
	}
	public void movePlay(String servant, heroic_Spirits familiar) {
		switch(servant) {
		case "":{
		}break;
		default:{secondCheck="None";}
		}
	}	
	public void onGoing(String servant, heroic_Spirits familiar) {
		switch(servant) {
		case "Achilles":{
			achillesSkill(familiar);
		}break;
		case "Arash":{
			arashSkill(familiar);
		}break;
		case "Atalante":{
			atalanteSkill(familiar);
		}break;
		case "Cu Chulainn":{
			cuChulainnSkill(familiar);
		}break;		
		case "Nitocris":{
			nitocrisSkill(familiar);
		}break;
		default:{firstCheck="None";}
	}}
	
	private void arashSkill(heroic_Spirits h) {
		h.skill="If eliminated and has 2 np charges, activate NP before discarding(Ongoing)";
		if(h.skillSealed=="Enabled"){}
		if(h.skill=="Disabled"){
			System.out.println(h.skill+"[DISABLED]");}
		if(h.skillSealed=="Protected"){
			System.out.println("Skill cannot be disabled.");}
	}
	private void atalanteSkill(heroic_Spirits h) {
		h.skill="Cannot Target or Elimate Children(Ongoing)";
		if(h.skillSealed=="Enabled"){}
		if(h.skill=="Disabled"){
			System.out.println(h.skill+"[DISABLED]");}
		if(h.skillSealed=="Protected"){
			System.out.println("Skill cannot be disabled.");}
	}
	private void nitocrisSkill(heroic_Spirits h) {
		h.skill="2 NP Charges=1NP(Ongoing)";
		if(h.skillSealed=="Enabled"){
			h.npMaxCharges=2;}
		if(h.skill=="Disabled"){
			h.npMaxCharges=3;
			System.out.println(h.skill+"[DISABLED]");}
		if(h.skillSealed=="Protected"){
			System.out.println("Skill cannot be disabled.");}
	}

	private void cuChulainnSkill(heroic_Spirits h) {
		h.skill="+1 Guts (Ongoing)";
		if(h.skillSealed=="Enabled"){
			h.lives++;}
		if(h.skill=="Disabled"){
		h.lives--;
		System.out.println(h.skill+"[DISABLED]");
		h.checkHealth();}
		if(h.skillSealed=="Protected"){
			System.out.println("Skill cannot be disabled.");}
	}

	private void achillesSkill(heroic_Spirits h) {
		h.skill="+1 Max Health (Ongoing)";
		if(h.skillSealed=="Enabled"){
			h.maxHealth++;
			h.hearts=h.maxHealth;}
		if(h.skillSealed=="Disabled"){
		h.maxHealth--;
		System.out.println(h.skill+"[DISABLED]");
		h.checkHealth();}
		if(h.skillSealed=="Protected"){
			System.out.println("Skill cannot be disabled.");}
	}
	
	private void heraclesSkill(heroic_Spirits h) {
		h.skill="12 Lives (Cannot Deactivate)";
		h.lives=12; h.maxHealth=1; h.originalMaxHealth=1; h.hearts=1;
	}
}
