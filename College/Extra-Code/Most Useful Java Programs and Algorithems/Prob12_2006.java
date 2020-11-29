

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Mayan Calendar
//        Points: 15
        Scanner scan = new Scanner(new File("prob12.txt"));
        int moda[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String line = scan.nextLine();
        String split[] = line.split("/");
        int day = Integer.parseInt(split[1]);
        int month = Integer.parseInt(split[0]);
        int year = Integer.parseInt(split[2]);
        int tot = day + year * 365;
        for (int i = 0; i < month; i++) { // Adds in the months
            tot += moda[i];
        }
        if (year % 4 == 0 && month > 2) { // Include Feb 29
            tot++;
        }
        int leap = year / 4; // Number of leap years
        tot += leap;
//        System.out.println(tot);
        int beginning = 8 + 200 + (17 * 360) + (7200 * 17) + (7 * 144000);
        tot += beginning; // Beginning of time
        int baktun = (tot / 144000);
        tot %= 144000;
        int katun = (tot / 7200);
        tot %= 7200;
        int tun = (tot / 360);
        tot %= 360;
        int winal = (tot / 20);
        tot %= 20;
        int kin = tot;
        System.out.println(baktun + "." + katun + "." + tun + "." + winal + "." + kin);
//        System.out.println(Arrays.toString(split));
    }
}
