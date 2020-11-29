
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Geocentric {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("H.txt"));
        int a = scan.nextInt();
        for (int b = 0; b < a; b++) {
            int c = scan.nextInt();
            int d = scan.nextInt();
            double x = c;
            while (!(d == 1)) {
                x /= 2;
                d--;
            }
            out.printf("%.3f", x);
            out.println();
        }

        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("H.txt");
        fw.write("2\n"
                + "100 1\n"
                + "100 10");
        fw.flush();
        fw.close();
    }
}
