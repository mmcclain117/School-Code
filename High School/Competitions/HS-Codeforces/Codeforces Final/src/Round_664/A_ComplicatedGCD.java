package Round_664;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_ComplicatedGCD {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        BigInteger c = b.subtract(a);
        if (c.equals(BigInteger.ZERO)) {
            System.out.println(a);
        } else if (c.equals(BigInteger.ONE)) {
            System.out.println(a.gcd(b));
        } else {
            System.out.println(1);
        }
    }
}
