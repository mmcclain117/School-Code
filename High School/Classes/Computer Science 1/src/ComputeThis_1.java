
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class ComputeThis_1 {

    public static void main(String[] args) throws Exception { // Mine
        double d1 = (3 * PI * (Math.toRadians(sin(187)))) + (abs(Math.toRadians(cos(122))));
        double d2 = pow(14.72, 3.801) + log(72);
        out.println("d1 = " + d1);
        out.println("d2 = " + d2);
    }
}
