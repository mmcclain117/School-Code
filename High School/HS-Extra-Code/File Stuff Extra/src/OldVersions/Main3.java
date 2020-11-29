package OldVersions;

import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        File st[] = findStart(scan);
        ArrayList<File> ar = new ArrayList();
        ArrayList<File> tempAR = new ArrayList();
        ArrayList<File> Final = new ArrayList();
        ArrayList<File> NS = new ArrayList();

        for (int i = 0; i < st.length; i++) {
            tempAR.add(st[i]);
        }
        int con = 0;
        for (; con < 100; con++) {
//        do {
            /*
             for (int i = 0 ; i < st.length ; i++) {
             //                out.println(st[i]);
             //                out.println(st[i].getName());
             //                out.println(st[i] + " " + st[i].getName() + " " + st[i].listFiles().length);
             out.println(st[i] + " " + st[i].listFiles().length);
             con++;
             }
             */
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).isFile()) {
                    Final.add(ar.get(i));
                } else if (FileNameTest(ar.get(i))) {
                    NS.add(ar.get(i));
                } else {
                    tempAR.add(ar.get(i));
                }
                ar.remove(i);
            }
//            for (int i = 0 ; i < tempAR.size() ; i++) {
            while (!tempAR.isEmpty()) {
                File g[] = tempAR.get(0).listFiles();
//                out.println(Arrays.toString(g));
                for (int u = 0; u < g.length; u++) {
                    ar.add(g[u]);
                }
                tempAR.remove(0);
            }
        }
//        } while (run);
        /*
         while (run)
         FileWriter N = new FileWriter(new File("NF.txt"));
         for (File NF1 : NF) {
         N.write(NF1.getName() + "\n");
         }
         N.flush();
         N.close();
         FileWriter fi = new FileWriter(new File("FinishList.txt"));
         for (File Fin1 : Fin) {
         fi.write(Fin1.getName() + "\n");
         }
         fi.flush();
         fi.close();
         FileWriter fol = new FileWriter(new File("FolderList.txt"));
         for (File Fol1 : Fol) {
         fol.write(Fol1.getName() + "\n");
         }
         fol.flush();
         fol.close();
         }
         run = false;
         */
    }

    private static boolean Test(String y) {
        return y.equalsIgnoreCase("full");
    }

    private static File[] findStart(Scanner scan) {
        out.println("Enter in the folder || file");
        out.println("Enter full if you want to fully scan computer");
//        String y = scan.nextLine();
        String y = "C:\\Users\\Jacob\\Desktop\\Final\\Erica Soccer Stuff";
//        String y = "full";
        if (Test(y)) {
            return File.listRoots();
        } else {
            return new File(y).listFiles();
        }
    }

    private static boolean FileNameTest(File get) throws IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        File gp[] = get.listFiles();
        out.println(Arrays.toString(gp));
        if (gp == null) {
            return true;
        } else {
            for (int i = 0; i < gp.length; i++) {
                if (gp[i] == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
