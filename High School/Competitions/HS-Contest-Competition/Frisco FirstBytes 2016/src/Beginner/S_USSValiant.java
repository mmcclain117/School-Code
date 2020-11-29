package Beginner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class S_USSValiant {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            x -= scan.nextInt();
            y -= scan.nextInt();
        }
        int sum = (int) (sqrt(pow(x, 2) + pow(y, 2)));
        out.println(sum);
    }
}
