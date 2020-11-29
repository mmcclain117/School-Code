
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Alien Income Tax
//        Points: 2
        Scanner scan = new Scanner(new File("prob03.txt"));
        int i = scan.nextInt(); // Annual income
        int m = scan.nextInt(); // Number of children
        int p = 5000; // Personal allowance
        int c = 1000; // Children allowance
        int n = i - p - m * c; // Taxable income
        if (n < 0) {
            n = 0;
        }
        int x = n / 3; // Tax owed
        System.out.println("Income: " + i);
        System.out.println("Taxable: " + n);
        System.out.println("Tax: " + x);
        System.out.println("After Tax: " + (i - x));
    }
}
