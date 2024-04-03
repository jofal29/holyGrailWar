package Fate;

public class Main {
		public static void main(String[] args) {
			
			
				holyGrailWar hgw5 = new holyGrailWar();
				play Game_One = new play();
				while (holyGrailWar.masters().size()>1) {
					Game_One.gameTurn();	
				}
				hgw5.update();
				hgw5.winner();

		}
}
