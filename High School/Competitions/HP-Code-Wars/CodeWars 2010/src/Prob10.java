
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: List Maker
//        Points: 10
        Scanner scan = new Scanner(new File("prob10.txt"));
        String a = scan.nextLine();
        ArrayList<String> ar = new ArrayList();
        while (!"SHOW".equals(a)) {
            String b[] = a.split("\\s");
            if ("ADD".equals(b[0])) {
                ar.add(b[1]);
            } else if ("INSERT".equals(b[0])) {
                ar.add((ar.indexOf(b[2])), b[1]);
            } else if ("REMOVE".equals(b[0])) {
                ar.remove(b[1]);
            }
            a = scan.nextLine().trim();
        }
        for (String x : ar) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
