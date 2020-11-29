package OldVersions;

import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Main {

    public static ArrayList<File> ar = new ArrayList();

    public static void main(String[] args) {
        File x[] = File.listRoots();
        out.println(Arrays.toString(x));
//        Path y;
//        File xx[] = x[0].listFiles();
//        File xxx[] = xx[2].listFiles();
//        out.println(Arrays.toString(xxx));
//        out.println(Arrays.toString(xxx[0].listFiles()));
        ArrayList ar = new ArrayList();
//        boolean run = true;
        Scanner scan = new Scanner(System.in);
        out.println("Enter what folder path you want to search\nEnter null if you want to search the whole system.");
        String res = scan.nextLine();
        if (res.equals("null")) {
            ar = searchSystem();
        } else {
            try {
                Scanner in = new Scanner(new File(res));
                File f = new File(res);

            } catch (FileNotFoundException e) {
                System.out.println("There is a problem with the file");
            }
        }
//        while (run) {
        for (File x1 : x) {
            ar.add(x);
        }
        ar.add(x);
//        }
//        y = new File("C:\\Users\\").toPath();
//        int xy = y.getNameCount();
//        out.println(y.getParent() + " " + xy);
    }

    private static ArrayList searchSystem() {
        File y[] = File.listRoots();
        File t[];
        for (File i1 : y) {
            i1.listFiles();
            t = i1.listFiles();
            for (File i2 : t) {
                ar.add(i2);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static ArrayList fileSpecified(File a) {
        throw new UnsupportedOperationException("Not SUpported yet.");
    }
}
