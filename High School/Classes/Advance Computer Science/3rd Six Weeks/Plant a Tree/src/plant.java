
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class plant {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("plant.txt"));
        int a = scan.nextInt();
        scan.nextLine();
//        scan.nextLine();
        for (int i = 0; i < a; i++) {
            out.println(scan.nextLine());
            String b = scan.nextLine();
            ArrayList<String> ar = new ArrayList();
            while ((!(b.equals(""))) && scan.hasNext()) {
                ar.add(b);
                b = scan.nextLine();
//                out.println(scan.nextLine());
            }
            Collections.sort(ar);
            double size = ar.size() + 1;
            double rate = 100 / size;
//            out.println(rate);
            while (!(ar.isEmpty())) {
                int lasSize = ar.size();
                String te = ar.get(0);
                ArrayList<String> temp = new ArrayList();
                temp.add(te);
                ar.removeAll(temp);
                double amount = rate * (lasSize - ar.size());
                out.printf(te + " %.4f", amount);
                out.println();
//                out.println(te + " " + ((lasSize - ar.size() / size)));
            }
            out.println();
        }
    }
}
