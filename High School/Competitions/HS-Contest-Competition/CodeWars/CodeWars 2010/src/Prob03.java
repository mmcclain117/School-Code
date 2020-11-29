
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Happy Numbers
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob03.txt"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = a; // Copy
            while (b >= 10) {
                b = sqr(b);
//            System.out.println(b);
            }
//        System.out.println(b);
            if (b == 1) {
                System.out.println(a + " is a happy number");
            } else {
                System.out.println(a + " is an unhappy number");
            }
        }
    }

    private static int sqr(int b) {
        char ch[] = (b + "").toCharArray();
        int sum = 0;
        for (char c : ch) {
            sum += (c - '0') * (c - '0');
        }
        return sum;
    }
}
