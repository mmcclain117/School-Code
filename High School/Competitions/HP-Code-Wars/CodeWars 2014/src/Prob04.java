
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Candy Math
//        Points: 5
        Scanner scan = new Scanner(new File("prob04.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        int be = a + 1;
        ArrayList<String> ar = new ArrayList();
        ArrayList<Integer> val = new ArrayList();
//        TreeMap<Strisng, Integer> tr = new TreeMap();
        for (int i = 0; i < b; i++) {
            int c = Math.abs(a - scan.nextInt());
            String d = scan.next();
            ar.add(d);
            val.add(c);
            if (c < be) {
                be = c;
            }
//            tr.put(d, abs(a - c));
        }
        String fin = "";
        for (int i = 0; i < ar.size(); i++) {
            if (val.get(i) == be) {
                fin += ar.get(i) + " ";
            }
        }
        System.out.println(fin.trim());
    }
}
