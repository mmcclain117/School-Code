
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Dupli {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Agar.io.txt"));
        ArrayList ar = new ArrayList();
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = a.replace("//s+", "1");
            if (!(a.equalsIgnoreCase(" ") || b.equalsIgnoreCase("1"))) {
                ar.add(a);
            }
        }
        for (int i = 0; i < ar.size() - 1; i++) {
            if (ar.get(i).toString().equalsIgnoreCase(ar.get(i + 1).toString())) {
                ar.remove(i);
            }
        }
        for (int i = 0; i < ar.size(); i++) {
            out.println(ar.get(i));
        }
    }
}
