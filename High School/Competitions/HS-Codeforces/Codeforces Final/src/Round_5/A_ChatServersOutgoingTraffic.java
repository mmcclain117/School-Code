package Round_5;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_ChatServersOutgoingTraffic {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
//        String a = scan.nextLine();
        int p = 0;
        int sum = 0;
//        ArrayList<String> ar = new ArrayList();
//        while (!a.equals(" ")) {
        while (scan.hasNext()) {
            String a = scan.nextLine();
            if (a.charAt(0) == '+') {
//                ar.add(a.substring(1));
                p++;
            } else if (a.charAt(0) == '-') {
//                ar.remove(a.substring(1));
                p--;
            } else {
                int t = a.indexOf(":");
                int am = a.substring(t).length() - 1;
//                sum += am * (p  - 1);
                sum += am * p;
//                sum += am * (ar.indexOf(a.substring(0, t)) + 1);
//                out.println(a.substring(0, t));
//                out.println(am);
//                out.println(sum);
            }
//            a = scan.nextLine();
        }
        out.println(sum);
    }
}
