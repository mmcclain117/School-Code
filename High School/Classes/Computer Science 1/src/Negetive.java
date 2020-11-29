
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Negetive {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));
        String a;
        String pre = ".";
        while (scan.hasNextLine()) {
            a = scan.nextLine().trim().replaceAll("^[A-Z]", "");
            int count = 0;
            String ch[];
            ch = a.split("\\s+");
            for (String ch1 : ch) {
                if (ch1.matches("DON’T") || ch1.matches("HAVEN'T") || ch1.matches("CAN’T") || ch1.matches("ISN’T") || ch1.matches("CANNOT") || ch1.matches("WOULDN’T") || ch1.matches("COULDN’T") || ch1.matches("NO") || ch1.matches("NOT") || ch1.matches("NEVER") || ch1.matches("NOBODY") || ch1.matches("NOWHERE") || ch1.matches("NEITHER") || ch1.matches("AIN'T")) {
                    count += 1;
                }
            }
            out.println(count + ": " + a);
        }
    }
}
