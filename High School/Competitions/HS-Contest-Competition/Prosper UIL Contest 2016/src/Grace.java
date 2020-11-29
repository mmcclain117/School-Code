
import java.io.File;
import static java.lang.Math.cbrt;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Grace {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("grace.txt"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            double val = a % 3 == 0 ? pow(a, 2) : a % 3 == 1 ? sqrt(a) : cbrt(a);
//            out.printf("%.1d" , val);
//            out.println(val);
            out.printf("%.1f", val);
            out.println();
        }
    }
}
