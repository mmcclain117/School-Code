
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Encrypt {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.println("Enter the Path Name");
        String path = scan.nextLine();
        while (!(path.equals("Done"))) {
            ArrayList codeIn = new ArrayList();
            ArrayList codeOut = new ArrayList();
            char con = 'a';
            for (int i = 0; i < 26; i++) { // Lowercase
                codeIn.add((char) (con + i));
                codeOut.add((char) (con + i));
            }
            con = 'A';
            for (int i = 0; i < 26; i++) { // Uppercase
                codeIn.add((char) (con + i));
                codeOut.add((char) (con + i));
            }
            WriteInp(path, codeIn);
            Random rnd = new Random();
            for (int u = 0; u < 50; u++) {
                Collections.shuffle(codeOut, rnd);
            }
            WriteOut(path, codeOut);
            Replacing(path, codeIn, codeOut);
            out.println("Enter another path or Done to exit");
            path = scan.nextLine();
        }
    }

    private static void WriteInp(String path, ArrayList codeIn) throws Exception {
        path = path + "_In.txt";
        FileWriter fw = new FileWriter(new File(path));
        for (int i = 0; i < codeIn.size(); i++) {
            fw.write((String) (codeIn.get(i) + "\n"));
        }
        fw.flush();
        fw.close();
    }

    private static void WriteOut(String path, ArrayList codeIn) throws Exception {
        path = path + "_Out.txt";
        FileWriter fw = new FileWriter(new File(path));
        for (int i = 0; i < codeIn.size(); i++) {
            fw.write((String) (codeIn.get(i) + "\n"));
        }
        fw.flush();
        fw.close();
    }

    private static void Replacing(String path, ArrayList codeIn, ArrayList codeOut) throws Exception {
        Scanner scan = new Scanner(new File((path + ".txt")));
        String fi = "";
        while (scan.hasNext()) {
            fi += scan.nextLine();
        }
        path += "_Encrypt.txt";
        FileWriter fw = new FileWriter(new File(path));
        for (int i = 0; i < codeIn.size(); i++) {
            char a = (char) codeIn.get(i);
            char b = (char) codeOut.get(i);
            fi = fi.replace(a, b);
        }
        fi = fi.replace(' ', ' ');
        Scanner in = new Scanner(fi);
        while (in.hasNext()) {
            String h = in.next() + " ";
            fw.write(h);
        }
        fw.flush();
        fw.close();
    }
}
