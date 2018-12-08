package pokerHandsKata;

public enum HandType {
	STRAIGHT_FLUSH(8),
	FOUR_OF_A_KIND(7),
	FULL_HOUSE(6),
	FLUSH(5),
	STRAIGHT(4),
	THREE_OF_A_KIND(3),
	TWO_PAIRS(2),
	PAIR(1),
	HIGH_CARD(0);
	
	private int intValue;
	
	private HandType(int intValue) {
		this.intValue = intValue;
	}
	
	public int getHandType() {
		return this.intValue;
	}
}
