
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Writing.Write03();
        Scanner scan = new Scanner(new File("Prob03.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b[] = a.split("[ ]+");
            int le = b.length;
            out.println(le);
            int c[] = new int[le];
            int d[] = new int[le];
            for (int i = 0; i < le; i++) {
                String e = b[i];
                c[i] = Integer.parseInt(e);
            }
            Arrays.sort(c);
            for (int k = 0; k < le; ++k) {
                d[k] = c[le - 1];
                k++;
                d[k] = c[k + 1];
            }
        }
    }

}