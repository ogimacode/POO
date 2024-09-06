public class Deck {
    Card[] cards = new Card[52];
    int numberCards = 0;

    public Deck(){
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cards[numberCards++] = new Card(suit, rank, false);
            }
        }
    }

    Card pickOne(){
        final Card card = cards[numberCards - 1];
        numberCards--;
        return card;
    }
}