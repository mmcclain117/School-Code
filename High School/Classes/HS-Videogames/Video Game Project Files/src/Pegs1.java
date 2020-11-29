
import java.util.Random;

/**
 *
 * @author Master Ward
 */
public class Pegs1 {

    Random random = new Random();
    public static int[] answer = new int[4];

    public Pegs1() {
        createAnswer();
    }

    private void createAnswer() {
        for (int i = 0; i < 4; i++) {
            answer[i] = random.nextInt(6) + 1;
        }
    }

}
