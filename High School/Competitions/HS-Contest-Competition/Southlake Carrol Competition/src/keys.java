
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class keys {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("keys.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            double x = 100 / scan.nextDouble();
            out.printf("%.2f", x);
            out.println("%");
        }
    }
}
