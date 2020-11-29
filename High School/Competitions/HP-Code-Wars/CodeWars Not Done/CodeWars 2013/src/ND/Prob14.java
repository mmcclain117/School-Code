package ND;

import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Hot Pad
//        Points: 9
        Scanner scan = new Scanner(new File("prob14.txt"));
        double pad[][] = new double[4][3];
        for (int x = 0; x < pad.length; x++) {
            String s = scan.nextLine();
            pad[x] = doublify(s);
        }
        /* Figure out the spots with different temperature signatures */

 /* Run permutation on those numbers */

 /* Prints the array */
        for (int x = 0; x < pad.length; x++) {
            for (int y = 0; y < pad[0].length; y++) {
                System.out.print(pad[x][y] + " ");
            }
            System.out.println();
        }
    }

    /* Turns String array into Double Array */
    private static double[] doublify(String s) {
        String a[] = s.split("[ ]+");
        double x[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = Double.parseDouble(a[i]);
        }
        return x;
    }

}
