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

	public void setHighCardRank(int highCardRank) {
		this.highCardRank = highCardRank;
	}
	
	
}
