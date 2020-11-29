
import java.io.File;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class FruitMath {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob15.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        int I[][] = new int[a][a];
        String b[][] = new String[a][a];
        for (int i = 0; i < a; i++) {
            String l = scan.nextLine().trim();
            String lb[] = l.split("[ ]+");
            List am = new ArrayList();
            List pm = new ArrayList();
            int p = 0;
            char ch[] = new char[a];
            ch = Arrays.toString(lb).toCharArray();
            while (p < ch.length) {
                if (Character.isLetter(ch[p])) {
                    am.add(ch[p]);
                    p++;
                } else if (Character.isDigit(ch[p])) {
                    pm.add(ch[p]);
                    p++;

                } else {
                    p++;
                }
            }
            out.println(am.size());
        }
    }
}
