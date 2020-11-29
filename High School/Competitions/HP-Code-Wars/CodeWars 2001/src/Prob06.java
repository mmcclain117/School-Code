
import java.io.File;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;
import static java.lang.Math.sin;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Particle Trajectory
//        Points: 6
        Scanner scan = new Scanner(new File("prob06.txt"));
        int n = scan.nextInt(); // Number of Trajectories
        final double g = -9.8; // Gravity
        for (int i = 0; i < n; i++) {
            System.out.println("trajectory " + (i + 1));
            double vo = scan.nextDouble(); // Initial Velocity
            double c = scan.nextDouble(); // Angle
            double vxo = vo * cos(toRadians(c)); // Verticle X velocity
            double vyo = vo * sin(toRadians(c)); // Verticle Y velocity
            double t = 2 * ((-1 * vyo) / g); // Time=
            double horDis = vxo * t; // Horizontal Distance
            double vertDis = vyo * t / 4; // Vertical Distance
            System.out.printf("horizontal distance: %.0f meters\n", horDis);
            System.out.printf("flight time: %.2f seconds\n", t); // Time (Right)
            System.out.printf("Max Height = %.0f meters\n", vertDis); // NEED TO FIX THIS PART
        }
    }
}
