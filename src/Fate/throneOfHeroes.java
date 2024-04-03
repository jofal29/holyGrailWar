package Fate;
import java.util.ArrayList;
import java.util.Random;

public class throneOfHeroes {
	
	private ArrayList<heroic_Spirits> servants;
	private Random randomGenerator;
	
	public throneOfHeroes() {
		this.servants = new ArrayList<>();
	}
	
	public void initializeThrone() {
		
		heroic_Spirits achilles = new heroic_Spirits ("Achilles", "M", "Rider","Lawful", "Balanced", "Earth"); 		
		heroic_Spirits arash = new heroic_Spirits ("Arash", "M", "Archer", "Chaotic", "Balanced", "Earth"); 
		heroic_Spirits artoria = new heroic_Spirits("Artoria", "F", "Saber", "Lawful", "Good", "Earth");
		heroic_Spirits emiya = new heroic_Spirits ("Emiya", "M", "Archer", "Neutral", "Balanced", "Human"); 
		heroic_Spirits heracles = new heroic_Spirits("Heracles", "M", "Berserker","Chaotic", "Madness", "Heaven");
		heroic_Spirits jason = new heroic_Spirits("Jason","M","Saber","Lawful", "Good","Earth");
		heroic_Spirits kama = new heroic_Spirits("Kama", "F", "Assassin","Chaotic", "Evil", "Beast");
		heroic_Spirits williamShakespeare = new heroic_Spirits("William Shakespeare", "M", "Caster", "Neutral", "Balanced", "Human");
		heroic_Spirits euryale = new heroic_Spirits("Euryale", "F", "Archer", "Chaotic", "Good", "Heaven");
		heroic_Spirits angra = new heroic_Spirits("Angra Mainyu", "M", "Avenger", "Chaotic", "Evil", "Human");		
		heroic_Spirits nitocris = new heroic_Spirits("Nitocris", "F", "Caster", "Lawful", "Good", "Earth");
		heroic_Spirits cu_Chulainn = new heroic_Spirits("Cu Chulainn", "M", "Lancer", "Lawful", "Balanced", "Heaven");
		heroic_Spirits mataHari = new heroic_Spirits("Mata Hari", "F", "Assassin", "Chaotic", "Balanced", "Human");
		heroic_Spirits frankenstein = new heroic_Spirits("Frankenstein", "F", "Berserker", "Chaotic", "Balanced", "Earth");
		heroic_Spirits jeanneDArc = new heroic_Spirits("Jeanne D Arc", "F", "Ruler","Lawful", "Good", "Star");
		heroic_Spirits medusa = new heroic_Spirits("Medusa", "F", "Rider", "Chaotic", "Good", "Earth");
		heroic_Spirits ereshkigal = new heroic_Spirits("Ereshkigal", "F", "Lancer", "Chaotic", "Evil", "Earth");
		heroic_Spirits cursedArm = new heroic_Spirits("Hassan of the Cursed Arm", "M", "Assassin", "Lawful", "Evil", "Human");
		heroic_Spirits atalante = new heroic_Spirits("Atalante", "F", "Archer", "Neutral", "Evil", "Earth");
		
		this.servants.add(achilles);
		this.servants.add(arash);
		this.servants.add(artoria);		
		this.servants.add(emiya);
		this.servants.add(euryale);
		this.servants.add(heracles);
		this.servants.add(jason);
		this.servants.add(kama);
		this.servants.add(williamShakespeare);
		this.servants.add(mataHari);
		this.servants.add(medusa);
		this.servants.add(jeanneDArc);
		this.servants.add(nitocris);
		this.servants.add(cu_Chulainn);
		this.servants.add(angra);
		this.servants.add(ereshkigal);
		this.servants.add(cursedArm);
		this.servants.add(frankenstein);
		this.servants.add(atalante);
				
		assignTraits();
		assignSkills();
		assignNoblePhantasms();

	}



	private void assignNoblePhantasms() {
		noblePhantasm initializeNPs = new noblePhantasm();
		for(int np=0; np<this.servants.size();np++)
		{
			initializeNPs.assignNPs(this.servants.get(np).getName(),this.servants.get(np));
		}		
	}

	private void assignSkills() {
		skill initialize = new skill();
		for(int s=0; s<this.servants.size();s++)
		{
			initialize.checkSkills(this.servants.get(s).getName(),this.servants.get(s));
		}
	}

	public ArrayList<heroic_Spirits> getServants() {
		return servants;
	}
	
	public ArrayList<String> returnArgonauts(){
		return this.argonauts;
	}

	public void setServants(ArrayList<heroic_Spirits> servants) {
		this.servants = servants;
	}
	
	//List of unsummoned servants
	public void unsummoned() {
		System.out.println("**************************UnSummoned**************************");
			for (int i=0; i<servants.size(); i++) {
				heroic_Spirits tempServant = servants.get(i);				
				System.out.println("\n");
				tempServant.stats();
			}
			System.out.println("-----------------------------------------------------------------------");
	}
	
	//Summoning methods
	public heroic_Spirits summon(String className) {
		randomGenerator = new Random();
		heroic_Spirits tempServant = new heroic_Spirits();
		
		while(tempServant.getHg_class() != className) {
		int index = randomGenerator.nextInt(servants.size());
		tempServant = servants.get(index);
		}
		return tempServant;
	}
	
