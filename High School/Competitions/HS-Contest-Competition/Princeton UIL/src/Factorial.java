
import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Factorial {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("factorial.txt"));
        for (int a = scan.nextInt(); a > 0; a--) {
            int y = scan.nextInt();
            double x = y / 5;
            double q = x + (x / 5);
            out.println((int) q);
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("factorial.txt");
        fw.write("5\n"
                + "25\n"
                + "103\n"
                + "78\n"
                + "249\n"
                + "34");
        fw.flush();
        fw.close();
    }
}
