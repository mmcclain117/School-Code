
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Pepsi {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Q.txt"));
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int u = 500;
            u -= scan.nextInt();
            int dol = ((int) (u / 100));
            u %= 100;
            int hd = (int) u / 50;
            u %= 50;
            int qu = ((int) (u / 25));
            u %= 25;
            int di = (int) u / 10;
            u %= 10;
            int ni = (int) u / 5;
            u %= 5;
            int pe = (int) u / 1;
            u %= 1;
            out.println(dol + " dollars");
            out.println(hd + " half dollar");
            out.println(qu + " quarters");
            out.println(di + " dimes");
            out.println(ni + " nickles");
            out.println(pe + " pennies");
            out.println();
        }
    }
}
