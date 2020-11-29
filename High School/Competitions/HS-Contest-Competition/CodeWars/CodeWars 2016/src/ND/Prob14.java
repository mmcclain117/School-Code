package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Variable Shift Encoding
//        Points: 9
        Scanner scan = new Scanner(new File("prob14.txt"));
        int a = scan.nextInt(); // Number of cases
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String s = scan.nextLine();
            char c[] = s.toCharArray(); // Original Line
            char fin[] = new char[c.length]; // Final array
            /* Go through and place the letters */
            for (int q = 0; q < c.length; q++) {
            }
        }
    }
}
