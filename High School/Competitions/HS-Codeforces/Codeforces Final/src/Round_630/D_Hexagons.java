package Round_630;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class D_Hexagons {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long x = (long) (1 + (3 * (a * (a + 1))));
        out.println(x);
    }
}
