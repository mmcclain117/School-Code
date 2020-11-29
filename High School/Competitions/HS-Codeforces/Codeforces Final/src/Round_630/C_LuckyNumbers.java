package Round_630;

import static java.lang.Math.pow;
import static java.lang.System.out;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class C_LuckyNumbers {

    /**
     * Tags: Combinatorics, Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextInt();
        double d = pow(2, a + 1);
        long val = (long) d - 2;
        BigInteger bi = new BigInteger(val + "");
//        out.println((int) (d - 2));
        out.println(bi.toString());
    }
}
