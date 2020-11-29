
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Main {

    /**
     * Works but has a problem with the copying exactly
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String foldername = "C:\\Users\\Master\\Dropbox"; // To be copied directory
        String newFoldPath = foldername + "\\Extracted"; // New path not creating directory
        File f = new File(foldername); // First Directory
        File ff[] = f.listFiles(); // All files underneath it
        ArrayList<File> af = new ArrayList(); // The Full file list
        ArrayList<File> ar = new ArrayList(); // The List of files (Not directories)
        for (int i = 0; i < ff.length; i++) {
            if (ff[i].isDirectory()) { // Directory
                af.add(ff[i]); // Add back to list
            } else {
                ar.add(ff[i]); // Add to file list
            }
        }
//        System.out.println(Files.probeContentType(af.get(0).toPath()));
        while (!af.isEmpty()) { // While more directories
            try {
                if (af.get(0).isDirectory()) { // Acting like a Queue
                    File fx[] = af.get(0).listFiles(); // getting underneath files
                    for (int i = 0; i < fx.length; i++) { // Same thing as above
                        if (fx[i].isDirectory()) {
                            af.add(fx[i]);
                        } else {
                            ar.add(fx[i]);
                        }
                    }
                } else {
                    ar.add(af.get(0));
                }
//                System.out.println(af.size());
                af.remove(0);
            } catch (NullPointerException e) {
                System.out.println("NULL");
                af.remove(0);
            }
        }
        int con = 0;
        while (con < ar.size()) {
//            String ext = Files.probeContentType(ar.get(con).toPath());
//            System.out.println(ar.get(con).getCanonicalPath());
//            System.out.println("EXE " + ext);
            String yy = ar.get(con).getAbsolutePath();
            if (yy.contains(".java")) { // Elimenates all nonJava
//                System.out.println(yy);
                con++;
            } else {
                ar.remove(con);
            }
//            con++;
        }
        System.out.println(ar.size());
        while (!ar.isEmpty()) {
            copy(ar.remove(0), newFoldPath);
        }
    }

    /**
     * Copying the files
     *
     * @param remove
     * @param newFoldPath
     * @throws IOException
     */
    private static void copy(File remove, String newFoldPath) throws IOException { // Copies Removed files to new path
        String fte = remove.getName(); // File name
        Scanner scan = new Scanner(remove); // Scanning in old file
        String x[] = new File(newFoldPath).list(); // List of current Files
        ArrayList<String> cur = new ArrayList();
        for (int i = 0; i < x.length; i++) {
            cur.add(x[i]);
        }
        int ii = 0;
        int con = 0;
        while (ii < cur.size()) { // Check for duplicate
            if (cur.get(ii).equals(fte)) {
                System.out.println(fte + " " + fte.length());
                fte = fte.substring(0, fte.length() - 5) + "(" + (con) + ")" + fte.substring(fte.length() - 5);
                con++;
            } else {
                con = 0;
                ii++;
            }
        }
        FileWriter fw = new FileWriter(new File(newFoldPath + "\\" + fte));
        String se = "";
        while (scan.hasNext()) {
//            se += scan.nextLine() + "\n";
            se += scan.nextLine();
            fw.write(se);
            fw.flush();
        }
        fw.close();

//        write(fte, newFoldPath, se);
//        for (int i = 0; i < x.length; i++) { // GO through to check for duplicates
//            if (x[i].equals(fte)) { // if Duplicate change name 
//                fte = fte.substring(0, fte.length() - 6) + "(1)" + fte.substring(fte.length() + 6);
//                i--;
//            }
//        }
    }

    /**
     * Attempt to write to another file
     *
     * @param name
     * @param nfp
     * @param da
     * @throws IOException
     */
    private static void write(String name, String nfp, String da) throws IOException {
        FileWriter fw = new FileWriter(new File(nfp + "\\" + name));
        fw.write(da);
        fw.flush();
        fw.close();
    }

}