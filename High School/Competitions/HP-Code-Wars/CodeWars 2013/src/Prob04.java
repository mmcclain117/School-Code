
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Go Balistic
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));
        double v = scan.nextDouble(); // Velocity
        double a = scan.nextDouble(); // Angle
        final double g = 9.80665;
        a = Math.PI * a / 180;
        final double d = Math.pow(v, 2) * Math.sin(2 * a) / g;
        System.out.println(d);
    }
}
