
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Scanner;

public class Rails {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("rails.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String y[] = a.split("\\s+");
//            out.println(a);
            if (y.length == 1) {
            } else {
                boolean inc = false, dec = false;
                int x[] = intify(y);
                if (x[0] > x[1]) {
                    inc = increasing(x);
                } else {
                    dec = decreasing(x);
                }
                out.println(inc || dec ? "Yes" : "No");
            }
        }
    }

    private static int[] intify(String[] y) {
        int p = y.length;
        int u[] = new int[p];
        for (int i = 0; i < p; i++) {
            u[i] = Integer.parseInt(y[i]);
        }
        return u;
    }

    private static boolean increasing(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (!(x[i] > x[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean decreasing(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (!(x[i] < x[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
