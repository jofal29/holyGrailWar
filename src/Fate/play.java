package Fate;
import java.util.ArrayList;
import java.util.Random;

public class play {
	
	
	
//	heroic_Spirits S1 = new heroic_Spirits();
//	heroic_Spirits S2 = new heroic_Spirits();
	
	Random rando = new Random();
	private ArrayList<heroic_Spirits> summonedServants;
	items useItem = new items();
	int turnNumber = 0;
	int masterFocusNumber = 0;
	heroic_Spirits serv1;
	heroic_Spirits serv2;
	
	public void gameTurn() {
		turnNumber++;
		System.out.println("\n"+"\n" + "~~~~~~~~~~~~~~~~~~~~~~ Fate/Fractured Reality: Round " + turnNumber +" ~~~~~~~~~~~~~~~~~~~~~~");
		
		this.summonedServants = holyGrailWar.totalServants();
		
		masterFocusNumber=0;
		for(int m=0;m<holyGrailWar.masters().size();m++) {

			checkOngoing();
			masterTurn(m);
			startOfMasterTurn();
			
			//Check if master is stunned
			if(holyGrailWar.masters().get(m).turnsFrozen==0)
					{
			chooseServants(masterFocusNumber);
		
			useItem.randomPlay(serv1,serv2);
			
			System.out.println("");	
			extraTurn();
			
			playAnalysis();
					
			endOfMasterTurn();	
						}
			else {
				System.out.println("Unable to make any moves: Master is Stunned");
				holyGrailWar.masters().get(m).turnsFrozen--;
				endOfMasterTurn();
			}
			
		}
		checkOngoing();
		currentStats();
	}
	
	private void extraTurn() {
		for(int ma=0;ma<holyGrailWar.masters().size();ma++) {
			if(holyGrailWar.masters().get(ma).masterNumber==this.masterFocusNumber) {
				if(holyGrailWar.masters().get(ma).extraTurns>0) {
					
					checkOngoing();
					System.out.println("		  	    *Master #: "+this.masterFocusNumber+"'s Turn:*");
					for(int e=0; e<holyGrailWar.masters().get(ma).extraTurns; e++) {
					chooseServants(this.masterFocusNumber);
					holyGrailWar.masters().get(ma).extraTurns--;
					useItem.randomPlay(serv1,serv2);
			
			
			playAnalysis();
			
			System.out.println("");
		}}}}}

	public void playAnalysis() {
		defeatUpdate();
		checkDeathEffects();			
		updateMasters();		
		updateStats();
	}

	private void defeatUpdate() {
		for (int i=0; i<holyGrailWar.totalServants().size(); i++)
		{
			if(holyGrailWar.totalServants().get(i).lives == 0)
			{	
				System.out.println(holyGrailWar.totalServants().get(i).getName() + " has been defeated.");
			}
			else {}
		}		
	}

	public void checkDeathEffects() {
		for(int x=0;x<holyGrailWar.totalServants().size();x++) {
			if(holyGrailWar.totalServants().get(x).lives==0)
			{
				effect getEffect = new effect();
				getEffect.deathEffects(holyGrailWar.totalServants().get(x).getName());
				}
			}
		}

