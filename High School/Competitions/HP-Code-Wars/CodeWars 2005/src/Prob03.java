
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Perfect Number
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        int n = scan.nextInt();
        while (n != 0) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }
            if (sum == n) {
                System.out.println(n + " IS perfect.");
            } else {
                System.out.println(n + " IS NOT perfect.");

            }
            n = scan.nextInt();
        }
    }
}
