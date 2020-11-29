package Round_38;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Army {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = scan.nextInt();
        }
        int a = scan.nextInt();
        int b = scan.nextInt();
        int sum = 0;
        for (int i = a; i < b; i++) {
            sum += d[i - 1];
        }
        System.out.println(sum);
    }
}
