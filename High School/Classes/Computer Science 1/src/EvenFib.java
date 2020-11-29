
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class EvenFib {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int a = 0; a < n; a++) {
            int b = scan.nextInt();
            ArrayList ar = new ArrayList();
            ar.add(0);
            ar.add(1);
            ar.add(1);
            ar.add(2);
            int con = ar.size();
            while (con < b) {
                int h = (int) ar.get(b - 1) + (int) ar.get(b - 2);
                ar.add(h);
                con++;
            }
        }
    }

    public static int genFib(int a) {
        if (a == 1) {
            return 1;
        } else {
            return genFib(a - 1) + genFib(a - 2);
        }
    }
}
