
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Drawing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int b = 0; b < n; b++) {
            int c = scan.nextInt();
            squr(c);
        }
    }

    public static void squr(int n) {
        if (n == 2) {
            out.println("**");
            out.println("**");
        } else if (n > 2) {
            int x = n - 2;
            for (int b = 0; b < n; b++) {
                out.print("*");
            }
            out.println("");
            for (int c = 0; c < x; c++) {
                out.print("*");
                for (int v = 0; v < x; v++) {
                    out.print(" ");
                }
                out.println("*");
            }
            for (int b = 0; b < n; b++) {
                out.print("*");
            }
        }
    }
}
