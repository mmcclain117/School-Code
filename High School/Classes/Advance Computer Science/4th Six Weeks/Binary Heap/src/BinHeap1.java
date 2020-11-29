
import java.io.File;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinHeap1 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a.txt"));
        String a = scan.nextLine();
        String b[] = a.split("\\s+");
        int c[] = new int[b.length + 1];
        for (int i = 0; i < c.length - 1; i++) {
            c[i + 1] = Integer.parseInt(b[i]);
//            if (c[i + 1] != null && c[i +1] < c[i / 2] ) {
            int te = i;
//            int sq = (int) (te - (sqrt(te)));
//            System.out.println(sq);
//            if (te % 2 == 0 && te != 0) {
//                sq--;
//            }
//            while (c[te + 1] < c[(int) (te - sqrt(te))]) {
            int sq = (te) / 2;
            if (te % 2 == 1) {
                sq++;
            }
            System.out.println(c[te + 1] + " vs " + c[sq]);
            while (c[te + 1] < c[sq]) {
                System.out.println("Before " + Arrays.toString(c));
//                sq = te - (int) (sqrt(te));
//                sq = (te) / 2;

                System.out.println(c[te + 1] + " switched " + c[sq]);
//                System.out.println((int) (te - sqrt(te)));
//                if (te % 2 == 0) {
//                    te++;
//                }
                int tem = c[sq];
                c[sq] = c[te + 1];
                c[te + 1] = tem;
                System.out.println("Switched " + Arrays.toString(c));
//                te -= (int) (te - sqrt(te));
//                te -= sq;
                te /= 2;
                sq = te / 2;
                if (te % 2 == 1) {
                    sq++;
                }
                System.out.println("After " + c[te + 1] + " " + c[sq]);
//                int tem = c[te / 2];
//                c[te / 2] = c[te + 1];
//                c[te + 1] = tem;
//                System.out.println("Switched " + Arrays.toString(c));
//                te /= 2;
            }
        }
        System.out.println(Arrays.toString(c));

    }

}
