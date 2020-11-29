package Round_96;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Football {

    /**
     * Tags: Implementation, Strings
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        out.println((a.contains("1111111") || a.contains("0000000") ? "YES" : "NO"));
    }
}
