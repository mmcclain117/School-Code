
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Rectangles {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("rectangles.txt"));
        for (int a = scan.nextInt(); a > 0; a--) {
            double c = scan.nextDouble();
            double d = scan.nextDouble();
            double e = scan.nextDouble();
            double f = scan.nextDouble();
            double g = scan.nextDouble();
            double h = scan.nextDouble();
            double i = scan.nextDouble();
            double j = scan.nextDouble();
            double k = scan.nextDouble();
            double l = scan.nextDouble();
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            if (x < c && x > e) {
                System.out.println("YES" + x);
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("rectangles.txt");
        fw.write("2\n"
                + "-3.2 1.5 4.7 -2.8 -2.4 7.3 8.5 -1.6 1.1 0.8\n"
                + "-17.4 9.8 -5.2 3.6 -11.3 7.1 12.4 0.6 -2.5 4.3");
        fw.flush();
        fw.close();
    }
}
