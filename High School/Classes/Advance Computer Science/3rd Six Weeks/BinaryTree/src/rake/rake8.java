package rake;

import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class rake8 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String a = scan.nextLine();
        while (!"-1".equals(a)) {
            int b[] = intify(a);
            int c[] = new int[b.length];
            int l = 1; // level
            int p = 0;
            int s = 1; // Spot
//            c[0] = b[0];
//            while (s < b.length && l < b.length) {
            while (p < b.length) {
                if (b[p] == -1) {
                    if (s - l < 0) {
                        while (b[s - l] == -1) {
                            s -= l;
                            l--;
                            if (s - l > 0) {
                                break;
                            }
                        }
                    }
                    p++;
                    s++;
                } else {
//                    System.out.println(s + " " + l + " " + b[p]);
                    c[p] += b[p];
                    s += l;
                    l++;
                    p++;
                }
            }
            System.out.println("C: " + Arrays.toString(c));
            for (int d : c) {
                if (d != 0) {
                    System.out.print(d + " ");
                }
            }
            System.out.println();
            /*
            int cons = 1;
            while (cons < c.length) {
                int te = (int) sqrt(cons + 1) * 2 + 1;
                if (te < c.length) {
                    if (c[cons - 1] != 0 && c[te] != 0) {
                        System.out.println("Index " + cons + " Value " + b[cons]);
                        System.out.println("Index " + te + " Value " + b[te]);
                        b[te] += b[cons - 1];
                        b[cons - 1] = -1;
                        cons++;
                    }
                }
                cons++;
            }
             */
            int cons = c.length - 1;
            while (cons > 1) {
                int te = (int) sqrt(cons + 1) * 2 + 1;
                System.out.println(te);
                if (te < c.length) {
                    System.out.println("Cons: " + cons + "  " + c[cons] + "  Te: " + te + "   " + c[te]);
                    if (c[cons] != 0 && c[te] != 0) {
                        System.out.println("Index " + cons + " Value " + b[cons]);
                        System.out.println("Index " + te + " Value " + b[te]);
                        //                        b[te] += b[cons];
                        //                        b[cons] = -1;
                        b[cons] += b[te];
                        b[te] = -1;
                        cons--;
                    }
                }
                cons--;
            }

            for (int d : b) {
                if (d != -1) {
                    System.out.print(d + " ");
                }
            }
            System.out.println();
            a = scan.nextLine();
        }
    }

    private static int[] intify(String a) {
        String t[] = a.split("\\s+");
        int b[] = new int[t.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(t[i]);
        }
        return b;
    }
}
