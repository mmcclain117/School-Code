
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Cody Chang
 */
public class Geming {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("geming.dat"));
        while (scan.hasNext()) {
            int sc = scan.nextInt();
            if (sc == 0) {
                System.out.println("0 -1");
            } else if (sc > 0) {
                int y = (sc * -1) - 1;
                System.out.println(sc + " " + y);
            } else if (sc < 0) {
                int y = (sc * -1) - 1;
                System.out.println(sc + " " + y);
            }
        }
    }
}
