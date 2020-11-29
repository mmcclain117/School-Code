
import java.util.*;
import java.io.*;
import static java.lang.System.*;

/**
 *
 * @author Master
 */
public class A_Nine {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a_nine.dat"));
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            double x = scan.nextInt();
            double y = scan.nextInt();
            int a = (int) ((int) x + y);
            int b;
            int c = (int) (x * y);
            double d;
            if (x > y) {
                b = (int) (x - y);
                d = x / y;
            } else {
                b = (int) (y - x);
                d = y / x;
            }
//            String aa = x > y ? (x + y) + " " + (x - y) + " " + (x * y) + " " + ((double) (x / y)) : (x + y) + " " + (y - x) + " " + (x * y) + " " + ((double) (y / x));
            out.print(a + " " + b + " " + c + " ");
            out.printf("%.2f", d);
            out.println();
        }
    }
}
