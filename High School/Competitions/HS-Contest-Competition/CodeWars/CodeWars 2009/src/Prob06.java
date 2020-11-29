
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Kepler's Anomaly
//        Difficulty: Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob06.txt"));
        String a = scan.next();
        while (!"END".equals(a)) {
            double M = scan.nextDouble();
            double e = scan.nextDouble();
            double e1 = scan.nextDouble();
            double v = scan.nextDouble();
            double e2 = M + e * Math.sin(e1);
            while (Math.abs(e2 - e1) > v) {
                e1 = e2;
                e2 = M + e * Math.sin(e1);
            }
            System.out.println(a + " " + e2);
            a = scan.next();
        }
    }
}
