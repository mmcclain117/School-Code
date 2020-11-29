package Round_4;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Master
 */
public class C_RegistrationSystem {

    /**
     * Tags: Data Structures, Hashing, Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        HashSet<String> s = new HashSet();
        HashMap<String, Integer> hm = new HashMap();
        for (int i = 0; i < n; i++) {
            String a = scan.nextLine();
            if (hm.containsKey(a)) {
                int b = hm.get(a);
                out.println(a + (b++));
                hm.put(a, b++);
            } else {
                out.println("OK");
                hm.put(a, 1);
            }
        }
//        out.println(hm.toString());
    }
}
