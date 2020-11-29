package Beginner;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Q_WeekendPass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int a3 = scan.nextInt();
        int a4 = scan.nextInt();
        int sum = 0;
        if (a1 < 20) {
            sum += a1;
        } else if (a1 >= 20 && a1 < 40) {
            sum += 2 * a1;
        } else {
            sum += 3 * a1;
        }
        if (a2 < 20) {
            sum += a2;
        } else if (a2 >= 20 && a2 < 40) {
            sum += 2 * a2;
        } else {
            sum += 3 * a2;
        }
        if (a3 < 20) {
            sum += a3;
        } else if (a3 >= 20 && a3 < 40) {
            sum += 2 * a3;
        } else {
            sum += 3 * a3;
        }
        if (a4 < 20) {
            sum += a4;
        } else if (a4 >= 20 && a4 < 40) {
            sum += 2 * a4;
        } else {
            sum += 3 * a4;
        }
        out.println("Your trip will take " + sum + " credits.");
    }

}
