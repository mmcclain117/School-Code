package ND;

import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 * Not Done
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10.txt"));
        int tot = 1;
        while (tot != 0) {
            int s1x = scan.nextInt(); // Start 1 x
            int s1y = scan.nextInt(); // Start 1 y
            int e1x = scan.nextInt(); // End 1 x
            int e1y = scan.nextInt(); // End 1 y        
            int s2x = scan.nextInt(); // Start 2 x
            int s2y = scan.nextInt(); // Start 2 y
            int e2x = scan.nextInt(); // End 2 x
            int e2y = scan.nextInt(); // End 2 y
            tot = s1x + s1y + e1x + e1y + s2x + s2y + e2x + e2y;
            System.out.println("Distant 1: " + (sqrt(pow(e1x - s1x, 2) + pow(e1y - s1y, 2))));
        }
    }
}
