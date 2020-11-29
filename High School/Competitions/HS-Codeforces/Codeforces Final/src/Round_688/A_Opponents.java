package Round_688;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_Opponents {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int con = 0;
        int max = 0;
        scan.nextLine();
        for (int i = 0; i < d; i++) {
            boolean win = false;
            String x = scan.nextLine();
            if (x.contains("0")) {
                con++;
                win = true;
            }
            if (!win) {
                if (max <= con) {
                    max = con;
                }
                con = 0;
            }
        }
        out.println(con > max ? con : max);
    }
}
