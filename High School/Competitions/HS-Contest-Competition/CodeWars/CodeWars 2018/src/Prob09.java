
import java.util.Scanner;
import java.io.*;

/*
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));
        int n = scan.nextInt();
        while (n != 0) {
            System.out.print(n + " ");
            String x = Integer.toBinaryString(n);
            int one = 0;
            int zero = 0;
            char ch[] = x.toCharArray();
            for (char c : ch) {
                if (c == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
//			System.out.println(x);
            if (one == zero) {
                System.out.println("BALANCED");
            } else if (one > zero) {
                System.out.println("HEAVY");
            } else if (zero > one) {
                System.out.println("LIGHT");
            }
            n = scan.nextInt();
        }
    }
}
