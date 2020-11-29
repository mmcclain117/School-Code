package rake;

import java.io.File;
import java.util.Scanner;

public class rake11 {

    private static int[] a = new int[20];
    private static int[] b = new int[20];

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));

        int i;
        int num;
        num = 1;
        while (true) {
            /* at beginning the piles have value 0 */
            for (i = 0; i < 20; i++) {
                a[i] = b[i] = 0;
            }
            /* calls the function */
            fun(0);
            /* check if there are other test cases */
            if (a[0] == 0) {
                System.out.println("0");
                break;
            } else {
                /* print the result */
                System.out.printf("Case %d:\n", num);
                for (i = 0; b[i] > 0; i++) {
                    ;
                }
                for (i = i - 1; i >= 0; i--) {
                    System.out.printf("%d ", b[i]);
                }
                System.out.printf("%d", a[0]);
                for (i = 1; a[i] > 0; i++) {
                    System.out.printf(" %d", a[i]);
                }
                System.out.print("\n\n");
            }
            num++; // test cases counter
        }
        System.out.println("0");
    }

    private static void fun(int ind) {
        int value = 0;
        String tempVar = " ";
//        String tempVar = ConsoleInput.scanfRead();
        if (tempVar != null) {
            value = Integer.parseInt(tempVar);
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
