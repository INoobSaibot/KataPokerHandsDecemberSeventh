package pokerHandsKata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	
	public static void startGame(PokerHand hand1, PokerHand hand2 ) {
		
		int rankPlayer1;
		int rankPlayer2;
		
		rankPlayer1 = determineHandType(hand1).getRank();
		rankPlayer2 = determineHandType(hand2).getRank();
		
		// if hand types are the same, then get rank of high card
		//	in hand type ** un-implimented
		if (determineHandType(hand1) 
				== determineHandType(hand2)) {
			// check for high card if hand types are same
			if(hand1.getHighCardRank() > hand2.getHighCardRank()) {
				System.out.println("Black wins. - with " +
				determineHandType(hand1) + ": " + hand1.getHighCardString() +
				" over " + hand2.getHighCardString());
			}
			// continue but inverted winner 2 vs 1
			else if(hand1.getHighCardRank() < hand2.getHighCardRank()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getHighCardString() +
				" over " + hand1.getHighCardString());
			}
			
			// if primary ranks are equal, check for back up ranks 1 and 2
			else if(hand1.getBackUpRank1() > hand2.getBackUpRank1()) {
					System.out.println("Black wins. - with " +
					determineHandType(hand1) + ": " + hand1.getBackUpRank1() +
					" over " + hand2.getBackUpRank1());
					}
			else if(hand1.getBackUpRank1() < hand2.getBackUpRank1()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getBackUpRank1() +
				" over " + hand1.getBackUpRank1());
			}
			
			// if backup1 ranks are equal, check for back up ranks 2
			else if(hand1.getBackUpRank2() > hand2.getBackUpRank2()) {
				System.out.println("Black wins. - with " +
				determineHandType(hand1) + ": " + hand1.getBackUpRank2() +
				" over " + hand2.getBackUpRank2());
				}
			else if(hand1.getBackUpRank2() < hand2.getBackUpRank2()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getBackUpRank2() +
				" over " + hand1.getBackUpRank2());
			}
			
			// if backup2 ranks are equal, check for back up ranks 3
			else if(hand1.getBackUpRank3() > hand2.getBackUpRank3()) {
				System.out.println("Black wins. - with " +
				determineHandType(hand1) + ": " + hand1.getBackUpRank3() +
				" over " + hand2.getBackUpRank3());
				}
			else if(hand1.getBackUpRank3() < hand2.getBackUpRank3()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getBackUpRank3() +
				" over " + hand1.getBackUpRank3());
			}
			
			// if backup3 ranks are equal, check for back up ranks 4
			else if(hand1.getBackUpRank4() > hand2.getBackUpRank4()) {
				System.out.println("Black wins. - with " +
				determineHandType(hand1) + ": " + hand1.getBackUpRank4() +
				" over " + hand2.getBackUpRank4());
				}
			else if(hand1.getBackUpRank4() < hand2.getBackUpRank4()) {
				System.out.println("White wins. with " +
				determineHandType(hand2) + ": " + hand2.getBackUpRank4() +
				" over " + hand1.getBackUpRank4());
			}
			
			
			// no clear winner, same hand type same high rank card
			else{
				System.out.println("Tie");
			}
			
		}
	
		
		// if hand types are NOT same, more clear winner... just compare
		// handType ranks example Straight > two pairs
		else {
			if(rankPlayer1 > rankPlayer2) {
				System.out.println("Black wins. - with " +
						determineHandType(hand1));
			}
			else {
				System.out.println("White wins. - with " +
						determineHandType(hand2));
			}
		}
	}// end of method

	
	private static HandType determineHandType(PokerHand hand) {
		
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
		
		if(is_twoPairs(hand)) {
			return HandType.TWO_PAIRS;
		}
		
		if(is_onePair(hand)) {
			return HandType.PAIR;
		}
		else {
			hand.setHighCardRank(getHighestCard(hand));
			return HandType.HIGH_CARD;
		}
	} // end of method
	
	
	private static boolean is_onePair(PokerHand hand) {
		// TODO Auto-generated method stub
		List<Integer> backUpRanks = new ArrayList();
		boolean onePair;
		onePair = if_hasMatches(hand, 2);
		int rank;
		
		if(true){
			for (Card card: hand) {
				rank = card.getRank();
				//if not cards that are part of the primary pair rank :)
				if(rank != hand.getHighCardRank())
					backUpRanks.add(rank);
			}
			Collections.sort(backUpRanks, Collections.reverseOrder());
			//System.out.println(backUpRanks);
			
			//for each in highest to lowest list, apply to backup-rank variable
			
			hand.setBackUpRank1(backUpRanks.get(0));
			hand.setBackUpRank2(backUpRanks.get(1));
			hand.setBackUpRank3(backUpRanks.get(2));
			
			// IF THERE is one more value, basically 
			//one pair hand case vs high card case with 3 vs 4 rank backups respectively
			if(backUpRanks.size() > 3)
				hand.setBackUpRank4(backUpRanks.get(3));
		}	
		return onePair;
	}


	private static boolean is_twoPairs(PokerHand hand) {
		// TODO Auto-generated method stub
		int pairsFound;
		pairsFound = 0;
		int matches;
		matches = 0;
		
		for(Card card: hand) {
			//reset matches to zero
			matches=0;
			for(Card compareCard: hand) {
				if(card == compareCard){
					//System.out.println(matches);
					break;
					}
				
				if(card.getRank() == compareCard.getRank()) {
					pairsFound +=1;
					//hand.setHighCardRank(card.getRank());
					if(card.getRank() > hand.getHighCardRank()) {
						hand.setBackUpRank1(hand.getHighCardRank());
						hand.setHighCardRank(card.getRank());		
					}
					else
					{
						hand.setBackUpRank1(card.getRank());
					}
				}
				if(pairsFound == 2) {
					if(card.getRank() > hand.getHighCardRank()) {
						hand.setBackUpRank1(hand.getHighCardRank());
						hand.setHighCardRank(card.getRank());
					}
					return true;
				}
			}
			
		}
		return false;
		
	}


	private static boolean is_three_of_a_kind(PokerHand hand) {
		// TODO Auto-generated method stub
		
		return if_hasMatches(hand, 3);
	}
	
	private static boolean if_hasMatches(PokerHand hand, int needed) {
		return has_matches(hand, needed, false);
	}
	
	private static boolean has_matches(PokerHand hand, int needed, boolean twoPairs) {
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
