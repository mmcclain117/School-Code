
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Master Ward
 */
public class Peg {

    Random random = new Random();

    public Peg() {
        createAnswer();
    }

    public final int[] createAnswer() {
        int answer[] = new int[4];
        for (int i = 0; i < 4; i++) {
            answer[i] = random.nextInt(6) + 1;
        }
        return answer;
    }

    public ArrayList s() {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 40; i++) {
            a.add(0);
        }
        return a;
    }
}
