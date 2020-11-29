
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class MassMove {

    /**
     * Works but has a problem with the copying exactly
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        String foldername = "C:\\Users\\Master\\Dropbox"; // To be copied directory
        String foldername = "C:\\Users\\Jacob\\Dropbox"; // To be copied directory
//        String newFoldPath = foldername + "\\Extracted"; // New path not creating directory
        String newFoldPath = "E:\\"; // New path not creating directory
        // try {
        new File(newFoldPath).mkdir();
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
        while (!af.isEmpty()) { // While more directories
//                try {
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
            af.remove(0);
        }
        int con = 0;
        while (con < ar.size()) {
            String yy = ar.get(con).getAbsolutePath();
            if (yy.contains(".java") && !yy.contains("(deleted ")) { // Elimenates all nonJava
                con++;
                System.out.println(yy);
            } else {
                ar.remove(con);
            }
        }
        while (!ar.isEmpty()) {
            File s = (ar.remove(0));
            File d = getD(s, newFoldPath);
            System.out.println(Files.size(s.toPath()));
            if (Files.size(s.toPath()) > 1024) {
                copyFile(s, d);
            }
        }
        //     } catch (IOException e) {
        //          System.out.println("Path");
        //     }
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
//        System.out.println(Arrays.toString(x));
        for (int i = 0; i < x.length; i++) {
            cur.add(x[i]);
        }
        int ii = 0;
        int con = 0;
        while (ii < cur.size()) { // Check for duplicate File names
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
        BufferedWriter bw = new BufferedWriter(fw);
        String se = "";
        while (scan.hasNext()) {
            se += scan.nextLine();
            fw.write(se);
            bw.write(se);
            bw.newLine();
            fw.flush();
        }
        fw.close();
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    private static File getD(File remove, String newFoldPath) {
        String fte = remove.getName(); // File name
//        Scanner scan = new Scanner(remove); // Scanning in old file
        String x[] = new File(newFoldPath).list(); // List of current Files
        ArrayList<String> cur = new ArrayList();
//        System.out.println(Arrays.toString(x));
        for (int i = 0; i < x.length; i++) {
            cur.add(x[i]);
        }
        int ii = 0;
        int con = 0;
        while (ii < cur.size()) { // Check for duplicate File names
            if (cur.get(ii).equals(fte)) {
                System.out.println(fte + " " + fte.length());
                fte = fte.substring(0, fte.length() - 5) + "(" + (con) + ")" + fte.substring(fte.length() - 5);
                con++;
            } else {
                con = 0;
                ii++;
            }
        }
//        FileWriter fw = new FileWriter(new File(newFoldPath + "\\" + fte));
        return new File(newFoldPath + "\\" + fte);
    }
}
