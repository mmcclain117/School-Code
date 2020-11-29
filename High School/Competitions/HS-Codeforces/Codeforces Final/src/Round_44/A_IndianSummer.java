package Round_44;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class A_IndianSummer {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        scan.nextLine();
        ArrayList<String> ar = new ArrayList();
        for (int i = 0; i < a; i++) {
            String y = scan.nextLine();
//            out.println(y);
            if (!ar.contains(y)) {
                ar.add(y);
            }
        }
        out.println(ar.size());
    }
}
