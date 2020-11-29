
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 *
 * @author Master
 */
public class Primes2 {

    public static void main(String[] args) {
        int limit = 2099;
        for (int i = 2000; i <= limit; i++) {
            boolean isPrime = true;
            int sqrt = (int) ceil(sqrt(i));
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i + " ");
            }
        }
    }

    public static boolean isPrime(int i) {
        int sqrt = (int) ceil(sqrt(i));
        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
