package Round_709;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Juicer {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int b = scan.nextInt();
        int d = scan.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if (x < b) {
                sum += x;
            }
            if (sum > d) {
                count++;
                sum = 0;
            }
        }
        System.out.println(count);
    }
}
