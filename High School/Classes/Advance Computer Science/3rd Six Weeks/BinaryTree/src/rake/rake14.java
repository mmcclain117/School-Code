
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
public class rake14 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String a = scan.nextLine();
        while (!"-1".equals(a)) {
            int b[] = intify(a);
            int c[] = new int[b.length];
            int l = 1; // level 
            int s = 1; // Spot
            int si = (int) Math.ceil(sqrt(b.length));
//            System.out.println(si);
            c[0] = b[0];
            while (s < b.length) {
                if (b[s] == -1) {
//                    while (b[(int) (s - pow(2, l))] == -1 && s > 0 && l < 1) {
//                    while (b[(int) (s - pow(2, l))] == -1 && s > 0) {
                    /*if (s - pow(2, l) > 0) {
                     while (b[(int) (s - pow(2, l))] == -1) {
                     s -= pow(2, l);
                     l--;
                     if (s - pow(2, 1) < 0) {
                     break;
                     }
                     }
                     }*/
                    if (s - l < 0) {
                        while (b[s - l] == -1) {
                            s -= l;
                            l--;
                            if (s - l > 0) {
                                break;
                            }
                        }
                    }
                    s++;
                } else {
//                    System.out.println(b[s]);
                    c[s] += b[s];
                    s += l;
                    l++;
                }
            }
            System.out.println("C: " + Arrays.toString(c));
//            ArrayList<Integer> ar = new ArrayList();
            for (int d : c) {
                if (d != 0) {
//                    ar.add(d);
                    System.out.print(d + " ");
                }
            }
            System.out.println();
            int cons = 1;
            while (cons < c.length) {
//                int te = (int) (Math.ceil(sqrt(cons)) * 2 + 2);
//                int te = (int) (Math.ceil(sqrt(cons + 1)) * 2)+ 1;
//                int te = (int) sqrt(cons + 1) * 2 + 1;
//                System.out.println("TE: " + te);
//                  int te = (int) cons * 2 + 2;
                int te = (int) cons * 2 + 1;
//                System.out.println(cons);
                if (te < c.length) {
//                    if (b[cons] != -1 && b[te] != -1) {
                    if (c[cons - 1] != 0 && c[te] != 0) {
                        System.out.println("Index " + cons + " Value " + b[cons]);
                        System.out.println("Index " + te + " Value " + b[te]);
//                        b[cons] = b[te];
//                        b[cons - 1] += b[te];
                        b[te] += b[cons - 1];
                        b[cons - 1] = -1;
                        cons++;
                    }
                }
                cons++;
//                break;
            }
            for (int d : b) {
//                    ar.add(d);
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
