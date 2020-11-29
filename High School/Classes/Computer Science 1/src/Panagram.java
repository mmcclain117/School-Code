
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Panagram {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));

        while (scan.hasNext()) {
            String a = scan.nextLine();
            char cha[] = new char[100];
            pan(a);
            out.println(Arrays.toString(cha));
            out.println(a);
        }
    }

    public static void pan(String a) {
        char ch[];
        ch = new char[27];
        for (int chc = 0; chc < 26; chc++) {
            ch[chc] = (char) (chc + 65);
        }
        char xy[];
        xy = new char[a.length()];
        a = a.trim().replaceAll(" ", "").replaceAll("[^A-Z]", "");
        xy = a.toCharArray();
        Arrays.sort(xy);
        int b = 0;
        int as = 0;
        int count[] = new int[26];
        for (int y = 0; xy.length > y; y++) {
            if (ch[y] > xy[b]) {
                b++;
            } else if (ch[y] == xy[b]) {
                count[as] += 1;

            } else if (ch[y] < xy[b]) {
                as++;
                b++;
            }
        }
        out.println(Arrays.toString(count));
        Arrays.fill(count, 0);
    }
}
