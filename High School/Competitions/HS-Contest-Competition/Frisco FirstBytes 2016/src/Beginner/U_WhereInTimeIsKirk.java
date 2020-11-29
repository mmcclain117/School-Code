package Beginner;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class U_WhereInTimeIsKirk {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < a; i++) {
            int b = scan.nextInt();
            for (int u = 0; u < b; u++) {
                sum += scan.nextInt();
            }
        }
        out.println("Kirk changed what happened on " + sum + " days.");
    }

}
