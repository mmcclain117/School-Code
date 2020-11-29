
import static java.lang.System.out;
import java.math.BigInteger;

/**
 *
 * @author Master
 */
public class Least_common_multiple {

    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        long l = 9;
        BigInteger b = BigInteger.valueOf(l);
        out.println(LCM(a, b));
    }

    public static BigInteger LCM(BigInteger a, BigInteger b) {
        BigInteger c = a.gcd(b);
        return a.multiply(b.divide(c));
    }
}
