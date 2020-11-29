package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10.txt"));
        ArrayList<String> titles = new ArrayList();
        ArrayList<int[]> times = new ArrayList();
        while (scan.hasNext()) {
            String y = scan.nextLine();
            String split[] = y.split("\"");
//            System.out.println(Arrays.toString(split));
            String title = split[1]; // Title of show
            titles.add(title);
            String tmpTimes[] = split[2].split("[ ]+"); // Temperary for times
//            System.out.println(Arrays.toString(tmpTimes));
            int time[] = calTime(tmpTimes);
            System.out.println(Arrays.toString(time));
            /* Checks for interferences */
            for (int i = 0; i < times.size(); i++) {
                int sched[] = times.get(i); // Scheduled At time
                if (sched.length == 1) { // Only one element

                    /*
                    Have to add here all four possibilities
                     */

                }
            }
            times.add(time);
        }
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(titles.get(i) + " " + times.get(i)[0]);
        }
    }

    /* Calculate the equivolent of time SUN = 0 */
    private static int[] calTime(String[] tmpTimes) {
        String day = tmpTimes[1].trim();
        int date = Integer.parseInt(tmpTimes[2]);
        if (day.equals("MON")) {
            date += 2400;
        } else if (day.equals("TUE")) {
            date += 4800;
        } else if (day.equals("WED")) {
            date += 7200;
        } else if (day.equals("THU")) {
            date += 9600;
        } else if (day.equals("FRI")) {
            date += 12000;
        } else if (day.equals("SAT")) {
            date += 14200;
        }
        if (tmpTimes.length > 3) { // Multiple Times
            int q[] = new int[2];
            q[0] = date;
            day = tmpTimes[3];
            date = Integer.parseInt(tmpTimes[4]);
            if (day.equals("MON")) {
                date += 2400;
            } else if (day.equals("TUE")) {
                date += 4800;
            } else if (day.equals("WED")) {
                date += 7200;
            } else if (day.equals("THU")) {
                date += 9600;
            } else if (day.equals("FRI")) {
                date += 12000;
            } else if (day.equals("SAT")) {
                date += 14200;
            }
            q[1] = date;
            return q;
        } else {
            int q[] = new int[1];
            q[0] = date;
            return q;
        }
    }
}
