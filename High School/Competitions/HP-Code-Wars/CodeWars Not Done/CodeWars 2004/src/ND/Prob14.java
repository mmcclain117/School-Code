package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Master Ward
 */
/* Can't check the map Twice */
public class Prob14 {

    public static void main(String[] args) throws Exception {
        //        Problem: March Madness
        //        Points: 18
        Scanner scan = new Scanner(new File("prob14.txt"));
        ArrayList<String> input = new ArrayList(); // List of matches
        Map<String, Integer> hm = new TreeMap();
        while (scan.hasNext()) {
            String a = scan.nextLine(); // Team 1
            String b = scan.nextLine(); // Team 2
            /* Add games to List of Games */
            input.add(a + " " + b);
//			input.add(b);
            if (scan.hasNextLine()) {
                scan.nextLine();
            }
            // scan.nextLine();
            String team1 = a.split("[ ]+")[0]; // Adds First team
            String team2 = b.split("[ ]+")[0]; // Adds First team
            /* Add teams to HashMap */
            if (hm.containsKey(team1)) { // Add 1 to the team value
                hm.put(team1, hm.get(team1) + 1);
            } else { // Add the new team
                hm.put(team1, 1);
            }
            if (hm.containsKey(team2)) { // Update team
                hm.put(team2, hm.get(team2) + 1);
            } else { // Add the new team
                hm.put(team2, 1);
            }
        }
//		 for (int o = 0; o < 2; o++) {
        Iterator it1 = hm.values().iterator(); // Iterator for appearences
        Iterator it2 = hm.keySet().iterator(); // Iterator for teams
        System.out.println(hm.size());
        List<String> ar = new ArrayList<>();
        int tmhm = hm.size();
        for (int i = 0; i < tmhm; i++) {
            int tmp1 = (int) it1.next();
            String tmp2 = it2.next() + "";
            if (tmp1 == 1) {
                ar.add(tmp2);
            } else { // Decrease teams and move round
                String tmp = tmp2;
                hm.put(tmp, hm.get(tmp) - 1);
            }
            System.out.println(tmp2 + " " + tmp1);
        }

        /* Work on past this point */
        int con = 0;
        boolean found = false;
        while (ar.size() < con) {
            System.out.println(ar.size());
            Object qq[] = ar.toArray();
            System.out.println(Arrays.toString(qq));
            System.out.println(Arrays.toString(input.toArray()));
            // for (int i = 0; i < ar.size();i++) {
            for (int p = 0; p < input.size(); p++) {
                if (input.get(p).contains(ar.get(con))) {
//					System.out.println(input.get(p) + input.get(p + 1));
                    System.out.println(input.get(p) + " " + ar.get(con));
                    input.remove(p);
//					input.remove(p + 1);
//					ar.remove(con);
                    con++;
                    found = true;
                    break;
                    // i--;
                }
            }
            if (!found) {
                System.out.println("THIS IS NOT FOUND " + ar.remove(con));
            }
        }
        System.out.println(ar.size());
        /* Removes the found teams */
//		it1 = hm.values().iterator(); // Iterator for appearences
        it2 = hm.keySet().iterator(); // Iterator for teams
        // System.out.println(hm.size());
//		System.out.println(it2.next());
//		for (int i = 0; i < hm.size(); i++) {
        Map<String, Integer> tp = new TreeMap<String, Integer>(hm);
//        Collections.copy(tp, hm);
        Iterator it = tp.values().iterator();
        for (Iterator<Integer> iterator = tp.values().iterator(); iterator.hasNext();) {
            Object value = it.next();
            if ((int) value == 1) {
                tp.remove(it2.next().toString());
            } else { // Decrease teams and move round;
                it2.next();
            }
        }
        while (it1.hasNext()) {
            if ((int) it1.next() == 1) {
                hm.remove(it2.next().toString());
            } else { // Decrease teams and move round;
                it2.next();
            }
        }
//		}
    }
}
