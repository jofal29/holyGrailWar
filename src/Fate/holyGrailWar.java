package Fate;

import java.util.ArrayList;
import java.util.Scanner;

public class holyGrailWar {
	int numOfMasters;
	int numOfServants;
	
	private static ArrayList<heroic_Spirits> summonedServants;
	private static ArrayList<heroic_Spirits> deceased;
	private static ArrayList<master> masters;
	
	public holyGrailWar() {
		setUp();
		masterSetUp(numOfMasters,numOfServants);
		theSummoning();
	}
	
	private void setUp() {	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of masters participating.");
		numOfMasters = Integer.parseInt(input.nextLine());
		
		System.out.println("Enter number of servants summoned per master.");
		numOfServants = Integer.parseInt(input.nextLine());
		input.close();
	}

	private void masterSetUp(int totalMasters, int servantsPer) {
		masters = new ArrayList<master>();
		int mastNum = 1;
		for(int i=0;masters.size()<totalMasters;i++) {
			master masterMain = new master(mastNum,servantsPer);
			masterMain.masterNumber=(i+1);
			masters.add(masterMain);
			mastNum++;
		}
	}
	
	private void theSummoning() {
		throneOfHeroes throneOfHeroes = new throneOfHeroes();
		throneOfHeroes.initializeThrone();
		int totalServants = (numOfServants * numOfMasters);
		
		summonedServants = new ArrayList<heroic_Spirits>();
		for(int i=0;summonedServants.size()<totalServants;i++)
		{
			heroic_Spirits Servant = throneOfHeroes.summonAny();
			
			summonedServants.add(Servant);
		}
		
		int numServ = 0;
		for(int i=0; i<numOfMasters;i++) {
			System.out.println("Master "+ i);
			
			for(int s=0;s<numOfServants;s++)
			{
				System.out.println("Servant "+numServ);
				summonedServants.get(numServ).master=(i+1);
				numServ++;
			}
		}
		
		this.deceased = new ArrayList<>();
		
		System.out.println("-----------------------------------Summoned Servants----------------------------------------");
		for (int i = 0; i<summonedServants.size(); i++)
		{
			summonedServants.get(i).stats();
			System.out.println("---------------------------------------------------------------------------------------");
		}		
	}
	private void regularHGW() {
		throneOfHeroes throneOfHeroes = new throneOfHeroes();
		throneOfHeroes.initializeThrone();
		
		this.summonedServants = new ArrayList<>();
			heroic_Spirits Servant1 = throneOfHeroes.summon("Saber");
			heroic_Spirits Servant2 = throneOfHeroes.summon("Lancer");
			heroic_Spirits Servant3 = throneOfHeroes.summon("Archer");
			heroic_Spirits Servant4 = throneOfHeroes.summon("Caster");
			heroic_Spirits Servant5 = throneOfHeroes.summon("Assassin");
			heroic_Spirits Servant6 = throneOfHeroes.summon("Rider");
			heroic_Spirits Servant7 = throneOfHeroes.summon("Berserker");
			
		summonedServants.add(Servant1);
		summonedServants.add(Servant2);
		summonedServants.add(Servant3);
		summonedServants.add(Servant4);
		summonedServants.add(Servant5);
		summonedServants.add(Servant6);
		summonedServants.add(Servant7);
		
		this.deceased = new ArrayList<>();
		
		System.out.println("------------Summoned Servants-----------------");
		for (int b = 0; b<summonedServants.size(); b++)
		{
			summonedServants.get(b).master = b+1;
			summonedServants.get(b).stats();
			System.out.println("-----------------------------------------");
		}		
	}
	
	public void update() {
		for (int i = 0; i<summonedServants.size(); i++)
		{
			System.out.println("\n" + "-----------------------------------------");
			System.out.println(summonedServants.get(i).getName() + " has " + summonedServants.get(i).hearts + " left.");
		}
		for (int i = 0; i<deceased.size(); i++)
		{
			System.out.println("---------------Defeated------------------");
			System.out.println(deceased.get(i).getName() + " has " + deceased.get(i).hearts + " left.");
		}
	}

	public static ArrayList<heroic_Spirits> totalServants() {
		return summonedServants;
	}

	public static ArrayList<heroic_Spirits> deceased() {
		return deceased;
	}
	
	public static ArrayList<master> masters(){
		return masters;
	}
	
	public void winner() {
		if (totalServants().size()>1) {
			System.out.println("\n"+"No Single Winner");
			System.out.println("Master " + masters.get(0).masterNumber + " wins."+"\n" + "Servants: " + "\n" + "------------------------------------");
			for(int i=0;i<summonedServants.size();i++)
			{
			System.out.println(summonedServants.get(i).getName());
			}
		}
		else
		{
			System.out.println("\n" + "Master ID#: "+ masters.get(0).masterNumber + " and "+ summonedServants.get(0).getName() + " are the Winner!");
		}
	}
}