	private void checkOngoing() {
		
		for(int i=0;i<holyGrailWar.totalServants().size();i++) {
			 if(holyGrailWar.totalServants().get(i).ongoingCurses!=0) {
				holyGrailWar.totalServants().get(i).curses=holyGrailWar.totalServants().get(i).curses+holyGrailWar.totalServants().get(i).ongoingCurses;}
			
			 if(holyGrailWar.totalServants().get(i).ongoingDefense==1) {
				holyGrailWar.totalServants().get(i).defense++;}
			if(holyGrailWar.totalServants().get(i).ongoingDefense==-1) {
				holyGrailWar.totalServants().get(i).defense--;}
			
			if(holyGrailWar.totalServants().get(i).ongoingFrozen==1) {
				holyGrailWar.totalServants().get(i).turnsFrozen++;}
			
			if(holyGrailWar.totalServants().get(i).ongoingHearts==1) {
				holyGrailWar.totalServants().get(i).hearts++;}
			if(holyGrailWar.totalServants().get(i).ongoingHearts==-1) {
				holyGrailWar.totalServants().get(i).hearts--;}
			
			if(holyGrailWar.totalServants().get(i).ongoingLives==1) {
				holyGrailWar.totalServants().get(i).ongoingLives++;}
			
			if(holyGrailWar.totalServants().get(i).ongoingMaster==1) {}
			
			if(holyGrailWar.totalServants().get(i).ongoingMaxHealth==1) {
				holyGrailWar.totalServants().get(i).maxHealth++;}
			if(holyGrailWar.totalServants().get(i).ongoingMaxHealth==-1) {
				holyGrailWar.totalServants().get(i).maxHealth--;}
			
			if(holyGrailWar.totalServants().get(i).ongoingNpCharge==1) {
				holyGrailWar.totalServants().get(i).ongoingNpCharge--;}
			if(holyGrailWar.totalServants().get(i).ongoingNpCharge==-1) {
				holyGrailWar.totalServants().get(i).npCharge--;}
			
			if(holyGrailWar.totalServants().get(i).ongoingNpSeals>0) {
				holyGrailWar.totalServants().get(i).ongoingNpSeals=holyGrailWar.totalServants().get(i).npSeals+holyGrailWar.totalServants().get(i).ongoingNpSeals;}}
	}

	private void endOfMasterTurn() {
		for(int s=0; s<holyGrailWar.totalServants().size();s++) {
			if(holyGrailWar.totalServants().get(s).master==masterFocusNumber)
			{
				if(holyGrailWar.totalServants().get(s).npSeals>0)
				{
				holyGrailWar.totalServants().get(s).npSeals--;
				}
				if(holyGrailWar.totalServants().get(s).npSeals<0)
				{
				holyGrailWar.totalServants().get(s).npSeals=0;
				}
				
				if(holyGrailWar.totalServants().get(s).turnsFrozen>0)
				{
				holyGrailWar.totalServants().get(s).turnsFrozen--;
				}
				if(holyGrailWar.totalServants().get(s).turnsFrozen<0)
				{
				holyGrailWar.totalServants().get(s).turnsFrozen=0;
				}
			}
		}
	}
	
	private void startOfMasterTurn() {

		for(int s=0; s<holyGrailWar.totalServants().size();s++) {
			if(holyGrailWar.totalServants().get(s).master==masterFocusNumber)
			{
				if(holyGrailWar.totalServants().get(s).npProtection>0)
				{
				holyGrailWar.totalServants().get(s).npProtection--;
				}
				if(holyGrailWar.totalServants().get(s).npProtection<0)
				{
				holyGrailWar.totalServants().get(s).npProtection=0;
				}
			}
		}
	}

	private void chooseServants(int masterFocus) {
		
		Random randomGenerator = new Random();
		
		//Choose Servant under that is Master's turn
		int index = randomGenerator.nextInt(holyGrailWar.totalServants().size());
		serv1 = holyGrailWar.totalServants().get(index);
		while (serv1.master != masterFocus)
		{
			index = randomGenerator.nextInt(holyGrailWar.totalServants().size());
			serv1 = holyGrailWar.totalServants().get(index);
		}
		
		//Choose enemy that is NOT a team mate and not themselves		
		index = randomGenerator.nextInt(holyGrailWar.totalServants().size());
		serv2 = holyGrailWar.totalServants().get(index);
		while (serv1.getName() == serv2.getName() || serv1.master == serv2.master)
		{
			index = randomGenerator.nextInt(holyGrailWar.totalServants().size());
			serv2 = holyGrailWar.totalServants().get(index);
		}
	}

	private void masterTurn(int masterT) {
		masterFocusNumber = holyGrailWar.masters().get(masterT).masterNumber;
		System.out.println("		  	    *Master #: "+masterFocusNumber+"'s Turn:*");
	}

