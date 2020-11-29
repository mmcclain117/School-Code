
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Hailstones {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("M2.txt"));
        int a = scan.nextInt();
        for (int b = 0; b < a; b++) {
            int u = scan.nextInt();
            int y = scan.nextInt();
            int max = y;
            boolean c = true;
            while (c) {
                if (y == 1) {
                    y = 0;
                    c = false;
                }
                if (y % 2 == 0) {
                    y /= 2;
                    if (y > max) {
                        max = y;
                    }
                } else if (y % 2 == 1) {
                    y = y * 3 + 1;
                    if (y > max) {
                        max = y;
                    }
                }
            }
            out.println(u + " " + max);
        }
        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("M2.txt");
        fw.write("4\n"
                + "1 1\n"
                + "2 3\n"
                + "3 9999\n"
                + "4 10000");
        fw.flush();
        fw.close();
    }
}
