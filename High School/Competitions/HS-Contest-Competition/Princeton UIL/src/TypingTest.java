
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class TypingTest {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("typingtest.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; a > i; i++) {
            int b = scan.nextInt();
            String c = scan.nextLine();
            String[] d;
            String delim = "\\s+";
            d = c.split(delim);
            int x = (int) d.length / b;
            out.println(x * 60 + " WPM");
        }
        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("typingtest.txt");
        fw.write("2\n"
                + "9 the quick brown fox jumped over the lazy dog\n"
                + "8 this is the story of a girl who cried a river and drowned the whole world");
        fw.flush();
        fw.close();
    }
}
