
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */

public class Q_pepsiFree {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Q.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            double st = 5.00;
            double take = st - (scan.nextDouble() / 100);
//            if (take >= 1.00) {
            int am = (int) (take / 1.00);
            System.out.println(am + " dollars");
            take %= 1.00;
//            }
//            if (take >= .5) {
            am = (int) (take / .50);
            System.out.println(am + " half dollar");
            take %= .5;
//            }
//            if (take >= .25) {
            am = (int) (take / .25);
            System.out.println(am + " quarters");
            take %= .25;
//            }
//            if (take >= .10) {
            am = (int) (take / 1.00);
            System.out.println(am + " dimes");
            take %= .10;
//            }
//            if (take >= .05) {
            am = (int) (take / .05);
            System.out.println(am + " nickles");
            take %= .05;
//            }
//            if (take >= .01) {
            am = (int) (take / .01);
            System.out.println(am + " pennies");
            take %= .01;
//            }
            System.out.println();
        }
    }
}
