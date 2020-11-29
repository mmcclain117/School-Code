package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob21 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob21.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            // System.out.println(scan.nextLine());
            String b = scan.nextLine();
            String x[] = b.split(" - ");
            System.out.println(Arrays.toString(x));
            // String fin = "";
            String regex = x[1];
            // x[1].replaceFirst(regex, replacement)
            String word = x[0];
            String def = x[1].replaceAll("[^" + x[0] + "]", " ");
            System.out.println(work(word, def));
            // System.out.println(fin);
        }
    }

    private static boolean work(String a, String b) {
        if (a.equals("")) {
            return true;
        } else {
            for (int i = 0; i < b.length() - 2; i++) {
                if (a.contains(b.substring(i, i + 2))) {
                    int con = i + 2;
                    while (a.contains(b.substring(i, con))) {
                        con++;
                    }
                    String set = a.replaceFirst(b.substring(i, con - 1), "");
                    System.out.println(set);
                    return work(set, b);
                }
//				return work(a.substring(0 , 2), b); // need to fix
//				return false;
            }
            return false;
        }

    }
}
