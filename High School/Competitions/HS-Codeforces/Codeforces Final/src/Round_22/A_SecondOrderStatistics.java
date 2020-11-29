package Round_22;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author Master
 */
public class A_SecondOrderStatistics {

    /**
     * Tags: Brute Force
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();
            hs.add(t);
        }
        if (hs.size() <= 1) {
            System.out.println("NO");
        } else {
            Object o[] = hs.toArray();
            ArrayList<Integer> a = new ArrayList();
            for (int i = 0; i < o.length; i++) {
                a.add((Integer) o[i]);
//                System.out.println(a.get(i));
            }
            Collections.sort(a);
            System.out.println(a.get(1));
        }
    }
}
