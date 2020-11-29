package Round_92;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Chips {

    /**
     * Tags: Implementation, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Number of walresses
        int m = scan.nextInt(); // Number of Chips
        int count = 1;
        while (true) {
            if (count > n) {
                count = 1;
            } else if (count > m) {
                System.out.println(m);
                break;
            } else {
                m -= count;
//                System.out.println(m + " " + count);
                count++;
            }
        }
    }
}
