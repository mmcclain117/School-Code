
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class big_problem {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("tax.txt"));
        short n = scan.nextShort();
        final double tax = .08375;
        System.out.println(n * tax);
    }

    private static void Write() throws IOException {
        FileWriter fw = new FileWriter("tax.txt");
        fw.write("100");
        fw.flush();
        fw.close();
    }
}
