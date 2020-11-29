
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Decrypt {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.println("Enter the Path Name");
        String path = scan.nextLine();
        while (!(path.equals("Done"))) {
            Scanner in = new Scanner(new File((path + "_In")));
            Scanner Out = new Scanner(new File((path + "_Out")));
            ArrayList codeIn = new ArrayList();
            ArrayList codeOut = new ArrayList();
            for (int i = 0; i < codeIn.size(); i++) {
                String a = in.next();
                String b = Out.next();
                codeIn.add(a);
                codeOut.add(b);
            }

            WriteOut(path, codeOut);
            Replacing(path, codeIn, codeOut);
            out.println("Enter another path or Done to exit");
            path = scan.nextLine();
        }
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
        path += "_Encypt.txt";
        FileWriter fw = new FileWriter(new File(path));
        for (int i = 0; i < codeIn.size(); i++) {
            char a = (char) codeIn.get(i);
            char b = (char) codeOut.get(i);
            fi = fi.replace(a, b);
        }
//        fi = fi.replace(' ', '1');
        Scanner in = new Scanner(fi);
        while (in.hasNext()) {
            String h = in.next() + "\n";
            fw.write(h);
        }
        fw.flush();
        fw.close();
    }
}
