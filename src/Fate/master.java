package Fate;

import java.util.ArrayList;

public class master {
	int masterNumber = 0;
	int turnsFrozen = 0;
	int maxServants = 0;
	int numOfServants = 0;
	int active = 1;
	int extraTurns = 0;
	
	public ArrayList<heroic_Spirits> servants = new ArrayList<>();
	
	public master(int masterNum, int numServants) {
		masterNumber = masterNum;
		maxServants = numServants;
		numOfServants = maxServants;
		System.out.println(masterNumber+" || "+numOfServants);
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
		
	
}
