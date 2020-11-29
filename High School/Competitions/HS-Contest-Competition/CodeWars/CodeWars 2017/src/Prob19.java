

import java.util.*;
import java.io.*;
import static java.lang.Math.sqrt;

/**
 * @author Master Ward
 */
public class Prob19 {

    public static void main(String[] args) throws Exception {
//        Problem: Robot Distance Senor
//        Points: 12
        Scanner scan = new Scanner(new File("prob19.txt"));
        int cali = scan.nextInt(); // Calibrations
        int n = scan.nextInt(); // Number of test
        scan.nextLine();
        int[][] calArray = new int[cali][2];
        for (int i = 0; i < cali; i++) {
            calArray[i][0] = scan.nextInt(); // Distance
            calArray[i][1] = scan.nextInt(); // Raw Data
        }

        /* Get the average of Variable K */
        double sum = 0;
        for (int i = 0; i < cali - 1; i++) {
            int sFar = calArray[i + 1][0];
            int sNear = calArray[i][0];
            int vFar = calArray[i + 1][1];
            int vNear = calArray[i][1];
            double k = (sFar - sNear) / ((1 / (sqrt(vFar))) - (1 / (sqrt(vNear))));
            sum += k;
        }
        double kAvg = sum / (cali - 1); // Average of k
        System.out.println("k = " + kAvg);

        /* Get the average of Variable E */
        sum = 0;
        for (int i = 0; i < cali; i++) {
            int s = calArray[i][0];
            int v = calArray[i][1];
            double e = (kAvg / sqrt(v)) - s;
            sum += e;
        }
        double eAvg = sum / cali; // Average of e
        System.out.println("e = " + eAvg);

        /* Read in and do the rest of the values */
        for (int z = 0; z < n; z++) {
            int tmp = scan.nextInt();
            double finalS = kAvg / sqrt(tmp) - eAvg;
            System.out.println(tmp + " " + finalS);
        }

    }
}
