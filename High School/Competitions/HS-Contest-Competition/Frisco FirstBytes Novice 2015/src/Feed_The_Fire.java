
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;
/**
 * 
 * @author Master Ward
 */
public class Feed_The_Fire {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("T.txt"));
        int y = scan.nextInt();
        int sum = 0;
        boolean j = false;
        while (!j && sum < 88) {
            String a = scan.next();
            if ("Red".equals(a)) {
                sum += 20;
            } else if ("Blue".equals(a)) {
                sum += 10;
            } else if ("Green".equals(a)) {
                sum += 5;
            } else if ("Orange".equals(a)) {
                sum += 1;
            }
            out.println(a + " log added - train speed " + sum + " mph");
            y--;
            j = y == 0;
        }
        if (sum >= 88) {
            out.println("Time travel speed reached! Back to the Future");
        }
    }
}
