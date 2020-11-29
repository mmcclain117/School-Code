
import java.util.*;

/**
 *
 * @author Master
 */
public class Peg {

    Random random = new Random();
    public static int[] answer = new int[4];

    public Peg() {
        createAnswer();
    }

    private void createAnswer() {
        for (int i = 0; i < 4; i++) {
            answer[i] = random.nextInt(6) + 1;
        }
    }

    public int[] black(int guess[]) {
        int b[] = {0, 0};
        int black = 0;
        int white = 0;
        String y = Arrays.toString(answer);
        for (int i = 0; i < 4; i++) {
            if (y.contains(guess[i] + "")) {
                black++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (guess[i] == answer[i]) {
                white++;
            }
        }
        b[0] = black;
        b[1] = white;
        return b;
    }
}
