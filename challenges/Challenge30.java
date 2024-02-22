import java.lang.Math;

public class Challenge30 {
	public static void main (String[] args) {
		for (CardColor Color : CardColor.values()) {
			for (CardRank Rank : CardRank.values()) {
				Card card = new Card(Color, Rank);
				System.out.println(card.getColor() + " " + card.getRank().getValue());
			}
		}
		System.out.println();
		
		int randColorNumber = randomNumber(CardColor.values().length);
		int randRankNumber = randomNumber(CardRank.values().length);
		CardColor randColor = CardColor.values()[randColorNumber];
		CardRank randRank = CardRank.values()[randRankNumber];
		
		Card randomCard = new Card(randColor, randRank);
		
		System.out.println("Random card:");
		System.out.println(randomCard.getColor() + " " + randomCard.getRank().getValue());
		cardType(randomCard);
	}
	
	private static void cardType (Card card) {
		if (card.getRank() == CardRank.DOLLAR || card.getRank() == CardRank.PERCENT || card.getRank() == CardRank.CARET)
			System.out.println("This is a symbol card.");
		else
			System.out.println("This is a numbered card.");
	}
	
	private static int randomNumber(int x) {
		double randomNumber = Math.random() * x;
		return (int)randomNumber;
	}
}

enum CardColor {
	RED,
	GREEN,
	BLUE,
	YELLOW
}

enum CardRank {
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	DOLLAR("$"), 
	PERCENT("%"), 
	CARET("^"),
	AMPERSAND("&");
	
	private String value;
	private CardRank(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

class Card {
	private CardColor color;
	private CardRank rank;
	
	public Card (CardColor color, CardRank rank) {
		this.color = color;
		this.rank = rank;
	}
	
	public CardColor getColor() {
		return color;
	}
	
	public CardRank getRank () {
		return rank;
	}
}