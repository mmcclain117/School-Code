
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Overtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("overtime.txt"));
        while (scan.hasNext()) {
            double sum = 0;
            int hour = 0;
            for (int i = 0; i < 7; i++) {
                int a = scan.nextInt();
                hour += a;
                double day = a * 10;
                if (a > 8) {
                    day += ((a - 8) * 1.5);
                }
                if (i == 0) {
                    day *= 1.5;
                }
                if (i == 6) {
                    day *= 2.25;
                }
                sum += day;
            }
            if (hour > 40) {
                sum += 2.5 * (hour - 40);
            }
            out.println("$" + sum);
        }
    }
}
