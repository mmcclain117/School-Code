package Round_32;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Reconnaissance {

    /**
     * Tags: Brute Force
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
//        out.println(Arrays.toString(a));
        for (int i = 0; i < n - 1; i++) {
            for (int ii = i + 1; ii < n; ii++) {
//                out.println(a[ii] - a[i]);

                if (a[ii] - a[i] <= d) {
                    count++;
                }
            }
        }
        out.println(count * 2);
    }
}
