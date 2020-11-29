
import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    /* Should have worked but doesn't on some cases and that makes no sense */
    public static void main(String[] args) throws Exception {
//        Problem: The Ant and the Candy
//        Points: 9
        Scanner scan = new Scanner(new File("prob10.txt"));
        while (scan.hasNext()) {
            double ax = scan.nextDouble(); // Ant X
            double ay = scan.nextDouble(); // Ant Y
            double az = scan.nextDouble(); // Ant Z
            double cx = scan.nextDouble(); // Candy X
            double cy = scan.nextDouble(); // Candy Y
            double cz = scan.nextDouble(); // Candy Z
            double sssd = pow(cx - ax, 2) + pow(cy - ay, 2) + pow(cz - az, 2); // Distance
            sssd = sqrt(sssd); // If they could fly
            System.out.printf("Shortest Distance = %.2f units\n", sssd);
        }
    }
}
