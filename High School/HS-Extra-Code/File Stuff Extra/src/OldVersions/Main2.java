package OldVersions;

import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run) {
            out.println("Enter in the folder || file");
            out.println("Enter fulll if you want to fully scan computer");
            String y = scan.nextLine();
            if (Test(y)) {
                File st[] = File.listRoots();
                run = false;
                /*
                 try {
                 File t = new File(y);
                 } catch (FileNotFoundException e) {
                 //                    throws Exception("that does not work");
                 throw new UnsupportedOperationException("That does not work at all");

                 }
                 */
            } else {
                File st = new File(y);
                ArrayList<File> NF = new ArrayList();
                ArrayList<File> Fin = new ArrayList();
                ArrayList<File> Fol = new ArrayList();
                NF.add(st);
//                int con = 0;
                while (!NF.isEmpty()) {
                    File tem[] = NF.get(0).listFiles();
                    if (NF.contains(null)) {
                        NF.removeAll(null);
                    }
                    out.println(Arrays.toString(tem));
                    for (int i = 0; i < tem.length; i++) {
                        NF.add(tem[i]);
                    }
                    if (NF.get(0) == null) {
                        Fol.add(NF.get(0));
                        NF.remove(0);
                    } else {
                        Fin.add(NF.get(0));
                        NF.remove(0);
                    }
                }
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
        }
    }

    private static boolean Test(String y) {
        return y.equalsIgnoreCase("full");
    }
}
