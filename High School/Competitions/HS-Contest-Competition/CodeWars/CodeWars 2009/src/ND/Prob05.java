package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Doesnt work at all */
public class Prob05 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));
        String month = scan.next(); // Month
        int year = scan.nextInt(); // Year
        int start;
        int end;
        int value;
        while (!"END".equals(month) && year != 0) {
            scan.nextLine();
            int numDay = getNumDays(month, year);
            start = 0;
            int previousValue = 9999;
            for (int i = 1; i <= numDay; i++) {
                value = scan.nextInt();
                if (start > value && previousValue > value) {
                    System.out.println(month + " " + start);
                    end = i - 1;
                    if (end > start) {
                        System.out.println("-" + end);
                    }
                    System.out.println(", " + year + ": " + previousValue);
                    start = 0;
                }
                if (value > previousValue) {
                    start = i;
                }
                previousValue = value;
            }
            month = scan.next();
            year = scan.nextInt();
        }
        /*
        String c = scan.nextLine();

        String d[] = c.split("\\s+");
        int e[] = new int[d.length];
        for (int i = 0; i < e.length; i++) {
            e[i] = Integer.parseInt(d[i]);
        }
        int con = 0;
        for (int i = 1; i < e.length - 1; i++) {
            if (e[i - 1] <= e[i] && e[i] >= e[i + 1]) {
                System.out.println(a + " " + (i + 1) + ", " + b + " :" + e[i]);
//                    con++;
//                } else if (e[i - 1] <= e[i] && e[i] >= e[i + 1]) {
//                    con++;
            } else if (con > 0) {
                System.out.println(a + " " + (i + 1) + " - " + (i + con + 1) + ", " + b + " :" + e[i]);
                con = 0;
            }
        }*/
    }

    private static int getNumDays(String month, int year) {
        switch (month) {
            case "JANUARY":
                return 31;
            case "FEBRUARY":
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case "MARCH":
                return 31;
            case "APRIL":
                return 30;
            case "MAY":
                return 31;
            case "JUNE":
                return 30;
            case "JULY":
                return 31;
            case "AUGUST":
                return 31;
            case "SEPTEMBER":
                return 30;
            case "OCTOBER":
                return 31;
            case "NOVEMBER":
                return 30;
            case "DECEMBER":
                return 31;
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        if ((year % 400) == 0) {
            return true;
        }
        if ((year % 4) == 0 && (year % 100) != 0) {
            return true;
        }
        return false;
    }

}
