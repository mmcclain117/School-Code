
import java.util.*;
import java.io.*;

/**
 *
 * @author Ryan Talbot
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Space Race
//        Points: 4
        Scanner scan = new Scanner(new File("prob05.txt"));

        int n = scan.nextInt();

        String winName = "";
        double winTime = Double.MAX_VALUE - 1;

        for (int i = 0; i < n; i++) {
            String name = scan.next();
            double d1 = scan.nextDouble(), d2 = scan.nextDouble();

            double t = d1 / d2;

            if (t < winTime) {
                winName = name;
                winTime = t;
            }
        }

        System.out.println(winName + " " + winTime);
    }

}
