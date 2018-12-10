package pokerHandsKata;
//Tobias Stecker

public class PokerHandsKataDecemberSeventh {
	public static void main(String[] args) {
		//entry point
		// test data
		//PokerHand hand = new PokerHand();
		
		PokerHand h1 = new PokerHand("2H 3D 5S 9C KD");
		
		PokerHand straightFlush = new PokerHand("2H 1H 3H 4H 5H");
		PokerHand straightFlush2 = new PokerHand("2D 1D 3D 4D 5D");
		PokerHand fourOfKind = new PokerHand("2H 2D 3D 2S 2C");
		PokerHand fourOfKind_Lower = new PokerHand("1H 1D 3D 1S 1C");
		PokerHand fullHouse = new PokerHand("3H 3C 3D AC AD");
		PokerHand fullHouse_Lower = new PokerHand("2H 2C 2D AC AD");
		PokerHand flush = new PokerHand("AH 3H 4H 5H 6H");
		PokerHand flush_lower = new PokerHand("5H 4H 3H 2H 7H");
		PokerHand straight = new PokerHand("5D 9H 7H 8H 6H");
		PokerHand straight_lower = new PokerHand("2D 4h 3h 5h 6h");
		PokerHand threeOfAKind = new PokerHand("AC AS AH 2h 3C");
		PokerHand threeOfAKind_lower = new PokerHand("5C 5S 5H 2C 3H");
		
	
		Dealer.startGame(threeOfAKind, threeOfAKind_lower);
	}
}