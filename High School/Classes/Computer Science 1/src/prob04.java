
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob04 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.nextLine();
//        scan.nextLine();
        do {
            Scanner in = new Scanner(a);
            a = scan.nextLine();
            int b = in.nextInt();
            int c = in.nextInt();
            out.println(b * c);
        } while (!(a.matches("0 0")));
    }
}
