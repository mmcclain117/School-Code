
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Benford {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("benford.dat"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int n = scan.nextInt();
            double ri = 0;
            for (int o = 0; o < n; o++) {
                int y = scan.nextInt();
//                out.println(y);
                String g = (y + "").substring(0, 1);
//                out.println(g);
                ri += "1".equals(g) ? 1 : 0;
            }
//            out.println(ri / n + " "+ ri + " "+ n);
            String h;
            if (ri / n >= .25 && ri / n <= .35) {
                out.println("PASSED");
            } else {
                out.print("FAILED: ");
                double x = ((ri / n) * 100);
                out.printf("%.2f", x);
                out.println("%");

            }
//            out.println(h);
        }
    }
}
