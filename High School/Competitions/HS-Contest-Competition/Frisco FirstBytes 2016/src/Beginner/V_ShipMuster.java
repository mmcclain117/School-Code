package Beginner;

import java.util.Scanner;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class V_ShipMuster {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        boolean jj = false;
        boolean cs = false;
        boolean ar = false;
        for (int i = 0; i < a; i++) {
            int te = scan.nextInt();
            if (te == 46903) {
                jj = true;
            }
            if (te == 45099) {
                cs = true;
            }
            if (te == 60132) {
                ar = true;
            }
        }
        out.println("Jason Janeway " + (jj ? "WILL" : "will NOT") + " be aboard.");
        out.println("Chris Sisko " + (cs ? "WILL" : "will NOT") + " be aboard.");
        out.println("Alan Riker " + (ar ? "WILL" : "will NOT") + " be aboard.");
    }

}
