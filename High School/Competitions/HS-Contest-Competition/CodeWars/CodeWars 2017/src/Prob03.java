
import java.util.*;
import java.io.*;

/**
 *
 * @author Kyle Fromm
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));
        while (scan.hasNext()) {
            int i = scan.nextInt();
            double ans = i * .299792;
            System.out.println(ans);
        }
    }
}
