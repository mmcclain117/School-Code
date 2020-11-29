package Round_80;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_PanoramixsPrediction {

    /**
     * Tags: Brute Force
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean is = false;
        boolean b = true;
        if (isPrime(m)) {
            for (int i = n + 1; i < m; i++) {
                if (!is) {
                    is = isPrime(i);
                } else {
                    b = false;
                }
            }
            if (b) {
                is = true;
            } else {
                is = false;
            }
        }
        String fin = is ? "YES" : "NO";
        out.println(fin);
    }

    private static boolean isPrime(int m) {
        for (int i = 2; i < m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
