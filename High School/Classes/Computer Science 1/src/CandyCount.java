
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class CandyCount {

    public static void main(String[] args) throws Exception { // Done
        Scanner scan = new Scanner(new File("prob04.txt"));
        int c = scan.nextInt();
        int zz = 1000;
        String bb = " ";
        String aa;
        for (int p = scan.nextInt(); p > 0; p--) {
            int g = scan.nextInt();
            int z = c - g;
            if (z < 0) {
                z = -z;
            }
            aa = scan.nextLine();
            if (z < zz) {
                zz = z;
                bb = aa;
            } else if (z == zz) {
                zz = z;
                out.print(bb);
                bb = aa;
            }
        }
        out.print(bb);
    }
}
