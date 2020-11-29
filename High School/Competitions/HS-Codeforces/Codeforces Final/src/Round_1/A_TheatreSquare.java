package Round_1;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_TheatreSquare {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double m = scan.nextInt();
        double n = scan.nextInt();
        double a = scan.nextInt();
        long len = (long) Math.ceil(m / a);
        long wid = (long) Math.ceil(n / a);
        out.println((len * wid));
    }
}
