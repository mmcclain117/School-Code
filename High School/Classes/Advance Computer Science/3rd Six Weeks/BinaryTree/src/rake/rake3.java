package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class rake3 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
//        int a = scan.nextInt();
//        String e = scan.next();
//        scan.nextLine();
//        for (int i = 0; i < a; i++) {

        String aa = scan.nextLine();
        while (!"-1".equals(aa)) {
            String b[] = aa.split("\\s+");
            int c[] = new int[b.length];
            for (int ii = 0; ii < b.length; ii++) {
                c[ii] = Integer.parseInt(b[ii]);
            }
//            int s = 4; // Spot
            int s = 3; // Spot
            int d[] = new int[11];
            int con = 1;// counter
            d[s] += c[0];
            boolean se = true;
            int ri = 0; // -1 counter
            while (con < c.length) {
//                if (s == 5) {
//                    s++;
//                }
                if (c[con] == -1) {
//                    if (se) {
//                        s++;
//                    }
                    s++;
//                    se = !se;
                    if (ri <= 0) {
                        s = 5;
                    }
//                    if (se) {
//                        s--;
//                    }
//                    se = !se;
                    ri--;
//                    if (ri <= 0) {
//                        s = 5;
//                    }
//                    se = false;
                } else {
//                    System.out.println(c[con] + " "+ con + " " + s + "   " + d[s] + " "+ ri);
                    d[s] += c[con];
                    if (se) {
                        s--;
                    }
                    se = !se;

//                    se = !se
                    if (se) {
                        ri++;
                    } else {
                        ri += 2;
                    }
//                    if (s == 3) {
//                        s--;
//                    }
                }
                con++;
            }
            System.out.println(Arrays.toString(d));
            for (int i = 0; i < d.length; i++) {
                if (d[i] != 0) {
                    System.out.print(d[i] + " ");
                }
            }
            aa = scan.nextLine();
        }
    }
}
