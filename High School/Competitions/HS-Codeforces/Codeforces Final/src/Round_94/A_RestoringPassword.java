package Round_94;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_RestoringPassword {

    /**
     * Tags: Implementation, Strings
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String c[] = new String[10];
        for (int i = 0; i < 10; i++) {
            c[i] = scan.nextLine();
        }
        for (int i = 0; i < 8; i++) {
            int con = 0;
            String te = a.substring(10 * i, 10 * (i + 1));
            while (con < 11) {
                if (te.equals(c[con])) {
                    out.print(con);
                    con = 13;
                }
                con++;
            }
        }
    }
}
