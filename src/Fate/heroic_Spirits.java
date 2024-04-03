package Fate;

import java.util.ArrayList;

public class heroic_Spirits implements Cloneable {
	//Attributes
	String name;	String gender;	String axis;	String alignment;
	String species;	String hg_class;String npName;	noblePhantasm np;
	String noble_Phantasm;	String skill;	
	
	String npSealed = "Enabled";
	String skillSealed = "Enabled"; 
	String usableSkill = "";
	
	int npHeld = 0;			int npRequired = 1;
	int lives = 1; 			int ongoingLives = 0;
	int originalMaxHealth = 3;
	int maxHealth = 3; 		int ongoingMaxHealth = 0;
	int hearts = 3; 		int ongoingHearts = 0;
	int npCharge = 0;		int npMaxCharges = 3;		int ongoingNpCharge = 0;
	int curses = 0; 		int ongoingCurses = 0;
	int defense = 0; 		int ongoingDefense = 0;
	int turnsFrozen = 0; 	int ongoingFrozen = 0;
	int master = 0; 		int ongoingMaster = 0;
	int npSeals = 0; 		int npProtection = 0;		int ongoingNpSeals = 0;
	
	boolean sacrifice = false;
	boolean deathbyAttack = false;
	
	public ArrayList<items> ownedItems;
	public ArrayList<String> immuneTo = new ArrayList<>();
	public ArrayList<String> restrictions = new ArrayList<>();
	public ArrayList<String> extraTraits = new ArrayList<>();
	
	//Constructor
	public heroic_Spirits() {
		super();
		name = "";
		gender = "";
		axis = "";
		alignment = "";
		species = "";
		hg_class = "";
		noble_Phantasm = "";
		skill = "";
	}
	
	public heroic_Spirits(String name, String gender, String hg_class, String axis, String alignment, String species) {
		super();
		this.name = name;
		this.gender = gender;
		this.hg_class = hg_class;		
		this.axis = axis;		
		this.alignment = alignment;
		this.species = species;


	}

	//Setters and Getters
	public double noblePhantasm() {
		return 0;
	}

	public String getName() {
		return name;
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getHg_class() {
		return hg_class;
	}

	public void setHg_class(String hg_class) {
		this.hg_class = hg_class;
	}

	public static heroic_Spirits clone(heroic_Spirits heroic_Spirits) {
		return heroic_Spirits;
	}
	
	//Methods
	public String genderName()
	{
		if (this.gender == "F")
		{
			return "Female";
		}
		if (this.gender == "M")
		{
			return "Male";
		}
		else
		{
			return "netruel";
		}
	}
	
	public void takeLife() {
		lives--;
		if(lives>0)
		{
			hearts = maxHealth;
			System.out.println(name + " loses a life.");
		}
		else
		{
			hearts = 0;
		}
	}
	
	public void checkHealth() {
		if (hearts<=0) {
			this.lives=this.lives-1;
			if(lives>0) {
			System.out.println(this.name + " -1 life");
			}else {}
		}
		else {
			if(defense>0)
			{
			System.out.println(this.name+ ": " + defense + " Shields Active.");
			}
			else {}
	
			System.out.println(this.name + ": " + hearts + " Health Remaining.");
		}
		
		if ((maxHealth<=0 && lives>0) || (lives>0 && hearts<=0))
		{
			maxHealth = originalMaxHealth;
			hearts = maxHealth;
		}
		else {}
		
		if(hearts>maxHealth) {
			hearts=maxHealth;
		}
	}
	
	public void loseHearts() {
		hearts = hearts - 1;
	}
	
	public void gainHearts() {
		if (hearts<this.maxHealth)
		{
		hearts = hearts + 1;
		System.out.println(this.name + ": +1 Health");
		}
		else
		{
			System.out.println(this.name + ": Max Health");

		}
	}
	
	public boolean turnCheck() {
		if(this.turnsFrozen>0) {
			turnsFrozen--;
			return false;
		}
		else {
			return true;
		}
	}
	
	public String setNP() {
		this.npName = this.getName()+"NP";
		return this.npName;
	}

	public void stats() {
		System.out.println
		   ("Name: 	 	"+ this.name + "\n" +
			"Gender: 	"+ genderName() + "\n" +
			"Class:  	"+ this.hg_class + "\n" +
			"Axis:		"+ this.axis + "\n" +
			"Alignment:	"+ this.alignment + "\n" +
			"Type:		"+ this.species + "\n" +
			"Noble Phantasm:	"+ this.noble_Phantasm + "\n" +
			"Skill:		"+ this.skill + "\n" +
			"Master: 	"+ this.master);
		
	}
	
	public ArrayList<items> returnItems() {
		return this.ownedItems;
	}
	
	public ArrayList<String> immune() {

		return this.immuneTo;
	}
	
	public ArrayList<String> returnExtraTraits(){
		return this.extraTraits;	}

	public String checkImmune(String obj) {
		int immunity=0;
		
		for(int g=0;g<immune().size();g++)
		{
		if(obj == immune().get(g)) {
			immunity++;
			}
		else {}
		}
			if(immunity>0)
			{
				immunity=0;
				return "immune";
			}
			else {
				immunity=0;
				return "not immune";
				}
		
	}

	public void selfSacrifice() {
		sacrifice=true;
	}


	
}
