
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
        Writing.Write01();
        Scanner scan = new Scanner(new File("Prob01.txt"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            String b = rus(a);
            out.println(b);
        }
    }

    public static String rus(int a) {
        String b = "";
        if (a % 3 == 0) {
            b = a % 7 == 0 ? "CODEQUEST" : "CODE";
        } else if (a % 7 == 0) {
            boolean e = !"CODEQUEST".equals(b);
            if (e) {
                b = "QUEST";
            }
        } else if (b.equals("")) {
            b = a + "";
        }
        return b;
    }
}
