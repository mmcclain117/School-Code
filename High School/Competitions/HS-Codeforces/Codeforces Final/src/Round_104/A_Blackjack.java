package Round_104;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Blackjack {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int goal = n - 10;
        if (goal <= 0 || goal > 11) {
            out.println("0");
        } else {
            if (goal == 10) {
                out.println("15");
            } else if (goal == 1 || goal == 11) {
                out.println("4");
            } else {
                out.println("4");
            }
        }
    }
}
