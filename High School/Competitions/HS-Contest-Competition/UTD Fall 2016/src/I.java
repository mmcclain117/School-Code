


import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class I {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("I.txt"));
        int a = scan.nextInt();
        out.println("Gnomes:");
        for (int i = 0; i < a; i++) {
            int g = scan.nextInt();
            int h = scan.nextInt();
            int p = scan.nextInt();
            String y = g > h && h > p || g < h && h < p ? "Ordered" : "Unordered";
            out.println(y);
        }
    }

}
