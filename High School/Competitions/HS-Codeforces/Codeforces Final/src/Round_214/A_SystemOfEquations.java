package Round_214;

import static java.lang.Math.pow;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_SystemOfEquations {

    /**
     * Tags: Brute Force Finding the X Intercept (Roots)
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int con = 0;
        for (int a = 0; a <= m; a++) {
            for (int b = 0; b <= n; b++) {
                int s1 = (int) pow(a, 2) + b;
                int s2 = (int) pow(b, 2) + a;
//                if (s1 == n || s2 == m) {
                if (s1 == n && s2 == m) {
                    con++;
//                    out.println("a: " + s1 + "b: " + s2);
//                    out.println(a + " " + b);
                }
            }
        }
        out.println(con);
    }

}
