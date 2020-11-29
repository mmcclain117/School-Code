package HTML_Making;

import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ShortCut {
//[InternetShortcut]
//URL=file://H:/directory/aplication.jar
//IconIndex=0
//IconFile=H:\directory\images\icon.ico

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Files.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine().trim();
            String b = scan.nextLine().trim();
            a.replaceAll("[ ]+", "_");
            b.replaceAll("[ ]+", "_");
            String c = "C:\\Users\\Jacob\\Dropbox\\Secret\\Bookmark Bar\\Test Folder";
            String d = c + "\\" + b + ".URL";
            out.println(a + "\t" + b + "\t" + c + "\t" + d);
            Write(d, a);
        }
    }

    private static void Write(String d, String a) throws Exception {
        FileWriter fw = new FileWriter((d));
        fw.write("[InternetShortcut]\n");
        fw.write(a);
        fw.flush();
        fw.close();
    }
}
