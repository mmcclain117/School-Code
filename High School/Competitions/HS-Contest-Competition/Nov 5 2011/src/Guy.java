
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Guy {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("a.txt"));
        while (scan.hasNext()) {
            int b = scan.nextInt();
            int a = scan.nextInt();
            double c = b / a;
            System.out.println((int) c);
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("a.txt");
        fw.write("135 20\n"
                + "10 15\n"
                + "10001 57");
        fw.flush();
        fw.close();
    }
}
