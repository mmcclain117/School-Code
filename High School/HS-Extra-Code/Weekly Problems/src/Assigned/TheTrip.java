package Assigned;

import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class TheTrip {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n != 0) {
            double nn = n;
            double sum = 0;
            double o[] = new double[n];
            for (int i = 0; i < n; i++) {
                o[i] = scan.nextDouble();
                sum += o[i];
            }
            double ave = sum / nn;
            double dif = 0;
            for (int i = 0; i < n; i++) {
                dif += abs(ave - o[i]);
            }
            double ii = dif / 2.00;
            out.println(ii);
            out.print("$");
            out.printf("%.2f", ii);
            n = scan.nextInt();
            out.println();
        }
    }
}
