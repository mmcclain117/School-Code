
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */

/* Range is 1 - 100 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Roman Numerals
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        int n = scan.nextInt();
        while (n != 0) {
            System.out.print("The Roman Numeral for " + n + " is ");
            while (n > 0) {
                if (n >= 100) {
                    System.out.print("C");
                    n -= 100;
                    continue;
                }
                if (n >= 90) {
                    System.out.print("XC");
                    n -= 90;
                    continue;
                }
                if (n >= 50) {
                    System.out.print("L");
                    n -= 50;
                    continue;
                }
                if (n >= 40) {
                    System.out.print("XL");
                    n -= 40;
                    continue;
                }
                if (n >= 10) {
                    System.out.print("X");
                    n -= 10;
                    continue;
                }
                if (n >= 9) {
                    System.out.print("IX");
                    n -= 9;
                    continue;
                }
                if (n >= 5) {
                    System.out.print("V");
                    n -= 5;
                    continue;
                }
                if (n >= 4) {
                    System.out.print("IV");
                    n -= 4;
                    continue;
                }
                if (n >= 1) {
                    System.out.print("I");
                    n -= 1;
                }
            }
            System.out.println();
            n = scan.nextInt();
        }
    }
}
