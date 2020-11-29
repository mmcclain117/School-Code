
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        long nf = fact(n); // N!
        long mf = fact(m); // M!
        long bf = fact(n - m); // (n - m)!
//        System.out.println(nf + " " + mf + " " + bf);
        long s = (nf / (mf * (bf)));
        System.out.println(s);
    }

    private static long fact(int a) {
        long sum = 1;
        for (int i = 1; i <= a; i++) {
            sum *= i;
        }
        return sum;
    }
}
