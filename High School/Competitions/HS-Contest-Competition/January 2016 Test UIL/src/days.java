
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class days {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("days.txt"));
        while (scan.hasNext()) {
            int a1 = scan.nextInt(); // Starting month
            int a2 = scan.nextInt(); // Starting day
            int a3 = scan.nextInt(); // Start year
            int b1 = scan.nextInt(); // ending month
            int b2 = scan.nextInt(); // Ending day
            int b3 = scan.nextInt(); // Ending year
            int days = 0;
            if (b3 == a3) { // years are the same

                if (a3 % 4 == 0) {
                    days++;
                }
            } else { // calculate based on year
                
            }
            out.println("There are " + days + " days gone by from" + a3 + "-" + a1 + "-" + a2 + " to " + b3 + "-" + b1 + "-" + b2 + ".");
        }
    }
}
