
import java.io.*;
import static java.lang.Math.pow;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class prob07 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob07.txt"));
        while (scan.hasNext()) {
            if ((scan.hasNext("0"))) {
                break;
            } else {
                double b = 1 / 3;
                double per = scan.nextDouble();
                double rail = pow(per, 2);
                double e = Math.pow(rail, .3333);
                out.println(e);
            }
        }
    }

}
