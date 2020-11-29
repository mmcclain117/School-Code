
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Dryrun {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            out.println("Hello " + scan.nextLine() + "!");
        }
    }
}
