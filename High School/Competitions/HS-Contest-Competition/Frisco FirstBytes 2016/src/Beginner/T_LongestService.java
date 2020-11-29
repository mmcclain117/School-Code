package Beginner;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class T_LongestService {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = a - b;
        out.println("You are senior\n" + ((int) c));
    }

}
