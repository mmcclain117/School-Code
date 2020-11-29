package Round_119;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_EpicGame {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(); // Simon Stones
        int b = scan.nextInt(); // Anti Stones
        int n = scan.nextInt(); // Initial Stones
        boolean w = true;
        boolean cont = true;
        int s = 0;
        while (n > 0 && cont) {
            if (w) {
                s = findGCD(a, n);
            } else {
                s = findGCD(b, n);
            }
            if (s < n) {
                n -= s;
            } else {
                cont = false;
            }
//            n -= s;
//            System.out.println(s);
            w = !w;
        }
        System.out.println((w ? 1 : 0));
//        System.out.println(n);
//        int n1 = a;
//        int n2 = b;
//        while (n1 != n2) {
//            if (n1 > n2) {
//                n1 = n1 - n2;
//            } else {
//                n2 = n2 - n1;
//            }
//        }
//        System.out.print("GCD = " + n1);
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }
}
