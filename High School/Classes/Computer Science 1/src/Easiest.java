
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Easiest {

    public static void main(String[] args) throws Exception {
        Easy();
    }

    public static void Easy() throws Exception {
        Scanner scan = new Scanner(new File("L.txt"));
        while (!scan.hasNext("0")) {
            String a = scan.nextLine();
            int t = Integer.parseInt(a);
            String x;
            if (t < 100) {
                x = a.substring(0, 1);
            } else {
                x = a.substring(0, a.length() - 1);
            }
            int xx = Integer.parseInt(x);
            int aa = xx + t;
            out.println(aa);
        }
    }
}
