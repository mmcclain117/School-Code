
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class E_paperWriter {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Writer.txt"));
        String a = scan.nextLine();
        int b = scan.nextInt();
        for (int i = 0; i < b; i++) {
            String c = scan.next();
            String d = scan.nextLine();
            d = d.trim(); // To remove the extra space
            if (a.contains(c)) {
                a = a.replaceAll(c, d);
            }
        }
        System.out.println(a);
    }

}
