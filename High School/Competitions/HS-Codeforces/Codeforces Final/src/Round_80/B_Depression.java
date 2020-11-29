package Round_80;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_Depression {

    /**
     * Tags: Geometry, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3));
//        double hd = Math.toDegrees((h * 30)); // Hour Degree
//        double md = Math.toDegrees((m * 6)); // Minute Degree
//        double hd = Math.toRadians((h * 30)); // Hour Degree
//        double md = Math.toRadians((m * 6)); // Minute Degree
//        out.println(hd + " " + md);
        double hd = (h * 30) + (double) m / 2;
        double md = (m * 6);
//        out.println((h * 30) + " " + (m * 6));
//        if (h >= 12) {
//            hd += 360;
//        }
//        if (hd == 720.0) {
        if (hd >= 360) {
            hd -= 360;
        }
        if (hd % 1 == 0) {
            out.print((int) hd + " ");
        } else {
            out.print(hd + " ");
        }
//        out.println(hd + " " + (int)md);
        out.println((int) md);
    }
}
