package Round_501;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Contest {

    /**
     * Tags: Implementation
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int m = max(a, c);
        int v = max(b, d);
        if (m > v) {
            out.println("Misha");
        } else if (v > m) {
            out.println("Vasya");
        } else {
            out.println("Tie");
        }
    }

    private static int max(int p, int t) {
        int s1 = ((3 * p) / 10);
        int s2 = p - ((p / 250) * t); // Could be here
        if (s1 > s2) {
            return s1;
        } else {
            return s2;
        }
    }
}
