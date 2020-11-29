
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Tribonacci Numbers
//        Points: 3
        Scanner scan = new Scanner(new File("prob05.txt"));
        int a = scan.nextInt();
        while (a != -1) {
            if (a == 0) {
                System.out.println("0");
            } else if (a == 1 || a == 2) {
                System.out.println("1");
            } else if (a == 3) {
                System.out.println("2");
            } else {
                long f[] = new long[a + 1];
                f[0] = 0;
                f[1] = 1;
                f[2] = 1;
                for (int i = 3; i < a + 1; i++) {
                    f[i] = f[i - 1] + f[i - 2] + f[i - 3];
                }
                System.out.println(f[a]);
            }
            a = scan.nextInt();
        }
    }

}
