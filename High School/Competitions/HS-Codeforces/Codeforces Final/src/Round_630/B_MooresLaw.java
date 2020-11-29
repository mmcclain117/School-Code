package Round_630;

import static java.lang.Math.pow;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_MooresLaw {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        double j = pow(1.000000011, t);
        j *= n;
        out.println(j);
    }

}
