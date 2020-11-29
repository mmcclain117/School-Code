
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Kepler's Law
//        Difficulty: Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob07.txt"));
        double a = scan.nextDouble();
        while (a != 0) {
            double x = Math.sqrt(a);
            double y = Math.cbrt(a);
            double z = Math.pow(y, 2);
            System.out.println(z);
            a = scan.nextDouble();
        }
    }
}
