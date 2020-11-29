package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class rake4 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String aa = scan.nextLine();
//        for(int ix =0;ix < 3;ix++) {
        while (!"-1".equals(aa)) {
            System.out.println(aa + "  s");
            String b[] = aa.split("\\s+");
            int c[] = new int[b.length];
            for (int ii = 0; ii < b.length; ii++) {
                c[ii] = Integer.parseInt(b[ii]);
            }
            int s = 3; // Spot
            int d[] = new int[11];
            int con = 1;// counter
            d[s] += c[0];
            boolean se = true;
            int ri = 0; // -1 counter
            while (con < c.length) {
                if (c[con] == -1) {
                    if (ri % 2 == 0) {
                        s++;
                    } else {
                        s--;
                    }
                    se = !se;
                    ri--;
                    if (ri <= 0) {
                        ri = 1;
                        s = 4;
                    }
                } else {
                    ri += 2;
                    d[s] += c[con];
//                    if (ri % 2 == 0) {
                    if (se) {
                        s++;
                    } else {
//                    } else {
                        s--;
                    }
//                    se = !se;
//                    }
                    ri--;
                }
                con++;

            }
            /*
             while (con < c.length) {
             if (c[con] == -1) {
             s++;
             if (ri <= 0) {
             s = 5;
             }
             ri--;
             } else {
             d[s] += c[con];
             if (se) {
             s--;
             }
             se = !se;
             if (se) {
             ri++;
             } else {
             ri += 2;
             }
             }
             con++;
             }
             */
            System.out.println(Arrays.toString(d));
            for (int i = 0; i < d.length; i++) {
                if (d[i] != 0) {
                    System.out.print(d[i] + " ");
                }
            }
            System.out.println();
            aa = scan.nextLine();
        }
    }
}
