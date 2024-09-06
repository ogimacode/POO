public class Card {
    enum Suit {CLUBS, DIAMONDS, SPADES, HEARTS};
    enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};

    Suit suit;
    Rank rank;
    boolean visible;

    public Card(Suit suit, Rank rank, boolean visible){
        this.suit = suit;
        this.rank = rank;
        this.visible = visible;
    }

    String cardAsString(){
        if(!visible) return "HIDDEN";
        return "[" + suit + ", " + rank + "]";
    }
}
