
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob06 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));
        double a = (scan.nextDouble() / 3);
        double b = (scan.nextDouble() / 3);
        double c = (scan.nextDouble() / 3);
        double output = ((a * b * c));
        out.println((int) Math.ceil(output));
    }

}
