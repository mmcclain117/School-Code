
import java.util.*;
import java.io.*;

/**
 *
 * @author Ryan Talbot
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Alterate Route
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            double d1 = scan.nextDouble(), d2 = scan.nextDouble();

            System.out.printf("%.9f\n", d1 / (d2 / 60));
        }
    }

}