package Round_258;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_LittleElephantAndBits {

    /**
     * Tags: Greedy, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        int b = a.indexOf("0");
        if (b < 0) {
            out.println(a.substring(1));
        } else {
            out.println(a.substring(0, b) + a.substring(b + 1));
        }
    }
}
