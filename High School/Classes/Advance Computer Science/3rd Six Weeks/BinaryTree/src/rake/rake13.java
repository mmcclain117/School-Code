package rake;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class rake13 {

    public static int a[] = new int[20];
    public static int b[] = new int[20];

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        int num = 0;
        String aa = scan.nextLine();
        while (!"-1".equals(aa)) {
            String f[] = aa.split("\\s+");
            int ind = 0;
            fun(f, ind, 0);
            for (int i = 0; i < f.length; i++) {
                int value = Integer.parseInt(f[i]);
            }
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            aa = scan.nextLine();
        }
    }

    public static void fun(String aa[], int ind, int inde) {
        if (inde < aa.length) {
            int value = Integer.parseInt(aa[inde++]);
            if (value != -1) {
                /* add the value to the pile */
                if (ind >= 0) {
                    a[ind] += value;
                } else {
                    b[(-1 * ind) - 1] += value;
                }
                inde++;
                /* recursive calls */
                fun(aa, ind - 1, inde);
                /* left subtree */
                fun(aa, ind + 1, inde);
                /* rigth subtree */
            }
        }
    }
}
/* print the result */
//printf("Case %d:\n", num);
//            for (i = 0; b[i] > 0; i++);
//            for (i = i - 1; i >= 0; i--) {
//                printf("%d ", b[i]);
//            }
//            printf("%d", a[0]);
//            for (i = 1; a[i] > 0; i++) {
//                printf(" %d", a[i]);
//            }
//            printf("\n\n");
//        }
//
//        num++; /* test cases counter */
//
//    }
//*/
