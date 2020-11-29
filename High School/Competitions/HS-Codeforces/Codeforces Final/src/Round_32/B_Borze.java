package Round_32;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_Borze {

    /**
     * Tags: Expression Parsing, Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
//        String b[] = a.split("--");
        String c = a.replaceAll("--", "2");
        c = c.replaceAll("-.", "1");
        c = c.replaceAll("\\.", "0");
        out.println(c);
//        out.println(Arrays.toString(b));
    }
}
