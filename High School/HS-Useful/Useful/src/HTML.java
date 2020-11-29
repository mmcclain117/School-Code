
import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 *
 * @author Shivam
 */
public class HTML {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("html.dat"));
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; ++i) {
            out.println(in.nextLine().replaceAll(">[^<]*<", "><").equals(in.nextLine().replaceAll(">[^<]*<", "><")) ? "YES" : "NO");
        }
    }
}
