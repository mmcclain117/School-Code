package Round_44;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.util.HashSet;

public class B_Cola {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Soda Goal
        int a = scan.nextInt(); // .5 Liter
        int b = scan.nextInt(); // 1 Liter
        int c = scan.nextInt(); // 2 Liter
        int con = 0;
//        HashSet hs = new HashSet();
        for (int i = 0; i <= a; i++) {
            for (int ii = 0; ii <= b; ii++) {
                for (int iii = 0; iii <= c; iii++) {
                    double xx = ((a - i) * .5) + (b - ii) + ((c - iii) * 2);
                    if (xx == n) {
                        con++;
//                        hs.add(i + " " + ii + " " + iii);
//                        System.out.println((i + " " + ii + " " + iii));
                    }
                }
            }
        }
        System.out.println(con);
//        System.out.println(hs.size());
//        double tot = ((a * .5) + b + (c * 2));
//        out.println(tot);
    }
}
