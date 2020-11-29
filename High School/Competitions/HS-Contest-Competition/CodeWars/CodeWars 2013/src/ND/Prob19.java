package ND;

import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob19 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob19.txt"));
        int t = scan.nextInt(); // Number of cases
        for (int i = 0; i < t; i++) {
            String s = scan.next(); // Starting Spot
            String e = scan.next(); // Ending Spot
            int dist = 0; // Distance
            System.out.println(s + " " + e + " " + dist);
        }
    }
}
