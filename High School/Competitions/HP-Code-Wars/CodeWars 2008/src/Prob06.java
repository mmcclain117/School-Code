
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: PERLs Before Swine
//        Points: 6
        Scanner scan = new Scanner(new File("prob06.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String b[] = line.split("\\s+");
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
        }
    }

}
