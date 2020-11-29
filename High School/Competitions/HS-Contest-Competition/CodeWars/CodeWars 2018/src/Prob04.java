
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    /* Exchange rates
    G = 10S
    G = 50B
    S = 5B
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            int g = scan.nextInt(); // Gold
            int s = scan.nextInt(); // Silver
            int b = scan.nextInt(); // Bronze
            /* Trade Silver for Bronze */
            if (b % 5 == 0) {
                s += (b - 5) / 5;
                b = 5;
            } else {
                s += b / 5;
                b %= 5;
            }
//            System.out.println(s + " "+ b+ "\n");
            /* Trade Gold for Silver */
            if (s % 10 == 0) {
                g += (s - 10) / 10;
                s = 10;
            } else {
                g += s / 10;
                s %= 10;
            }
            System.out.println(g + " " + s + " " + b);
        }
    }

}
