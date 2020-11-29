
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class HTML2 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("html.dat"));
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; ++i) {
            out.println(in.nextLine().replaceAll(">[^<]*<", "><").equals(in.nextLine().replaceAll(">[^<]*<", "><")) ? "YES" : "NO");
        }
    }
}
