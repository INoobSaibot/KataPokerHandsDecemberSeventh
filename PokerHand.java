package pokerHandsKata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokerHand implements java.lang.Iterable<Card> {
	
	private int highCardRank;
	
	private List<Card> cardList = new ArrayList<Card>();
	String printableString;
	
	//Constructor
	PokerHand(String string){
		printableString = string;
		for(String rankAndSuit : string.split(" ")) {
			Card card = new Card(rankAndSuit);
			
			cardList.add(card);
		}
	}

	@Override
	public Iterator<Card> iterator() {
		// TODO Auto-generated method stub
		Iterator<Card> iterator = cardList.iterator();
		return iterator;
	}
	
	public String toString() {
		return printableString;
	}

	public int getHighCardRank() {
		return highCardRank;
	}
	
	public String getHighCardString() {
		int rank = getHighCardRank();
		
		if (rank < 10)
			return Integer.toString(rank);
		
		// switch cases for Ace, King, Queen, Jack, Ten
		switch(rank)
		{
		case 14:
			return "Ace";
		
		case 13:
			return "King";
		
		case 12:
			return "Queen";
		
		case 11:
			return "Jack";
			
		case 10:
			return "Ten";
		}
		return null;
		
	}

	public void setHighCardRank(int highCardRank) {
		this.highCardRank = highCardRank;
	}
	
	
}
