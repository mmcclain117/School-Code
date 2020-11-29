package Round_108;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;

public class A_PalindromicTimes {

    /**
     * Tags: Implementation, Strings
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String h = a.substring(0, 2);
        String m = a.substring(3, 5);
        if (m.equals("59")) {
        }
//        int h = Integer.parseInt(a.substring(0, 2));
//        int m = Integer.parseInt(a.substring(3, 5));
//        System.out.println(h + " " + m);
        if (new StringBuilder(h).reverse().toString().equals(m)) {
        }
    }
}
