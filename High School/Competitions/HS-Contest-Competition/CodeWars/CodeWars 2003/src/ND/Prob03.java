package ND;

import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Haven't solved Only printing Saturday  Just skipping days too */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: What Day Is It?
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        int month = scan.nextInt();
        int day = scan.nextInt();
        String months[] = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"};
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2003, month, day);
        System.out.println(Calendar.getInstance().get(3));
        System.out.println(month + " " + day);
        int dow = (c.get(day)) % 7;
//        System.out.println("Date " + c.DATE + " " + dow);
        System.out.println(months[month] + " " + day + ", 2003 is a " + days[dow - 1]);
    }
}
