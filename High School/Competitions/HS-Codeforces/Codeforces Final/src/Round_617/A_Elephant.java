package Round_617;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Elephant {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        if (n <= 5) {
            count = 1;
        } else {
            count = (int) (n / 5);
            if (!(n % 5 == 0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
