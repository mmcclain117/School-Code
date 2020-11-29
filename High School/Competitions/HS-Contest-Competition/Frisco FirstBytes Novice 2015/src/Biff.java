
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;
/**
 * 
 * @author Master Ward
 */
public class Biff {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("O.txt"));
        for (int i = 0; i < 3; i++) {
            double n = scan.nextDouble();
            if (n >= .10) {
                System.out.println("DUI");
            } else {
                out.println("Warning");
            }
        }
    }
}
