
import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Master Ward
 */
/* The other return is very unstable but works Most of the Time */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Goldbach's Conjunction
//        Points: 6
        Scanner scan = new Scanner(new File("prob09.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            BigInteger b = new BigInteger(a + "");
            BigInteger b1 = b.divide(BigInteger.valueOf(2));
            BigInteger b2 = b.subtract(b1);
            while (!(isPrime(b1) && isPrime(b2))) {
                b1 = b1.subtract(BigInteger.ONE);
                b2 = b.subtract(b1);
//                System.out.println(b1 + " "+ b2);
            }
            System.out.println(b1.intValue() + " + " + b2.intValue() + " = " + a);
            a = scan.nextInt();
        }
    }

    private static boolean isPrime(BigInteger b1) {
        int b = b1.intValue();
        for (int i = 2; i < b; i++) {
            if (b % i == 0) {
                return false;
            }
        }
        return true;
//        return b1.isProbablePrime(2);
    }
}
