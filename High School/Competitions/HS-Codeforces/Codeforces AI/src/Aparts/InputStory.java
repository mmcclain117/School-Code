package Aparts;

import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class InputStory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        File f = new File("Var Files\\Input Story");
//        File f = new File("Input Story");
        File f = new File("Output Story");
        File tp[] = f.listFiles();
//        File f1 = new File("Var Files\\Input Mod");
//        File f1 = new File("Input Mod");
        File f1 = new File("Output Story Mod");
        f1.mkdir();
        out.println(tp.length);
        for (int i = 0; i < tp.length; i++) {
            Scanner scan = new Scanner(tp[i]);
            String a = "";
            while (scan.hasNext()) {
                a += scan.nextLine();
            }
            File rev = new File(f1.getPath() + "\\" + tp[i].getName());
            FileWriter fw = new FileWriter(rev);
            out.println(tp[i].getName());
            String ne = rem(a);
            fw.write(ne);
            fw.flush();
            System.gc();
        }
    }

    public static String rem(String a) {
        while (a.contains("<")) {
            int sa = a.indexOf("<");
            int en = a.indexOf(">");
            a = a.substring(0, sa) + " " + a.substring(en + 1);
        }
        String ye[] = a.split("\\s+");
        String fin = "";
        for (int i = 0; i < ye.length; i++) {
            fin += ye[i].trim() + " ";
        }
        return fin;
    }
}
