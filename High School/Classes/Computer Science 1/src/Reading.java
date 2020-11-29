
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Reading {

    public static void main(String args[]) throws Exception {
        Scanner theFile = new Scanner(new File("June 29, 2015.txt"));
        FileWriter fw = new FileWriter(new File("Words.txt")); // Edited Edition
        String Cur = ""; // Line of the whole File
        while (theFile.hasNext()) {
            Cur += theFile.next().toLowerCase() + " ";
        }
        String cur[] = Cur.split("\\s+"); // Array of each word
        ArrayList<Integer> capPlace = new ArrayList<>();
        char ch[] = Cur.toCharArray();
        cur[0] = Capitalize(cur[0]);
        ArrayList edit = new ArrayList();
        for (int i = 0; i < cur.length; i++) {
            edit.add((String) cur[i]);
        }
        String almost = Arrays.toString(edit.toArray());
        // Capitalize every letter after a Punctuation
        int u = 0;
        while (u < ch.length) {
            if (ch[u] == '.' || ch[u] == '?' || ch[u] == '!') {
                capPlace.add(u);
            }
            u++;
        }
        Scanner scan = new Scanner(System.in);
        out.println("Any other words Enter below and will Be replaced in the Version "
                + "with\n"
                + "Old Version\n"
                + "New Version\n"
                + "and When Done type Done to End\n");
        while (!(scan.hasNext("Done"))) {
            String a = scan.nextLine().trim();
            String b = scan.nextLine().trim();
            Collections.replaceAll(edit, a, b);
        }
        out.println(Arrays.toString(edit.toArray()));
        fw.flush();
        fw.close();
        theFile.close();
    }

    private static String Capitalize(String a) {
        return a.substring(0, 1).toUpperCase() + a.substring(1);
    }
}
