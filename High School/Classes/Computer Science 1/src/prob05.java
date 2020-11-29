
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob05 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = a * b;
        int e = b + c;
        int f = a * c;
        out.println(a + " x (" + b + " + " + c + ") = " + a + " x " + b + " + " + a + " x " + c);
        out.println(a + " x " + (e) + " = " + (d) + " + " + (f));
        out.println((a * e + " = " + (d + f)));
    }

}
