
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class D {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("D.txt"));
        int test = scan.nextInt();
        for (int k = 0; k < test; k++) {
            ArrayList<Integer> x = new ArrayList();
            ArrayList<String> y = new ArrayList();
            int n = scan.nextInt();
            for (int i = n / 2; i < n; i++) {
                if (!Pair(i, n - i).equals("A")) {
                    x.add(i);
                    y.add(Pair(i, n - i));
                }
            }
            System.out.println("Problem " + (k + 1) + ": " + x.size());
            for (int i = 0; i < x.size(); i++) {
                System.out.println(x.get(i) + " + " + y.get(i) + " = " + n);
            }
        }
    }

    private static String Pair(int a, int b) {
        String fin = a + ""; // Based of change
//        StringBuffer go = new StringBuffer();
//        go.setLength(fin.length() - 1);
//        go.append(b);
        String go = b + ""; // Goal
        if (go.length() + 1 < fin.length()) {
            for (int i = go.length(); i < fin.length() - 1; i++) {
                go = "0" + go;
            }
//            System.out.println(go);
        }
        for (int o = 0; o < fin.length(); o++) {
            if ((fin.substring(0, o) + fin.substring(o + 1)).equals(go)) {
                return go;
            }
        }
        return "A";
    }
}
