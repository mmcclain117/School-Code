
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class HoverBoard {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("R.txt"));
        double w1 = 0;
        double w2 = 0;
        double w3 = 0;
        double w4 = 0;
        for (int u = 0; u < 7; u++) {
            w1 += scan.nextDouble();
            w2 += scan.nextDouble();
            w3 += scan.nextDouble();
            w4 += scan.nextDouble();
        }
        double sum = w1 + w2 + w3 + w4;
        double ave = sum / 4;
        out.print("Week ");
        if (w1 < w2 && w1 < w3 && w1 < w4) {
            out.print("1: ");
            double p = 100 - ((w3 / ave) * 100);
            out.println("-" + (int) p + "%");
        } else if (w2 < w3 && w2 < w3 && w2 < w4) {
            out.print("2: ");
            double p = 100 - ((w3 / ave) * 100);
            out.println("-" + (int) p + "%");
        } else if (w3 < w1 && w3 < w2 && w3 < w4) {
            out.print("3: ");
            double p = 100 - ((w3 / ave) * 100);
            out.println("-" + (int) p + "%");
        } else {
            out.print("4: ");
            double p = 100 - ((w3 / ave) * 100);
            out.println("-" + (int) p + "%");
        }
    }
}