	public void updateMasters() {
		//update num of servants
		for(int b=0; b<holyGrailWar.masters().size();b++) {
			holyGrailWar.masters().get(b).numOfServants=0;
			for(int sv=0;sv<holyGrailWar.totalServants().size();sv++)
			{
				if(holyGrailWar.masters().get(b).masterNumber==
						holyGrailWar.totalServants().get(sv).master) {
					holyGrailWar.masters().get(b).numOfServants++;
				}
			}
		}
		
		//update on Master's status of being in or out
		for (int i=0; i<holyGrailWar.totalServants().size(); i++)
		{
			if(holyGrailWar.totalServants().get(i).lives==0)
			{
				for (int x=0; x<holyGrailWar.masters().size();x++)
				{
					if(holyGrailWar.masters().get(x).numOfServants == 1 &&
						holyGrailWar.totalServants().get(i).master == holyGrailWar.masters().get(x).masterNumber) {
						holyGrailWar.masters().get(x).numOfServants--;
						System.out.println("==== Master#: "+holyGrailWar.masters().get(x).masterNumber+" is out of the war. ====");
						holyGrailWar.masters().remove(x);}
					else {
						if(holyGrailWar.totalServants().get(i).master == holyGrailWar.masters().get(x).masterNumber) {
							holyGrailWar.masters().get(x).numOfServants--;}
						else {}	
					}
				}
			}
			else {}
		}
		
		//update on if they out in case(double check)
		for (int y=0; y<holyGrailWar.masters().size();y++) {
			if(holyGrailWar.masters().get(y).numOfServants==0)
			{
				System.out.println("==== Master#: "+holyGrailWar.masters().get(y).masterNumber+" is out of the war. ====");
				holyGrailWar.masters().remove(y);
			}
		}
		
	}

	private void currentStats() {
		System.out.println	("========================================================================================");
		System.out.println(  "Lives: | Health: | Defense: | NP Charges: | NPs | Master | Servant");
		System.out.println	("========================================================================================");
		for (int i=0; i<holyGrailWar.totalServants().size(); i++)
		{
			if(holyGrailWar.totalServants().get(i).lives>=10) {
			System.out.println	("  " + holyGrailWar.totalServants().get(i).lives + "        " + holyGrailWar.totalServants().get(i).hearts + "        " + holyGrailWar.totalServants().get(i).defense +"            " + holyGrailWar.totalServants().get(i).npCharge + "          "+ holyGrailWar.totalServants().get(i).npHeld + "      " + holyGrailWar.totalServants().get(i).master + "      " + holyGrailWar.totalServants().get(i).getName());
			}
			else {
			System.out.println	("  0" + holyGrailWar.totalServants().get(i).lives + "        " + holyGrailWar.totalServants().get(i).hearts + "        " + holyGrailWar.totalServants().get(i).defense +"            " + holyGrailWar.totalServants().get(i).npCharge + "          "+ holyGrailWar.totalServants().get(i).npHeld + "      " + holyGrailWar.totalServants().get(i).master + "      " + holyGrailWar.totalServants().get(i).getName());
			}
		}
	}

	private void updateStats() {
		for (int i=0; i<holyGrailWar.totalServants().size(); i++)
		{
			if(holyGrailWar.totalServants().get(i).lives == 0)
			{	
				holyGrailWar.deceased().add(holyGrailWar.totalServants().get(i));
				holyGrailWar.totalServants().remove(i);
			}
			else {}
		}
	}
	
	public void checkLives(heroic_Spirits hS) {
			if(hS.lives==0)
			{
				System.out.println(hS.getName()+" has been defeated.");
				holyGrailWar.deceased().add(hS);
				holyGrailWar.totalServants().remove(hS);
			}
			else {}
		}

	public void pause() {
		try{Thread.sleep(3000);}
		catch (InterruptedException e) {
            e.printStackTrace();
        }
	}


}