
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Dist {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        out.print("Enter the A value for the line: ");
        double a = scan.nextDouble();
        out.println(" ");
        out.print("Enter the B value for the line: ");
        double b = scan.nextDouble();
        out.println(" ");
//        Dista.Getdis q = new Dista.Getdis(a, b);
        out.print("Enter the C value for the line: ");
        double c = scan.nextDouble();
        out.println(" ");
        out.print("Enter the x coordinats of the point: ");
        double x = scan.nextDouble();
        out.println(" ");
        out.print("Enter the y coordinats of the point: ");
        double y = scan.nextDouble();
        out.println(" ");

    }

    public static double getDist(double a, double b) {
        double z = sqrt(pow(a, 2) + pow(b, 2));
        return z;
    }

    public double getAbBb(double a, double b, double c, double x, double y) {
        double zx = abs(a * x + b * y + c);
        return zx;
    }
}
