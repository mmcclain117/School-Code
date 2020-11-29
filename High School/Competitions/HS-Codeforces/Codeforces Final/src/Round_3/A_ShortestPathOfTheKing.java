package Round_3;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class A_ShortestPathOfTheKing {

    /**
     * Tags: Greedy, Shortest Paths
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        char c1 = a.charAt(0);
        int d1 = Integer.parseInt(a.substring(1));
        char c2 = b.charAt(0);
        int d2 = Integer.parseInt(b.substring(1));
        ArrayList<String> move = new ArrayList();
//        out.println(c1 + d1);
//        out.println(c2 + d2);
        while (!(c1 + "" + d1).equals(c2 + "" + d2)) {
            if (d1 > d2) { // Moving down
                if (c1 == c2) { // Down 1
                    move.add("D");
                    d1--;
                } else if (c1 > c2) { // Down Left
                    move.add("LD");
                    c1--;
                    d1--;
                } else if (c1 < c2) {// Down Right
                    move.add("RD");
                    c1++;
                    d1--;
                }
            } else if (d1 < d2) { // Moving Up
                if (c1 == c2) { // Up 1
                    move.add("U");
                    d1++;
                } else if (c1 > c2) { // Up Left
                    move.add("LU");
                    c1--;
                    d1++;
                } else if (c1 < c2) {// Up Right
                    move.add("RU");
                    c1++;
                    d1++;
                }
            } else { // Left or right
                if (c1 > c2) { // Left
                    c1--;
                    move.add("L");
                } else if (c1 < c2) {// Right
                    c1++;
                    move.add("R");
                }
            }
        }
        if (!move.isEmpty()) {
            out.println(move.size());
            for (int i = 0; i < move.size(); i++) {
                out.println(move.get(i));
            }
        } else {
            out.println("0");
        }
    }
}
