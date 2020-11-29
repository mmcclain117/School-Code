
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Rdocx {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Test.docx"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            out.println(a);
        }
    }
}
