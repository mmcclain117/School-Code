package Beginner;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class R_WarpDriveMalfunction {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int b = scan.nextInt();
            int bb = b;
            int sum = 0;
            if (b > 3) {
                int time = (int) b / 3;
                b %= 3;
                sum += time * 35;
            }
            if (b == 1) {
                sum += 20;
            } else if (b == 2) {
                sum += 30;
            }
            out.println("Captain, in " + bb + " hops we will go " + sum + " light years");
        }
    }
}
