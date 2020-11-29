
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Kepler's Law
//        Points: 4
        Scanner scan = new Scanner(new File("prob07.txt"));
        double a = scan.nextDouble();
        while (a != 0) {
            double y = Math.cbrt(a);
            double z = Math.pow(y, 2);
            System.out.printf("%.7f\n", z);
            a = scan.nextDouble();
        }
    }
}
