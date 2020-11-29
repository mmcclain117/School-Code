
import java.io.File;
import static java.lang.System.out;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Master
 */
public class BuyingBeans {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("prob14.txt"));
        int a = in.nextInt();
        BigInteger s = BigInteger.valueOf(6);
        BigInteger s1 = BigInteger.valueOf(7);
        BigInteger s2 = BigInteger.valueOf(11);
        out.println(figure(s, s1, s2));
        while (a != 0) {
            if (a == 2) {
                BigInteger st = in.nextBigInteger();
                BigInteger ts = in.nextBigInteger();
                out.println(LCM(st, ts));
                in.nextLine();
                a = in.nextInt();
            } else if (a == 3) {
                BigInteger st = in.nextBigInteger();
                BigInteger ts = in.nextBigInteger();
                BigInteger sx = in.nextBigInteger();
                BigInteger st1 = LCM(st, ts);
                BigInteger st2 = LCM(st1, sx);
                a = in.nextInt();
            } else if (a == 4) {
            } else if (a == 0) {
            }
        }
    }

    public static BigInteger LCM(BigInteger a, BigInteger b) {
        BigInteger c = a.gcd(b);
        return a.multiply(b.divide(c));

    }

    public static String figure(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger ss = LCM(a, b);
        BigInteger ss1 = LCM(ss, c);
        int a1 = a.intValue();
        int b1 = b.intValue();
        int c1 = c.intValue();
        int x = ss.intValue();
        List li = new ArrayList();
        for (int i = 0; i < x; i++) {
            if ((i % a1 == 0 || i % b1 == 0 || i % c1 == 0)) {
            } else {
                li.add(i);
            }
        }
        return li.toString();
    }

    public static void add(String a) {
        int b = Integer.parseInt(a);
        out.println(b);
    }
}
