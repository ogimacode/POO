
public class Game {
    public static void main(String[] args) {
        Deck deck = new Deck();
        final Card card = deck.pickOne();
        card.visible = true;
        System.out.println(card.cardAsString());
    }

}