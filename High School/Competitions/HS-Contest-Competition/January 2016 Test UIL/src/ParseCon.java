
import java.io.File;
import java.util.Scanner;


/**
 *
 * @author Master
 */
public class ParseCon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("parsecon.txt"));
        String a = scan.nextLine();
        while (scan.hasNext()) {
            a = a.replaceAll("+", " + ");
            a = a.replaceAll("-", " + ");
            String x[] = a.split("\\s+");
            
        }
    }
}
