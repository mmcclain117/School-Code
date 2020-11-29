
import java.io.File;
import java.util.Scanner;
import java.math.BigInteger;

/**
 *
 * @author Master
 */
public class Candy {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("candy.dat"));
        int n, t, ind, i;
        t = s.nextInt();
        for (ind = 1; ind <= t; ind++) {
            n = s.nextInt();
            BigInteger res = BigInteger.ONE;
            for (i = 0; i < n; i++) {
                BigInteger a = s.nextBigInteger();
                res = LCM(res, a);
            }
            System.out.println("Case " + ind + ": " + res);
        }
    }

    public static BigInteger LCM(BigInteger a, BigInteger b) {
        BigInteger c = a.gcd(b);
        return a.multiply(b.divide(c));
    }
}
