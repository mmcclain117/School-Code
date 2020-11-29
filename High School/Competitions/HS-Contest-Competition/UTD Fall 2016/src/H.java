


import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class H {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("H.txt"));
        while (scan.hasNext()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            boolean runs = true;
            int yy = 0;
            if (x > y) {
                yy = y;
            } else {
                yy = x;
            }
            int con = 0;
            while (runs) {
                if (x % yy == 0 && y % yy == 0) {
                    out.println(yy);
                    runs = false;
                } else {
                    yy--;
                }
            }
        }
    }

}
