
import java.io.*;
import static java.lang.System.out;
import java.util.*;

public class voltage {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("voltage.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int u = 0 ; u < a ; u++) {
            double v = 0;
            double i = 0;
            double r = 0;
            double p = 0;
            for (int o = 0 ; o < 2 ; o++) {
                String t = scan.nextLine().replaceFirst("=", "");
                if (t.contains("V")) {
                    v = Double.parseDouble(t.substring(t.length() - 1, t.length()));
                } else if (t.contains("I")) {
                    i = Double.parseDouble(t.substring(t.length() - 1, t.length()));
                } else if (t.contains("R")) {
                    r = Double.parseDouble(t.substring(t.length() - 1, t.length()));
                } else if (t.contains("P")) {
                    p = Double.parseDouble(t.substring(t.length() - 1, t.length()));
                }
            }
            while (v == 0 || i == 0 || r == 0 || p == 0) {
                if (v == 0 && (i != 0 || r != 0)) {
                    v = i * r;
                    p = i * v;
                    break;
                } else if (i == 0 && (v != 0 || p != 0)) {
                    i = v / r;
                    r = v / i;
                    break;
                } else {
                    break;
                }
            }
            out.println("V = " + v + ", I = " + i + ", R = " + r + ", P = " + p);
        }
    }
}
