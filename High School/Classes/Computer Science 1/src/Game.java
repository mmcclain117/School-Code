
import java.util.*;

public class Game {

    public static Deck deck = new Deck();

    public static void main(String args[]) {
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());

        for (int s = 0; s < 5; s++) {
            System.out.print(deck.drawCard().toString() + ", ");
            if (s == 3) {
                System.out.print("\n");
            }
        }
        System.out.println("");
    }

}
