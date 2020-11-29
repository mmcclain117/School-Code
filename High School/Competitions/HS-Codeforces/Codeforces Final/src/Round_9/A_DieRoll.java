package Round_9;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_DieRoll {

    /**
     * Tags: Math, Probabilities
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = a > b ? a : b;
        if (c == 1) {
            out.println("1/1");
        } else if (c == 6) {
            out.println("1/6");
        } else {
            int w = 7 - c;
            int y = gcd(w, 6);
            if (y == 1) {
                out.println(w + "/" + 6);
            } else {
                out.println((w / y) + "/" + (6 / y));
            }
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }
}
