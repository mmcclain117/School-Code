
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class OddPrime {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("K.txt"));
//        int a = scan.nextInt();
        for (int b = scan.nextInt(); b > 0; b--) {
//        for (int b = 0; b < a; b++) {
            int a = scan.nextInt();
            boolean x = isPrime(a);
            if (x) {
                out.println(a + " satisfies the the requirement");
            }
            if (!x) {
                out.println(a + " doesn't satisfy the requirement");
            }
        }
        scan.close();
    }

    public static boolean isPrime(int i) {
        int sqrt = (int) ceil(sqrt(i));
        for (int j = 2; j < sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("K.txt");
        fw.write("2\n"
                + "2\n"
                + "15");
        fw.flush();
        fw.close();
    }
}
