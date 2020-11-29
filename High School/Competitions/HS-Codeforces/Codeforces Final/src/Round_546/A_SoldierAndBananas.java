package Round_546;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_SoldierAndBananas {

    /**
     * Tags: Implementation, Math
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        int w = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= w; i++) {
            sum += i * k;
        }
        if ((sum - n) < 0) {
            out.println("0");
        } else {
            out.println(sum - n);
        }
    }

}
