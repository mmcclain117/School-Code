package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class rake5 {

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
            Node r = new Node(c[0]);
            Node p = new Node(c[1]);
            r.setLeft(p);
            int s = 3; // Spot
            int d[] = new int[11];
            int con = 1;// counter
            d[s] += c[0];
            boolean se = true;
            int ri = 0; // -1 counter

            /*
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
             if (se) {
             s++;
             } else {
             s--;
             }
             ri--;
             }
             con++;
             }*/
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

    public static Node add(Node a) {
        if (a.getData() != -1) {
            a.setLeft(a);
        } else {
            a.setRight(a);
        }
        return a;
    }

    public int depthSum(Node r) {
        return ds(r, 1);
    }

    private int ds(Node r, int l) {
        if (r == null) {
            return 0;
        } else {
            l++;
            if (r.getLevel() != 0) {
                int rig = ds(r.getRight(), r.getLevel());
                int lef = ds(r.getLeft(), r.getLevel());
            } else {
                return l;
            }
        }
        return l;
    }
}
