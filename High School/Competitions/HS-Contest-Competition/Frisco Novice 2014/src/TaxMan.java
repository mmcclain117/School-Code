
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class TaxMan {

    public static void main(String[] args) throws Exception {
        FileWriter ta = new FileWriter("Tax.txt");
        ta.write("85");
        ta.flush();
        ta.close();
        Scanner scan = new Scanner(new File("Tax.txt"));
        final double c = .08375;
        int x = scan.nextInt();
        System.out.println("Tax Amount $ " + x * c);
    }
}
