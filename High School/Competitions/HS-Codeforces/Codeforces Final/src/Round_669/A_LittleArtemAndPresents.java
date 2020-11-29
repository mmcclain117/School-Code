package Round_669;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_LittleArtemAndPresents {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n == 1) {
            out.println(1);
        } else if (n == 2) {
            out.println(1);
        } else {
            int num = (int) (n / 3);
            n %= 3;
            num *= 2;
            if (n == 0) {
                out.println(num);
            } else {
                num++;
                out.println(num);
            }
        }
    }

}
