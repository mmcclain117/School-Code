
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/*
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String args[]) throws Exception {
//        Problem: Maximum Product of Three
//        Points: 5
        Scanner scan = new Scanner(new File("prob07.txt"));
        int n = scan.nextInt();
        while (n != 0) {
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scan.nextInt();
            }
//            System.out.println(b[0]);
            if (n == 2) { // Only 2 numbers
                System.out.println(b[0] * b[1]);
            } else if (n == 1) { // Only 1 number
                System.out.println(b[0]);
            } else {
                int a1 = b[0]; // Most
                int a2 = b[1]; // Middle
                int a3 = b[2]; // Least
                /* Pointing to the least number */
                if (a1 < a2) {
                    int temp = a1;
                    a1 = a2;
                    a2 = temp;
                }
                if (a1 < a3) {
                    int temp = a1;
                    a1 = a3;
                    a3 = temp;
                }
                if (a2 < a3) {
                    int temp = a2;
                    a2 = a3;
                    a3 = temp;
                }

                for (int i = 3; i < n; i++) {
                    if (b[i] > a3) {
                        if (b[i] > a2) {
                            if (b[i] > a1) {
                                a3 = a2;
                                a2 = a1;
                                a1 = b[i];
                            } else {
                                a3 = a2;
                                a2 = b[i];
                            }
                        } else {
                            a3 = b[i];
                        }
                    }
                }
//                System.out.println(a1 + " " + a2 + " " + a3);
                System.out.println(a1 * a2 * a3);
            }
            n = scan.nextInt();
        }
    }
}
