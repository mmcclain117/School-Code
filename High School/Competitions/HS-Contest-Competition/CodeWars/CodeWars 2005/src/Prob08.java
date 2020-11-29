

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Elevator
//        Points: 10
        Scanner scan = new Scanner(new File("prob08.txt"));
        int tFloor = -1; // Traveled Floors
        int maxTime = 0; // Max time
        boolean up = true; // Traveling up
        int curFloor = 1; // Current Floor
        ArrayList<Integer> que = new ArrayList(); // Queue Of Requests
        ArrayList<Integer> times = new ArrayList(); // Queue of times
        int next = 0;
        while (true && curFloor < 100) {
            if (scan.hasNext()) { // Reached the end
                next = scan.nextInt(); // Next Request
            } else {
                next = 0;
                if (que.isEmpty()) { // No more Request
                    break;
                }
            }
            if (curFloor != next && next != 0) { // Add if not on that floor
                que.add(next);
                times.add(0);
            }
            int con = que.indexOf(curFloor);
            /* add another travel to times */
            for (int i = 0; i < times.size(); i++) {
                int val = times.get(i);
                times.set(i, val + 1);
            }
//            System.out.println(curFloor + " Index of " + con);
            if (con >= 0) { // it is a floor
                while (con >= 0) { // Removes all of them
                    if (times.get(con) > maxTime) {
                        maxTime = times.get(con);
                    }
                    que.remove(con);
                    times.remove(con);
                    con = que.indexOf(curFloor);
                }
                boolean sup = false; // Still up
                boolean ndo = false; // Now down
                for (int i = 0; i < que.size(); i++) {
                    if (que.get(i) > curFloor && !sup) {
                        sup = true;
                    }
                    if (que.get(i) < curFloor && !ndo) {
                        ndo = true;
                    }
                }
                if (sup && up) { // Continue going up
                    up = true;
                } else if (!up && ndo) { // Continue going down
                    up = false;
                } else { // Switch Directions
                    up = !up;
                }
            }
            /* Move floors */
            if (up) {
                curFloor++;
            } else {
                curFloor--;
            }
            tFloor++;
//            System.out.println("Floor " + curFloor + " Size " + que.size());
//            System.out.println(Arrays.toString(que.toArray()));
        }
        System.out.println(tFloor); // Traveled Floors
        System.out.println((maxTime - 1) * 5); // Traveled Time
    }

}
