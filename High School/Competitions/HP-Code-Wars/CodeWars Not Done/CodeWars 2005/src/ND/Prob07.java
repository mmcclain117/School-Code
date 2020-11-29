package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Need to fix based on the comments */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: St. Bernard vs T-3
//        Points: 8
        Scanner scan = new Scanner(new File("prob07.txt"));
        int size = scan.nextInt(); // Transfer size
        int dist = scan.nextInt(); // Distance
        int time = scan.nextInt(); // Military Time
        int t1 = getTimy(size, dist); // First Time
        int t2 = getT3(size); // Second Time
        int t3 = getFedEx(time); // Third Time
        System.out.println(t1 + " " + t2 + " " + t3);
        int day = 0;
        if (t1 < t2 && t1 < t3) { // Tiny
            t1 += time;
            while (t1 >= 2400) { // Passed a day
                t1 -= 2400;
                day++;
            }
            System.out.print("Shipment by Tiny will arrive at " + (t1) + " hours ");
            if (day == 0) {
                System.out.println("today");
            } else if (day == 1) {
                System.out.println("tomorrow");
            } else if (day > 1) {
                System.out.println(day + " days from today");
            }
        } else if (t2 < t1 && t2 < t3) { // T3
//            t2 = t2 % 30 == 0 ? t2 : t2 + (30 - (t2 % 30));
            t2 += time; // Get Final Time
            while (t2 >= 2400) { // Passed a day
                t2 -= 2400;
                day++;
            }
            System.out.print("Shipment by T3 will arrive at " + (t2) + " hours ");

            if (day == 0) {
                System.out.println("today");
            } else if (day == 1) {
                System.out.println("tomorrow");
            } else if (day > 1) {
                System.out.println(day + " days from today");
            }
        } else if (t3 < t1 && t3 < t2) { // FedEx
            t3 += time;
            while (t3 >= 2400) { // Passed a day
                t3 -= 2400;
                day++;
            }
            System.out.print("Shipment by FedEx will arrive at " + (t3) + " hours ");
            if (day == 0) {
                System.out.println("today");
            } else if (day == 1) {
                System.out.println("tomorrow");
            } else if (day > 1) {
                System.out.println(day + " days from today");
            }

        }
    }

    /* Can transfer 3, 200 GB Carts at 4mph */
    private static int getTimy(int size, int dist) { // LITTLE OFF (Rouding off half hours)
        int trip = (int) Math.ceil((double) size / 600000.0); // One Trip Size
        double len = dist * 30; // 4 MPH there; 4 MPH back (PER hour)
        return (int) (trip * len);
    }

    /* Can transfer 45 Mega-bits per second */
    private static int getT3(int size) { // NOWHERE CLOSE
        double tmp = size / 8; // Size to Bits
        tmp *= (10.0 / 6.0);
        return (int) (tmp / 45);
    }

    /* Pickup at 1800; Delivery at 1030 */
    private static int getFedEx(int time) { // Correct Now
        int el = 0; // Elapsed Time
        if (time > 1800) { // Missed Today's
            el += 2400 - time; // To Midnight
            el += 1800;
        } else {
            el += 1800 - time;
        }
        el += 1630; // Delivery Time
        return el;
    }
}
