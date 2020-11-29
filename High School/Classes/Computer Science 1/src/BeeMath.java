
import java.io.*;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class BeeMath {

    public static void main(String[] args) throws Exception { // Done
        Scanner scan = new Scanner(new File("prob01.txt"));
        int a = scan.nextInt();
        while (!(a == 0)) {
            double z = (100 * sqrt(a) + 201 / (a + 1) + 1);
            z += 1;
            out.println(a + " " + (int) z);
            a = scan.nextInt();
        }

    }
}
