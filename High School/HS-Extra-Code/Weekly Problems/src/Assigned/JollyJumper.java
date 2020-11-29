package Assigned;

import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;
// problem 10038

/**
 *
 * @author Master
 */
public class JollyJumper {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int o[] = new int[n];
            for (int i = 0; i < n; i++) {
                o[i] = scan.nextInt();
            }
//            String a = scan.nextLine();
//            String u[] = a.split("\\s+");
//            int o[] = new int[u.length];
//            for (int i = 0; i < u.length; i++) {
//                o[i] = Integer.parseInt(u[i]);
//            }
//            if (n == 1) {
//                String l = o[0] == 1 ? "Jolly" : "Not jolly";
//                out.println(l + "x");
//            } else {
            int par[] = new int[o.length];
            for (int i = 0; i < o.length - 1; i++) {
                par[i] = abs(o[i] - o[i + 1]);
            }
//            out.println(Arrays.toString(par));
            Arrays.sort(par);
//            out.println(Arrays.toString(par));
//            if (par[0] != n - 1) {
//                out.print/ln("Not jolly");
//            } else if (increasing(par)) {
            if (increasing(par)) {
                out.println("Jolly");
            } else {
                out.println("Not jolly");
            }
        }
//        }
    }

    private static boolean increasing(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] - x[i + 1] != -1) {
                return false;
            }
        }
        return true;
    }
}
