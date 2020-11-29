
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Counting Ones
//        Points: 5
        Scanner scan = new Scanner(new File("prob09.txt"));
        int a = scan.nextInt();
        while (a != -1) {
            int sum = 0;
            for (int i = 1; i <= a; i++) {
                sum += one(i);
            }
            a = scan.nextInt();
            System.out.println(sum);
        }
    }

    private static int one(int a) {
        String te = a + "";
        char ch[] = te.toCharArray();
        int sum = 0;
        for (char c : ch) {
            if (c == '1') {
                sum += 1;
            }
        }
        return sum;
    }

}
