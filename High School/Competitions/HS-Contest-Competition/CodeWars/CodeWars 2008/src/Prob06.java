
/**
 * Problem: PERLs Before Swine
 */
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));
//        scan.nextLine();
//        String a = scan.nextLine();
//        scan.nextLine();
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b[] = a.split("\\s+");
            int con = 0;
            for (int i = b.length - 1; i > 0; i--) {
                if (b[i].contains("=") && con == 0) {
                    con = i;
                }
            }
            int t = con - 1;
            con--;
//            System.out.println(Arrays.toString(b));
            while (con < b.length - 1) {
                System.out.print(b[con++] + " ");
            }
            System.out.print(b[con].substring(0, b[con].length() - 1));
            int s = 0;
            while (s < t) {
                System.out.print(" " + b[s++]);
            }
            System.out.println(";");
//            a = scan.nextLine();
        }
    }

}
