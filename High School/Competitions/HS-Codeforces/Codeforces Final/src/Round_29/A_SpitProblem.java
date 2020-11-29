package Round_29;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_SpitProblem {

    /**
     * Tags: Brute Force, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int n = scan.nextInt();
//        X ^ N = B / A
//        double eq = a / b;
        int sum = 0;
        long st = System.nanoTime();
        long d = System.currentTimeMillis();
        boolean x = true;
//        Log Base (= to) =  Exponent
        for (int i = -1010; i < 100; i++) {
            double q = Math.pow(i, n);
//            sum += q == eq ? 1 : 0;
            if (q * a == b) {
                if (i < 0) {
                    if ((Math.pow((i * -1), n) * a) == b) {
                        System.out.println(Math.abs(i));
                    } else {
                        System.out.println(i);
                    }
                } else {
                    System.out.println(i);
                }
                x = false;
                break;
            }
        }
//        System.out.println(d - System.currentTimeMillis());
//        long en = System.nanoTime();
//        System.out.println(en - st);
        if (x) {
            System.out.println("No solution");
        }
//        System.out.println(sum);
    }
}
