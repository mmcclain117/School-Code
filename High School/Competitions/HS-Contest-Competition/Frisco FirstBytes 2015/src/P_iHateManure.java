
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class P_iHateManure {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("P.txt"));
        int a = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < a - 2; i++) {
            sum += scan.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            sum += scan.nextInt() / 2;
        }
        System.out.println("November manure weight hauled (net): " + sum);
    }

}
