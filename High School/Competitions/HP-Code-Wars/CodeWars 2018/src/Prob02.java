
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: How Far Will You Go?
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        double v = 1, a = 1, t = 1, d;
        while (!(v == 0 && a == 0 && t == 0)) {
            v = scan.nextDouble();
            a = scan.nextDouble();
            t = scan.nextDouble();
            d = v * t + .5 * (a * (t * t));
            if (d != 0) { // Had an extraneous output
                System.out.printf("%.3f\n", d);
            }
        }
    }

}
