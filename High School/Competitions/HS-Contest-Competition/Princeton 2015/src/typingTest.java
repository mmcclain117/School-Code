
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class typingTest {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("typingtest.dat"));
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int s = scan.nextInt();
            String a = scan.nextLine();
            String y[] = a.split("\\s+");
            out.println((y.length / s) * 60 + " WPM");
        }
    }
}
