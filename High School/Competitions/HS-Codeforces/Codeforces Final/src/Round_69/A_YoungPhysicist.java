package Round_69;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_YoungPhysicist {

    /**
     * Tags: Implementation, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < n; i++) {
            x += scan.nextInt();
            y += scan.nextInt();
            z += scan.nextInt();
        }
        String en = x == 0 && y == 0 && z == 0 ? "YES" : "NO";
        out.println(en);
    }
}
