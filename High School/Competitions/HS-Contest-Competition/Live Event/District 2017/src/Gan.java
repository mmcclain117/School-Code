
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 *
 */
public class Gan {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Gan.dat"));
        String a[] = scan.nextLine().split("\\s+");
        for (int i = 0; i < 38; i++) {
            System.out.print("-");
        }
        System.out.println();
        final double pi = 3.141592653589793;
        for (int i = 0; i < a.length; i++) {
            int r = Integer.parseInt(a[i]); // Radus
            double d1 = 2 * pi * r; // First Number
            double d2 = pi * Math.pow(r, 2);
            double d3 = 4 * pi * Math.pow(r, 2);
            double d4 = (4.0 / 3.0) * pi * Math.pow(r, 3);
            System.out.printf("%2d %8.1f %8.1f %8.1f %8.1f\n", r, d1, d2, d3, d4);
        }
        for (int i = 0; i < 38; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
