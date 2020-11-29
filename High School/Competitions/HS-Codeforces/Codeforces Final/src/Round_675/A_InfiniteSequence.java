package Round_675;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_InfiniteSequence {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        boolean stat;
        if (c == 0) {
            stat = (a == b);
        } else {
            stat = ((b - a) % c == 0) && ((b - a) / c) >= 0;
        }
        out.println(stat ? "YES" : "NO");
    }
}
