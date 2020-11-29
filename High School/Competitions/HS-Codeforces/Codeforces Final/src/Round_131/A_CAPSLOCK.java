package Round_131;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_CAPSLOCK {

    /**
     * Tags: Implementation, Strings
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String up = a.toUpperCase();
        if (a.length() == 1) {
            if (a.equals(up)) {
                out.println(a.toLowerCase());
            } else {
                out.println(up);
            }
        } else {
            String c2 = a.substring(0, 1).toLowerCase() + up.substring(1);
            if (a.equals(up)) {
                out.println(a.toLowerCase());
            } else if (a.equals(c2)) {
                out.println(a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase());
            } else {
                out.println(a);
            }
//            out.println(c2 + " " + up);
        }
    }
}
