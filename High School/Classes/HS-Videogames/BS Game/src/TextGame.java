
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class TextGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        Deck deck = new Deck();
        Card card = new Card();
        Hand hand = new Hand();
        out.println("Enter Number of players");
        int playerNum = scan.nextInt();
        ArrayList<Hand> PlayerCards = new ArrayList<>();
        ArrayList playerName = new ArrayList();
        out.println("Enter Players Names");
        for (int i = 0; i < playerNum + 1; i++) {
            String a = scan.nextLine();
            playerName.add(a);
        }
        int position = rnd.nextInt(playerName.size()) + 1;
        out.println(position);
        boolean gameStat = false;
        ArrayList activeSet = new ArrayList();
        while (!gameStat) {
            out.print("It is player ");
            if (position == 1) {
                out.println("One's turn");
            } else if (position == 2) {
                out.println("Two's turn");
            } else if (position == 3) {
                out.println("Three's turn");
            } else if (position == 4) {
                out.println("Four's turn");
            } else if (position == 5) {
                out.println("Five's turn");
            }
            activeSet.addAll((Collection) PlayerCards.get(position));
            gameStat = true;
        }
    }
}
