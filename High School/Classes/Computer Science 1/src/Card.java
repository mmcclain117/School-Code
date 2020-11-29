
import java.util.*;

/**
 *
 * @author Master
 */
public class Card {

    private String suit;
    private String value;

    public Card(String st, String val) {
        suit = st;
        value = val;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value + " of " + suit;

    }
}
