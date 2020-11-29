
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Plutonium {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("N.txt"));
        int n = scan.nextInt();
        out.println("Prep this much: " + (2015 - n));
        scan.close();
    }
}
