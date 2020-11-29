
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("B.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            out.print(scan.nextInt() + " ");
            int b = scan.nextInt();
            String d = scan.next();
            char ch[] = d.toCharArray();
            int sum = 0;
            String set = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            for (int ii = 0; ii < ch.length; ii++) {
                int u = set.indexOf(ch[ii] + "");
                sum += u;
            }
            int fin = sum % (b - 1);
            if (fin >= 10) {
                out.println(set.substring(fin + 1, fin + 2));
            } else {
                out.println(fin);
            }
        }
    }

}