	public heroic_Spirits summonAny() {
		randomGenerator = new Random();
		heroic_Spirits tempServant = new heroic_Spirits();
		int index = randomGenerator.nextInt(servants.size());
		tempServant = servants.get(index);
		servants.remove(index);
		return tempServant;
	}
	
	public heroic_Spirits summonSingle(String servantName) {
		randomGenerator = new Random();
		heroic_Spirits tempServant = new heroic_Spirits();
		while(tempServant.getName() != servantName) {
		int index = randomGenerator.nextInt(servants.size());
		tempServant = servants.get(index);
		}
		return tempServant;
	}
	
	public heroic_Spirits chooseServant() {
		randomGenerator = new Random();
		int index = randomGenerator.nextInt(servants.size());
		heroic_Spirits tempServant = servants.get(index);
		servants.remove(tempServant);
		return tempServant;
	}
	
/********************************************************************************************************************************************************************************/
	private ArrayList<String> greeks;
	private ArrayList<String> argonauts;
	private ArrayList<String> kings;
	private ArrayList<String> divine;
	private ArrayList<String> kotrt;
	private ArrayList<String> children;

	
	
	public ArrayList<String> getGreeks() {
		return greeks;
	}
	public void setGreeks(ArrayList<String> greeks) {
		this.greeks = greeks;
	}
	public ArrayList<String> getArgonauts() {
		return argonauts;
	}
	public void setArgonauts(ArrayList<String> argonauts) {
		this.argonauts = argonauts;
	}
	public ArrayList<String> getKings() {
		return kings;
	}
	public void setKings(ArrayList<String> kings) {
		this.kings = kings;
	}
	public ArrayList<String> getDivine() {
		return divine;
	}
	public void setDivine(ArrayList<String> divine) {
		this.divine = divine;
	}
	public ArrayList<String> getKotrt() {
		return kotrt;
	}
	public void setKotrt(ArrayList<String> kotrt) {
		this.kotrt = kotrt;
	}
	public ArrayList<String> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<String> children) {
		this.children = children;
	}
	
	//Assigning Extra Traits
	private void assignTraits() {
		for(int t=0;t<this.servants.size();t++) {
			addToArgonauts(this.servants.get(t));
			addToGreeks(this.servants.get(t));
			addToKings(this.servants.get(t));
			addToDivine(this.servants.get(t));
			addToRoundTable(this.servants.get(t));
			addToChildren(this.servants.get(t));
			}
	}
	private void addToChildren(heroic_Spirits child) {
		//King Trait
		this.children = new ArrayList<String>();
		this.children.add("Euryale");
		
		for(int a=0;a<this.children.size();a++)
		{
			if(this.children.get(a)==child.getName()) {
				child.extraTraits.add("Child");
			}
		}
	}	
	private void addToDivine(heroic_Spirits divinity) {
		//King Trait
		this.divine = new ArrayList<String>();
		this.divine.add("Ereshkigal");
		this.divine.add("Euryale");
		this.divine.add("Jason");
		this.divine.add("Nitocris");
		this.divine.add("Medusa");

		
		for(int a=0;a<this.divine.size();a++)
		{
			if(this.divine.get(a)==divinity.getName()) {
				divinity.extraTraits.add("Divine");
			}
		}
	}	
	private void addToRoundTable(heroic_Spirits knight) {
		//King Trait
		this.kotrt = new ArrayList<String>();
		this.kotrt.add("Artoria");
		for(int a=0;a<this.kotrt.size();a++)
		{
			if(this.kotrt.get(a)==knight.getName()) {
				knight.extraTraits.add("Round Table");
			}
		}
	}
	private void addToKings(heroic_Spirits king) {
		//King Trait
		this.kings = new ArrayList<String>();
		this.kings.add("Ereshkigal");
		this.kings.add("Artoria");
		this.kings.add("Nitocris");


		for(int a=0;a<this.kings.size();a++)
		{
			if(this.kings.get(a)==king.getName()) {
				king.extraTraits.add("King");
			}
		}
	}
	private void addToGreeks(heroic_Spirits greek) {
		//Greek Trait
		this.greeks = new ArrayList<String>();
		this.greeks.add("Jason");
		this.greeks.add("Atalante");
		this.greeks.add("Heracles");
		this.greeks.add("Medea");
		this.greeks.add("Achilles");
		this.greeks.add("Medusa");

		for(int a=0;a<this.greeks.size();a++)
		{
			if(this.greeks.get(a)==greek.getName()) {
				greek.extraTraits.add("Greek");
			}
		}
	}
	private void addToArgonauts(heroic_Spirits argo) {
		//Argonauts List
		this.argonauts = new ArrayList<String>();
		this.argonauts.add("Jason");
		this.argonauts.add("Atalante");
		this.argonauts.add("Heracles");
		this.argonauts.add("Medea");
		
		for(int a=0;a<this.argonauts.size();a++)
		{
			if(this.argonauts.get(a)==argo.getName()) {
				argo.extraTraits.add("Argonaut");
			}
		}
	}	

}
