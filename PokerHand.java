package pokerHandsKata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokerHand implements java.lang.Iterable<Card> {
	
	private int highCardRank;
	private int backUpRank1;
	private int backUpRank2;
	private int backUpRank3;
	private int backUpRank4;

	
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

	public int getBackUpRank1() {
		return backUpRank1;
	}

	public void setBackUpRank1(int backUpRank1) {
		this.backUpRank1 = backUpRank1;
	}

	public int getBackUpRank2() {
		return backUpRank2;
	}

	public void setBackUpRank2(int backUpRank2) {
		this.backUpRank2 = backUpRank2;
	}

	public int getBackUpRank3() {
		return backUpRank3;
	}

	public void setBackUpRank3(int backUpRank3) {
		this.backUpRank3 = backUpRank3;
	}

	public int getBackUpRank4() {
		return backUpRank4;
	}

	public void setBackUpRank4(int backUpRank4) {
		this.backUpRank4 = backUpRank4;
	}
	
	
}
