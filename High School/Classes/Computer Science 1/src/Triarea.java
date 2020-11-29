
import java.util.*;

/**
 *
 * @author Master
 */
public class Triarea {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double d = scan.nextDouble();
        double e = scan.nextDouble();
        double f = scan.nextDouble();
        double di = Math.sqrt(Math.pow(a - c, a - c) + Math.pow(b - d, b - d));
        double dis = Math.sqrt(Math.pow(c - e, c - e) + Math.pow(d - f, d - f));
        double dist = Math.sqrt(Math.pow(e - a, e - a) + Math.pow(f - b, f - b));
    }
}
