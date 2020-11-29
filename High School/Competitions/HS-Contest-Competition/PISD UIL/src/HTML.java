
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class HTML {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner in = new Scanner(new File("html.dat"));
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; ++i) {
            out.println(in.nextLine().replaceAll(">[^<]*<", "><").equals(in.nextLine().replaceAll(">[^<]*<", "><")) ? "YES" : "NO");
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("html.dat");
        fw.write("4\n"
                + "<div>hi</div>\n"
                + "<div>hi</div>\n"
                + "<div>hi</div>\n"
                + "<div>hello</div>\n"
                + "<div>hi</div>\n"
                + "<p>hi</p>\n"
                + "<p><b>hello</b> world <b>foobar</b></p>\n"
                + "<p><b>hello</b> world <i>foobar</i></p>");
        fw.flush();
        fw.close();
    }
}
