package rake;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class rake10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String a = scan.nextLine();
        while (!"-1".equals(a)) {
            int b[] = intify(a);
//            int le = b.length;
//            int leng = (int) Math.ceil(Math.sqrt(le));
//            int c[] = new int[leng * leng];
            int c[] = new int[b.length + 30];
            int l = 0; // level
            int ml = 1; // Max level
            int p = 0;
            int s = 1; // Spot
            boolean left = true; // Left
            while (p < b.length) {
                if (b[p] == -1) {
//                    System.out.println(s -1);
                    if (left) {
                        s++;
                        left = false;
                    } else {
                        left = true;
//                        if (s - l > 0) {
//                        while (b[s - l] == -1 && s - 1 > 0) {
                        while (s - 1 > 0 && s - 1 < b.length) {
                            if (b[s - 1] == -1) {
                                l--;
                                s -= Math.pow(2, l);
                            } else {
                                break;
                            }
//                            if (s - l < 0) {
//                                break;
//                            }
//                            }
                        }
                    }
//                    p++;
                    s++;
                } else {
//                    System.out.println(b.length);
                    System.out.println(s);
//                    System.out.println(b[p]);
                    if (left) {
                        s++;
                    } else {
                        left = true;

                    }
                    if (!(s < 0 && s < b.length)) {

//                        break;
//                    } else {
                        c[s] += b[p];
                        s += Math.pow(2, l) - 1;
                        l++;
                    } else {
                        System.out.print(s + " ");
                    }
//                        if (ml < l) {
//                            ml = l;
//                        }
//                    p++;
//                    }
                }
                p++;
            }
//            System.out.println(ml);
//            System.out.println(c.length);
            System.out.println(Arrays.toString(c));
            int cons = 1;
            int level = 2;
            while (cons < c.length) {
                if (cons + 2 < c.length) {
//                    if (cons > 5) {
                    if (c[cons + 1] == 0 && c[cons + 2] == 0) {
                        System.out.println(c[cons]);
                    } else {
                        int te = (int) (Math.pow(2, level) - cons);
                        if (te > 0 && te < c.length) {
                            if (c[te] != 0) {
                                c[cons] += c[te];
                            }
                        }
                        level++;
                    }
//                    }
                }
                cons++;
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
