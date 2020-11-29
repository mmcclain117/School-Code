
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Fly {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("J2.txt"));
        int gh = scan.nextInt();
        for (int hg = 0; hg < gh; hg++) {
            int u = scan.nextInt();
            double d = scan.nextDouble();
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double f = scan.nextDouble();
            double as = d / (a + b);
            out.print(u + " ");
            out.printf("%.2f", (as * f));
            out.println();
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("J2.txt");
        fw.write("5\n"
                + "1 250 10 15 20\n"
                + "2 10.7 3.5 4.7 5.5\n"
                + "3 523.7 15.3 20.7 33.3\n"
                + "4 1000 30 30 50\n"
                + "5 500 15 15 25");
        fw.flush();
        fw.close();

    }
}
