package rake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class rake12 {

    private static int[] a = new int[20];
    private static int[] b = new int[20];

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String aa = scan.nextLine();
        int i;
        int num;
        num = 1;
//        while (true) {
        while (!"-1".equals(aa)) {
            /* at beginning the piles have value 0 */
            for (i = 0; i < 20; i++) {
                a[i] = b[i] = 0;
            }
            /* calls the function */
            String f[] = aa.split("\\s+");
            for (int ip = 0; ip < f.length; ip++) {
//                fun(0);
//                System.out.println("SS");
                int ind = Integer.parseInt(f[ip]);
                fun(Integer.parseInt(f[ip]));
                int value = 0;
                String ts = ind + "";
                if (ts != null) {
                    value = ind;
                }

                if (value != -1) {
                    /* add the value to the pile */
                    if (ind >= 0) {
                        a[ind] += value;
                    } else {
                        b[-ind - 1] += value;
                    }

                    /* recursive calls */
                    fun(ind - 1); // left subtree
                    fun(ind + 1); // rigth subtree
                }
            }
            /* check if there are other test cases */
//            if (a[0] == 0) {
//                System.out.println("0");
//                break;
//            } else {
            /* print the result */
            System.out.printf("Case %d:\n", num);
            for (i = 0; b[i] > 0; i++) {
                for (i = i - 1; i >= 0; i--) {
                    System.out.printf("%d ", b[i]);
                }
                System.out.printf("%d", a[0]);
            }
            for (i = 1; a[i] > 0; i++) {
                System.out.printf(" %d", a[i]);
            }
            System.out.print("\n\n");
//            }
            num++; // test cases counter
            aa = scan.nextLine();
        }
        System.out.println("10");
    }

    private static void fun(int ind) throws FileNotFoundException {
//        Scanner scan = new Scanner(new File("rake.dat"));
//        String aa = scan.nextLine();
        int value = 0;
        String ts = ind + "";
//        String tempVar = ConsoleInput.scanfRead();
//        if (tempVar != null) {
        if (ts != null) {
            value = ind;
//            System.out.println("ss");
        }

        if (value != -1) {
            /* add the value to the pile */
            if (ind >= 0) {
                a[ind] += value;
            } else {
                b[-ind - 1] += value;
            }

            /* recursive calls */
            fun(ind - 1); // left subtree
            fun(ind + 1); // rigth subtree
        }
    }

}
