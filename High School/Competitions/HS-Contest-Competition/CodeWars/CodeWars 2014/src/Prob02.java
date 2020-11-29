
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Check Digits
//        Difficulty: Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob02.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            String c[] = b.split("\\s");
            int d[] = intify(c);
            int sum = 0;
            for (int ii = 0; ii < d.length; ii += 2) {
                sum += d[ii];
            }
            sum *= 3;
            for (int ii = 1; ii < d.length; ii += 2) {
                sum += d[ii];
            }
            sum %= 10;
            if (sum == 0) {
                System.out.println(b + " 0");
            } else {
                System.out.println(b.trim() + " " + (10 - sum));
            }
        }
    }

    private static int[] intify(String[] b) {
        int c[] = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] = Integer.parseInt(b[i]);
        }
        return c;
    }
}
