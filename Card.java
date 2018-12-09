package pokerHandsKata;

public class Card {
	
	private Suit suit;
	private int rank;
	
	//constructor
	Card(String string){
		String[] listOfChars;
		String suit;
		String value;
		
		listOfChars = string.split("");
		
		value = listOfChars[0];
		suit = listOfChars[1];
		
		if(suit.equalsIgnoreCase("c")) {
			this.setSuit(Suit.CLUBS);
		
		} else if(suit.equalsIgnoreCase("d")) {
			this.setSuit(Suit.DIAMONDS);
		
		} else if (suit.equalsIgnoreCase("h")) {
			this.setSuit(Suit.HEARTS);
			
		} else if (suit.equalsIgnoreCase("s")) {
			this.setSuit(Suit.SPADES);
		} else {
			System.out.println("Suit error " + suit + " should only be one of H S D C");
		}
		
		//suit done
		// 23456789tjqka
		//begin value Rank info
		if(value.equalsIgnoreCase("t")) {
			this.setRank(10);
		} else if (value.equalsIgnoreCase("j")) {
			this.setRank(11);
		} else if (value.equalsIgnoreCase("q")) {
			this.setRank(12);
		} else if (value.equalsIgnoreCase("k")) {
			this.setRank(13);
		}else if (value.equalsIgnoreCase("a")) {
			this.setRank(14);
		} else {
			this.setRank(Integer.parseInt(value));
		}
	}

	public Suit getSuit() {
		return suit;
	}

	private void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	private void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString() {
		return (rank + " of " + suit);
	}
	
}
