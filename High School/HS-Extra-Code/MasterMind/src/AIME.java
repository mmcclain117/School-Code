
import static java.lang.Math.pow;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class AIME {

    public static void main(String[] args) {
        int n = 39;
        int a = n;
        int b = 0;
        for (int i = 0; i < n; i++) {
            a += (i * (i + 1));
            b += (i + 1) * (i + 2);
            i++;
        }
        out.println(b + " " + a + "  = " + (b - (a) - n));
        int sum = 2;
        a = n;
        b = 1;
        for (int i = 0; i < n / 2; i++) {
            a += (i * (i + 1));
            b += ((i + 1) * (i + 2));
            i++;
        }
        int x = 2;
        for (int ii = 0; ii <= 2; ii++) {
            x += ((3 * (x * x)) - (11 * x) + 12);
            out.println(x);
        }
        out.println(39 * 39 + 41);
        out.println(38 * 38 + 32);
        out.println(b + " -" + a + "  = " + ((b - a) - n));
        b = x;
        out.println(b + " -" + a + "  = " + ((b - a) - n));
    }
}
