
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Manure {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("P.txt"));
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum += scan.nextInt();
        }
        int y = scan.nextInt();
        int u = scan.nextInt();
        sum += ((y + u) / 2);
        out.println("November manure weight hauled (net): " + sum);
    }
}
