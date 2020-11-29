package Round_712;

import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_MemoryAndTrident {

    /**
     * Tags: Implementation
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (!(s.length() % 2 == 0)) {
            out.println("-1");
        } else {
            int l = 0;
            int r = 0;
            int u = 0;
            int d = 0;
            char ch[] = s.toCharArray();
            for (char x : ch) {
                if (x == 'U') {
                    u++;
                }
                if (x == 'R') {
                    r++;
                }
                if (x == 'D') {
                    d++;
                }
                if (x == 'L') {
                    l++;
                }
            }
            int side = abs(l - r);
            int hor = abs(u - d);
            if (side == hor) {
                out.println(side);
            } else {
                out.println((hor + side) / 2);
            }
        }
    }

}
