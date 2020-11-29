package Round_16;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Flag {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean wo = true;
        scan.nextLine();
        char las = 0;
        for (int i = 0; i < n; i++) { // Horizontal lines
            String a = scan.nextLine();
            char c = a.charAt(0);
            String b = "";
            for (int ii = 0; ii < m; ii++) {
                b += c;
            }
            if (!a.equals(b)) {
                wo = false;
                break;
            } else if (i != 0) {
                if (las == c) {
                    wo = false;
//                    break;
                }
            }
            las = c;
        }
        String ans = wo ? "YES" : "NO";
        System.out.println(ans);
    }
}
