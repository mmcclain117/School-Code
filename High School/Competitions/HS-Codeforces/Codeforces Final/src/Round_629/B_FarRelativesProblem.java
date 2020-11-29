package Round_629;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_FarRelativesProblem {

    /**
     * Tags: Brute Force
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
//        int j[] = new int[367];
        String j[] = new String[367];

        for (int ii = 0; ii < a; ii++) {
            String sex = scan.next();
//            Same number of male to female is the problem
            int s = scan.nextInt();
            int e = scan.nextInt();
            for (int i = s; i <= e; i++) {
//                j[i] += 1;
                j[i] += sex;
            }
        }
        int max = 0;

        for (String u : j) {
            if (u != null) {
//                out.println("Got this far " + u);
                if (u.length() > max) {
                    char ch[] = u.replaceAll("null", "").toCharArray();
                    int m = 0;
                    int f = 0;
//                    out.println(max);
//                    out.println(Arrays.toString(ch));
                    for (char c : ch) {
                        if (c == 'M') {
                            m++;
                        } else if (c == 'F') {
                            f++;
                        }
                    }
                    int ss = m > f ? f : m;
                    ss *= 2;
                    if (ss > max) {
                        max = ss;
                    }
                }
            }
        }
        out.println(max);
    }

}
