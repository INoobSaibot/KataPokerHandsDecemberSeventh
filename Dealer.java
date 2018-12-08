package pokerHandsKata;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	
	public static void startGame(PokerHand hand1, PokerHand hand2 ) {
		//todo
		if (determineHandType(hand1) 
				== determineHandType(hand2)) {
			// todo : check for high card if hand types are same
			System.out.println("same");
		}
		else {
			//todo if hand types are not same declare winner
			//todo based on type hand type value
			System.out.println("not same");
		}
	}

	
	private static HandType determineHandType(PokerHand hand) {
		// TODO Auto-generated method stub
		//System.out.println(is_straightFlush(hand));
		if(is_straightFlush(hand)) {
			return HandType.STRAIGHT_FLUSH;
		}
		return null;
	}

	
	private static boolean is_straightFlush(PokerHand hand) {
		// TODO Auto-generated method stub
		//suits match
		Suit compareSuit = hand.iterator().next().getSuit();
		for(Card c : hand) {
			if (!(c.getSuit() == compareSuit)) {
				return false;
			}
		}
		
		if(consecutiveValues(hand)) {
			return true;
		} 
		else
			return false;
	}

	
	private static boolean consecutiveValues(PokerHand hand) {
		// TODO Auto-generated method stub
		//list of ranks
		List<Integer> ranksList = new ArrayList();
		
		for(Card c : hand) {
			//System.out.println(c.getRank() + " =>");
			ranksList.add(c.getRank());
		}
		
		// put those values in order to prepare for consecutive test
		ranksList.sort(null);
		
		for(int i = 1; i < ranksList.size(); i++) {
			//previous int and next int consecutive
			if(!((ranksList.get(i-1)+1) == ranksList.get(i))) {
				//System.out.println(ranksList.get(i-1) + " then " + ranksList.get(i));
				return false;
			}
		}
		// todo?
		return true;
	}
	
	
	//eof
}
