package Round_102;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_SumOfDigits {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
//        -48
        String a = scan.nextLine();
        int con = 0;
        while (a.length() != 1) {
            char ch[] = a.toCharArray();
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                sum += ch[i] - 48;
            }
            a = sum + "";
            con++;
        }
        out.println(con);
    }
}
