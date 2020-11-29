
import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

public class RandomTester {

    public static void main(String[] args) {
        RandomTest Rt = new RandomTest();

    }
}

class RandomTest {

    public Random rnd;

    public RandomTest() {
        rnd = new Random();
        Scanner scan = new Scanner(System.in);
        out.println("How many?");
        int o = scan.nextInt();
        out.println(getResponse());
        printOneRandom();
        printMultiRandom(o);
        ThrowDice();
        int max = rnd.nextInt(Integer.MAX_VALUE);
        int min = rnd.nextInt(max - 1);
        out.println(getRandomInRange(max));
        out.println(getRandomInRange(min, max));
    }

    private void printOneRandom() {
        out.println(rnd.nextInt());
    }

    private void printMultiRandom(int o) {
        for (int i = 0; i < o; i++) {
            out.print(rnd.nextInt() + " ");
        }
    }

    private void ThrowDice() {
        int die = 0;
        out.println("\n" + (rnd.nextInt(6) + 1));
    }

    private String getResponse() {
        int i = rnd.nextInt(3);
        String x = "";
        x = i >= 0 ? i == 1 ? "Yes" : "No" : "Maybe";
        return x;
    }

    private int getRandomInRange(int max) {
        return rnd.nextInt(max);
    }

    private int getRandomInRange(int min, int max) {
        int u = rnd.nextInt(max);
        boolean r = true;
        while (r) {
            if (u > min) {
                r = false;
            } else {
                u = rnd.nextInt(max);
            }
        }
        return u;
    }
}
