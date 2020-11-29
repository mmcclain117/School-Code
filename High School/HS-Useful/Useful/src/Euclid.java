
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Euclid { // Greatest common Factor

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    // Test enable out.println check via -ea as a VM argument
    public static void main(String[] args) {
        out.println(gcd(4, 16));
        out.println(gcd(16, 4));
        out.println(gcd(15, 60));
        out.println(gcd(15, 65));
        System.out.println(gcd(1052, 52));

    }
}
