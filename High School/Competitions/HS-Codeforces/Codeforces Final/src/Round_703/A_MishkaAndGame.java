package Round_703;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_MishkaAndGame {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = 0;
        int c = 0;
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int tm = scan.nextInt();
            int tc = scan.nextInt();
            if (tm > tc) {
                m++;
            } else if (tc > tm) {
                c++;
            } else if (tm == tc) {
                m++;
                c++;
            }
        }
        if (m == c) {
            out.println("Friendship is magic!^^");
        } else {
            out.println(m > c ? "Mishka" : "Chris");
        }
    }
}
