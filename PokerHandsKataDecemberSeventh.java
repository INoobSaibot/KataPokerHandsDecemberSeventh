package pokerHandsKata;
//Tobias Stecker

public class PokerHandsKataDecemberSeventh {
	public static void main(String[] args) {
		//entry point
		
		// test data
		
		
		PokerHand h1 = new PokerHand("2H 3D 5S 9C KD");
		PokerHand straightFlush = new PokerHand("2H 1H 3H 4H 5H");
		PokerHand straightFlush2 = new PokerHand("2D 1D 3D 4D 5D");
	
		Dealer.startGame(straightFlush, straightFlush2);
	}
}