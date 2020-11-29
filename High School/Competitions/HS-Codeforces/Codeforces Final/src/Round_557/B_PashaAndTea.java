package Round_557;

import static java.lang.Math.min;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_PashaAndTea {

    /**
     * Tags: Implementation, Sorting
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int w = scan.nextInt();
        int cups[] = new int[2 * n];
        for (int i = 0; i < cups.length; ++i) {
            cups[i] = scan.nextInt();
        }
        scan.close();
        shell(cups);
        System.out.println(min(3 * n * min(cups[0], cups[n] / 2.0), w));

    }

    public static void shell(int[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }

}
