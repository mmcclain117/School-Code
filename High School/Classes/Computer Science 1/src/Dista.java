
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Master
 */
public class Dista {

    public static double A, B, C, z;

    public static double Getdis(double a, double b) {
        z = abs(A * a + B * b + C);
        z /= sqrt(pow(a, 2) + pow(b, 2));
        return z;
    }
}
