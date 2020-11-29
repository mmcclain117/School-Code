
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class home {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("home.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            int n = scan.nextInt();
            for (int o = 0; o < n; o++) {
                String h = scan.next();
                String y = h.equalsIgnoreCase("left") ? "right" : "left";
                out.print(y + " ");
            }
            out.println();
        }
    }
}
