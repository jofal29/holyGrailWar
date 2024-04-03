package Fate;

import java.util.Random;

public class effect {
	items remove = new items();
	play insurance = new play();
	
	effect(){}
	
	public void deathEffects(String nameOfDeadServant) {
		switch(nameOfDeadServant) {
		case "William Shakespeare":{
			williamShakespeareDeathEffect(nameOfDeadServant);
		}
		break;
		case "Arash":{
			arashSkillDeathEffect(nameOfDeadServant);
		}
		break;
		default:{
			System.out.println("No death effects");
			}
		}
	}
	private void arashSkillDeathEffect(String deathName) {
		insurance.pause();
		for(int i=0; i<holyGrailWar.totalServants().size();i++) {
			if(holyGrailWar.totalServants().get(i).getName()==deathName &&
					holyGrailWar.totalServants().get(i).npSealed=="Enabled") {
				if(holyGrailWar.totalServants().get(i).npCharge==2) {
					if(holyGrailWar.totalServants().get(i).sacrifice==true)
					{}else {
					System.out.println("But with his last breath & 2np charges, he activates his");
					holyGrailWar.totalServants().get(i).npCharge--;
					holyGrailWar.totalServants().get(i).npCharge--;
					holyGrailWar.totalServants().get(i).npHeld++;
					noblePhantasm np = new noblePhantasm();
					np.override(deathName,holyGrailWar.totalServants().get(i));
					insurance.pause();
					}

				}
			}
		}		
	
	}
	private void williamShakespeareDeathEffect(String deathName) {
		for(int i=0; i<holyGrailWar.totalServants().size();i++) {
			for(int size=0; size<holyGrailWar.totalServants().get(i).restrictions.size();size++) {
				if(holyGrailWar.totalServants().get(i).restrictions.get(size)==deathName) {
					//remove.chooseOngoing("npSeal", holyGrailWar.totalServants().get(i), -1);
					holyGrailWar.totalServants().get(i).npSealed="Enabled";
					System.out.println("NP Seal from "+deathName+" has been removed from "+holyGrailWar.totalServants().get(i).getName());
					holyGrailWar.totalServants().get(i).restrictions.remove(deathName);
					insurance.checkLives(holyGrailWar.totalServants().get(i));
				}
			}
		}		
	}
}
