
import java.util.*;

/**
 *
 * @author Master
 */
public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();
    Random random = new Random();

    public Deck() {
        createCards();
    }

    private void createCards() {
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (int i = 0; i < 4; i++) {
            for (int ii = 0; ii < 13; ii++) {
                cards.add(new Card(suits[i], values[ii]));
            }
        }

    }

    public ArrayList<Card> shuffle() {

        ArrayList<Card> sCards = new ArrayList<>();
        while (!cards.isEmpty()) {
            int index = random.nextInt(cards.size());

            sCards.add(cards.remove(index));
        }

        cards = sCards;
        return cards;

    }

    public Card drawCard() {
        Card t = cards.get(0);
        cards.remove(0);
        return t;
    }

    @Override
    public String toString() {

        String d = "";

        for (int i = 0; i < cards.size(); i++) {
            d += cards.get(i) + ", ";
            if (i % 4 == 3) {
                d += "\n";
            }
        }
        return d;
    }
}
