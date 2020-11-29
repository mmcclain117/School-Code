
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Temperature Sensor
//        Difficulty: Easy
//        Subject: Brute Force, Math

        Scanner scan = new Scanner(new File("prob06.txt"));
        int n = scan.nextInt(); // Number of test Cases
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt(); // Current temperature
            int t0 = scan.nextInt(); // 1st Calibration Temperature
            int t1 = scan.nextInt(); // 2nd Calibration Temperature
            int c0 = scan.nextInt(); // 1st Calibration Temperature
            int c1 = scan.nextInt(); // 2nd Calibration Temperature
            double cal = ((double) t1 - t0) / (c1 - c0);
            double fin = c0 + ((t - t0) / cal);
//            System.out.println(cal + " " + fin);
            System.out.println(fin / 8.0);
        }
    }
}
