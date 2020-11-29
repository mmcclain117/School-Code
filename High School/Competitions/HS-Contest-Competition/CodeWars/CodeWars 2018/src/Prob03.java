
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        while (a != 0) {
            String x = a + "";
            boolean work = true;
            for (int i = 1; i < x.length(); i++) {
                if (work) { // Is valid still
                    int first = Integer.parseInt(x.substring(0, i)); // First int
                    int second = Integer.parseInt(x.substring(i)); // Second int
                    int third = first + second;
                    work = isPrime(third);
//                    System.out.println(first + " " + second + " = " + third);
                }
            }
            System.out.println(x + (work ? " MAGNANIMOUS" : " PETTY"));
            a = scan.nextInt();
        }
    }

    public static boolean isPrime(int n) {
        /* Used to fix the problem of 10 returning MAGNANIMOUS */
        if (n == 1) {
            return false;
        }
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
