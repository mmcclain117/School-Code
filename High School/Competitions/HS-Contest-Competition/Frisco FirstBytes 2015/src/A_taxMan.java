
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */

public class A_taxMan {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Tax.txt"));
        double tax = 0.08375;
        double price = scan.nextInt();
        double sum = tax * price;
        out.println("Tax Amount: $ " + sum);
    }

}
