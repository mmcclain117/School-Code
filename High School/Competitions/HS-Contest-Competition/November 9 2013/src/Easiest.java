
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Easiest {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("l.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            String b = a + "";
            int cx = b.toCharArray().length;
            int c = Integer.parseInt(b.substring(0, cx - 1));
            out.println(a + c);
            a = scan.nextInt();
        }
        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("l.txt");
        fw.write("23\n"
                + "193576\n"
                + "0");
        fw.flush();
        fw.close();
    }
}
