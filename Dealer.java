package pokerHandsKata;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	
	public static void startGame(PokerHand hand1, PokerHand hand2 ) {
		//todo
		int rankPlayer1;
		int rankPlayer2;
		
		rankPlayer1 = determineHandType(hand1).getRank();
		rankPlayer2 = determineHandType(hand2).getRank();
		
		
		
		
		// if hand types are the same, then get rank of high card
		//	in hand type ** un-implimented
		if (determineHandType(hand1) 
				== determineHandType(hand2)) {
			// todo : check for high card if hand types are same
			//System.out.println("Hand Types are the same");
			if(hand1.getHighCardRank() > hand2.getHighCardRank()) {
				System.out.println("Black wins. - with " +
				determineHandType(hand1) + ": " + hand1.getHighCardString() +
				" over " + hand2.getHighCardString());
			}
			
			else if(hand1.getHighCardRank() < hand2.getHighCardRank()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getHighCardString() +
				" over " + hand1.getHighCardString());
			}
			
			else{
				System.out.println("Tie");
			}
			
		}
		
		
		else {
			//todo if hand types are not same declare winner
			//todo based on type hand type value
			//System.out.println("Hands not the same");
			if(rankPlayer1 > rankPlayer2) {
				System.out.println("Black wins. - with " +
						determineHandType(hand1));
			}
			else {
				System.out.println("White wins. - with " +
						determineHandType(hand2));
			}
		}
		
		
	}

	
	private static HandType determineHandType(PokerHand hand) {
		// TODO Auto-generated method stub
		//System.out.println(is_straightFlush(hand));
		if(is_straightFlush(hand)) {
			return HandType.STRAIGHT_FLUSH;
		}
		
		if(is_four_of_a_kind(hand)) {
			return HandType.FOUR_OF_A_KIND;
		}
		
		if(is_fullHouse(hand)) {
			return HandType.FULL_HOUSE;
		}
		
		if(is_flush(hand)) {
			return HandType.FLUSH;
		}
		
		if(is_straight(hand)) {
			return HandType.STRAIGHT;
		}
		
		if(is_three_of_a_kind(hand)) {
			return HandType.THREE_OF_A_KIND;
		}
	
		else {
			hand.setHighCardRank(getHighestCard(hand));
			return HandType.HIGH_CARD;
		}
	} // end of method
	
	
	private static boolean is_three_of_a_kind(PokerHand hand) {
		// TODO Auto-generated method stub
		
		return if_of_a_kind(hand, 3);
	}
	
	private static boolean if_of_a_kind(PokerHand hand, int needed) {
		int amountNeeded;
		amountNeeded = needed;
		int matches;
		matches = 0;
		
		for(Card card: hand) {
			matches = 0;
			for(Card compareCard: hand ) {
				if(card.getRank() == compareCard.getRank()) {
					matches +=1;
					
					if(matches == amountNeeded) {
						hand.setHighCardRank(card.getRank());
						return true;
					}
				}
			}
		}
		return false;	
	}


	private static boolean is_straight(PokerHand hand) {
		// TODO Auto-generated method stub
		if(consecutiveValues(hand)) {
			return true;
		}
		return false;
	}


	private static boolean is_flush(PokerHand hand) {
		// TODO Auto-generated method stub
		// provide a suit to match from one of the cards
		Suit compareSuit = hand.iterator().next().getSuit();
		int highCardRank;
		
		for(Card card: hand) {
			if(card.getSuit() != compareSuit) {
				return false;
			}
		}
		
		highCardRank = getHighestCard(hand);
		hand.setHighCardRank(highCardRank);
		return true;
	}


	private static int getHighestCard(PokerHand hand) {
		// TODO Auto-generated method stub
		int highCardRank;
		highCardRank = 0;
		
		for(Card card: hand) {
			if(card.getRank() > highCardRank) {
				highCardRank = card.getRank();
			}
		}
		
		return highCardRank;
	}


	private static boolean is_fullHouse(PokerHand hand) {
		// TODO Auto-generated method stub
		//copy to work with so i can remove cards to ignore
		PokerHand copy_of_hand = new PokerHand(hand.toString());
		int matches;
		matches = 0;
		boolean threeOfKind;
		threeOfKind = false;
		//made up card 0 of Hearts to initialize ignore card
		Card ignore = new Card("0h");
		int threeOfKindRank;
		threeOfKindRank = 0;
		
		
		boolean twoOfKind = true;
		// find three of a kind
		for(Card card: hand) {
			// reset matches for new compare card
			matches = 0;
			if (card == ignore)
				break;
			for(Card compareCard: hand) {
				//if card is same type ie: King Hearts and King Spades
				if(card.getRank() == compareCard.getRank()) {
					matches +=1;
					if(matches == 3) {
						threeOfKind = true;
						threeOfKindRank = card.getRank();
						twoOfKind = false;
						ignore = card;
					}
					else if(matches == 2) {
						twoOfKind = true;
					}
				}
			} //end inner loop
		}// end outer loop
		
		// final return statements
		if(threeOfKind && twoOfKind) {
			hand.setHighCardRank(threeOfKindRank);
			return true;
		}
		else
			return false;
	}


	private static boolean is_four_of_a_kind(PokerHand hand) {
		
		// look at all the cards
			// look for 4 cards same rank
				// return true;
		
		// implimentation
		
		int matches;
		matches = 0;
		
		for (Card card: hand) {
			matches = 0;
			for(Card compareCard: hand) {
				//System.out.println(card + " " +  compareCard);
				if(card.getRank() == compareCard.getRank()) {
					matches +=1;
					//System.out.println(matches);
					
					if(matches == 4) {
						//System.out.println("four of kind found!");
						hand.setHighCardRank(card.getRank());
						return true;
					}
				}
			}
		}
		
		// card.getRank()
		return false;
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
		int rank;
		rank = 0;
		int lastIndex;
		lastIndex = 0;
		
		
		for(Card c : hand) {
			//System.out.println(c.getRank() + " =>");
			ranksList.add(c.getRank());
		}
		
		// put those values in order to prepare for consecutive test
		ranksList.sort(null);
		
		for(int i = 1; i < ranksList.size(); i++) {
			//previous int and next int consecutive
			if((ranksList.get(i-1)+1) != ranksList.get(i)) {
				//System.out.println(ranksList.get(i-1) + " then " + ranksList.get(i));
				return false;
			}
		}
		// todo?

		lastIndex = ranksList.size() -1;
		rank = ranksList.get(lastIndex);
		hand.setHighCardRank(rank);
		return true;
	}
	
	
	//eof
}
