
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class CVSReader {

    public static void main(String[] args) throws Exception {
        Scanner scan1 = new Scanner(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\Messages 3\\Text\\Aaron  Putnam.csv"));
        int i = 0;
        while (scan1.hasNext()) {
            String a = scan1.nextLine();
            out.println(i + " ");
            Scanner in = new Scanner(a);
            String b[] = a.split("[,]+");
            out.println(Arrays.toString(b));
            while (in.hasNext()) {
                out.println(in.next() + " ");
            }
            i++;
        }
    }

}
