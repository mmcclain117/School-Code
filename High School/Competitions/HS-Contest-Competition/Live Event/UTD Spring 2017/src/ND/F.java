package ND;

import java.io.File;
import static java.lang.Math.abs;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class F {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("F.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = "GO " + scan.nextLine();
            char ch[] = b.toCharArray();
            int tot = 0;
            int las = 1;
//            int fin = 0;
            for (int ii = 0; ii < ch.length; ii++) {
                int cur = 27;
                if (Character.isAlphabetic(ch[ii])) {
//                    System.out.println();
                    cur = ch[ii] - 'A' + 1;
//                    fin += ch[ii] - 'A' - 1;
                }
//                fin++;
                int clo = abs(cur - las); // Clocktwise
                int cclo = 27 - clo; // Counter Clockwise
//                if (clo < 0 || cclo < 0) {
//                    System.out.println(clo + " " + cclo);
//                }
                if (clo < cclo) {
                    tot += clo;
                } else {
                    tot += cclo;
                }
                las = cur;
            }
            double cir = Math.PI * 4;
            cir /= 26; // Number of spots
//            cir /= 15; // Feet per second speed
//            System.out.println(tot);
//            System.out.println(cir);
            System.out.println((tot * cir) + (ch.length * 2));
//            System.out.println(((fin - tot) * cir) + (ch.length * 2));
//            System.out.println(ch.length * 2);
//            System.out.println(tot * cir);
//            System.out.println(fin);
//            System.out.println("Time Run: " + ((tot / 27) * cir / 15));
//            System.out.println("Time: "+ (ch.length * 2));
//            System.out.println("Time Total: " + ((tot / (100 / 15)) + (ch.length * 2)));
        }
    }

}
