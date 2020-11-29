package Round_4;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Watermelon {

    /**
     * Tags: Brute Force, Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a >= 4) {
            if (a % 2 == 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        } else {
            out.println("NO");
        }
    }
}
