
import java.io.File;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.max;
import static java.lang.Math.sin;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob16 {

    private static double a1, b1, a2, b2, m, b;

    public static void main(String[] args) throws Exception {
//        Problem: Rendering Fractal Geometry
//        Points: 13
        Scanner scan = new Scanner(new File("prob16.txt"));
        a1 = scan.nextDouble();
        b1 = scan.nextDouble();
        a2 = scan.nextDouble();
        b2 = scan.nextDouble();
        scan.nextLine();
        double xv, yv, xp, yp;
        xv = scan.nextDouble();
        yv = scan.nextDouble();
        xp = scan.nextDouble();
        yp = scan.nextDouble();
        double d = scan.nextDouble();

        m = (yv - yp) / (xv - xp);
        b = yv - m * xv;
        double xd = xp + d;
        double dx = PI / (8 * max(b1, b2));
        double almostZero = 1e-16;
        double marginOfError = 0.0000001;
        double x, lastDiff = -1;
        for (x = xp; x <= xd; x += dx) {
            double diff = f(x) - slope(x);
            if (diff * diff < almostZero) {
                break;
            }
            // if the signs of the diff has changed, then we
            // have found the interval over which the line
            // intersects the formula
            if (lastDiff / diff < 0) {
                double xLeft = x - dx;
                double xRight = x;
                double diffX, diffL;
                while (xRight - xLeft > marginOfError) {
                    x = (xLeft + xRight) / 2;
                    diffX = f(x) - slope(x);
                    diffL = f(xLeft) - slope(xLeft);
                    if (diffX / diffL < 0) {
                        xRight = x;
                    } else {
                        xLeft = x;
                    }
                }
                break;
            }
            lastDiff = diff;
        }
        if (x > xd) {
            System.out.println("NONE");
        } else {
            System.out.printf("%.5f\n", x);
        }
    }

    private static double f(double x) {
        return a1 * cos(b1 * x) + a2 * sin(b2 * x);
    }

    /* Gets the slope Mx + b */
    private static double slope(double x) {
        return m * x + b;
    }
}
