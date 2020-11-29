
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Leap Year
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        int year = scan.nextInt();
        boolean lp = true; // Is a leap year
        boolean val = false; // Not ordinary year
        if (year % 4 == 0) { // Is Leap Year
            if (year % 100 == 0 && year % 400 != 0) { // Exceptional Years
                System.out.println(year + " is an ordinary year");
                lp = false;
                val = true;
            } else {
                System.out.println(year + " is a leap year");
                val = true;
            }
        }
        if (year % 15 == 0) { // Is Huluculu Year
            System.out.println(year + " is a Huluculu festival year");
            val = true;
        }
        if (lp && year % 55 == 0) { // Is a leap year and Bulukulu Year
            System.out.println(year + " is a Bulukulu festival year");
            val = true;
        }
        if (!val) { // Ordinary Year
            System.out.println(year + " is an ordinary year");
        }
    }
}
