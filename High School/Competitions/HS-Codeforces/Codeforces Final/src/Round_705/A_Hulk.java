package Round_705;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Hulk {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n == 1) {
            out.println("I hate it");
        } else if (n == 2) {
            out.println("I hate that I love it");
        } else {
            String xx = "I hate that I love";
            int x = n / 2;
            for (int i = 0; i < x - 1; i++) {
                xx += " that I hate that I love";
            }
            out.println(n % 2 == 0 ? xx + " it" : xx + " that I hate it");
        }
    }
}
