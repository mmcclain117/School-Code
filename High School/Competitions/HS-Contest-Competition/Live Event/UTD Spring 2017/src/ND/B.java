package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("b.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            System.out.println(b);
//            String c[] = b.split("[+-*]+");
            String c[] = b.split("[^A-Z0-9]+");
            String d[] = b.split("[A-Z0-9]+");
            System.out.println(Arrays.toString(c));
            int base = Integer.parseInt(c[c.length - 1]);
            long tot = Integer.parseInt(c[0], base);
            for (int ii = 1; ii < c.length - 2; ii++) {
                String cure = c[ii];
                int cur = 1;
                for (int j = 0; j < cure.length(); j++) {
                    cur *= Integer.parseInt(cure.charAt(j) + "", base);
                }
//                int cur = (Integer.parseInt(c[ii], base));

                if (d[ii - 1].equals("*")) {
                    tot *= cur;
                }
                if (d[ii - 1].equals("+")) {
                    tot += cur;
                }
                if (d[ii - 1].equals("-")) {
                    tot -= cur;
                }
            }
            System.out.println(Integer.toString((int) tot, 10));
            System.out.println(Integer.toString((int) tot, base));
            System.out.println(tot % base);
        }
    }

}
