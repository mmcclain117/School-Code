
import java.io.File;
import static java.lang.StrictMath.abs;
import static java.lang.System.out;
import java.util.Scanner;

public class Chimp {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Chimp.txt"));
        int a = scan.nextInt();
        int l[] = new int[a];
        int cur = 0, smal = 0, lar = 0;
        for (int i = 0; i < a; i++) {
            l[i] = scan.nextInt();
        }
        int b = scan.nextInt();
        int q[] = new int[b];
        for (int i = 0; i < b; i++) {
            q[i] = scan.nextInt();
        }
        for (int aa = 0; aa < a; aa++) {
            cur = q[aa];
            smal = l[0];
            lar = l[b - 1];
            for (int bb = 0; bb < b; bb++) {
                int compare = l[bb];
                if (compare < cur) {
                    if (abs(cur - compare) < abs(cur - smal) && abs(cur - compare) != 0) {
                        smal = compare;
                    }
                }
                if (compare > cur) {
                    if (cur - compare > cur - lar) {
                        lar = compare;
                    }
                }
            }
            String large = lar > cur ? lar + "" : "X";
            out.println(smal + " " + large);
        }
        scan.close();
    }
}
