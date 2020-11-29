
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Main {

    public static void main(String[] args) throws IOException {
        boolean userInput = false;
        String sour = "";
        String dest = "";
        if (userInput) {
            Scanner scan = new Scanner(System.in);
            String a[] = getSourAndDest(scan);
            sour = a[0];
            dest = a[1];
        } else {
            sour = "C:\\Users\\Jacob\\Downloads\\D1\\DXDiag";
            dest = "C:\\Users\\Jacob\\Dropbox\\Testing";
        }
        ArrayList<File> ar = getAllFiles(sour); // source Files
        ArrayList<String> editFile = new ArrayList(); // Destination paths of ar
        ArrayList<String> editFold = new ArrayList(); // Destination path of fold
        ArrayList<File> fold = getAllFolders(sour); // Source Folders
        ArrayList<File> existFile = getAllFiles(dest);
        ArrayList<File> existFold = getAllFolders(dest);
        /*
         for (int i = 0; i < fold.size(); i++) {
         out.println(fold.get(i));
         }
         Collections.sort(fold);
         out.println("\n");
         for (int i = 0; i < fold.size(); i++) {
         out.println(fold.get(i));
         }
         */
        /**
         * For the file names to destination
         */
        for (int i = 0; i < ar.size(); i++) {
            editFile.add(ar.get(i).getPath().replace(sour, dest));
        }
        /**
         * For the folder names to be destination
         */
        for (int i = 0; i < fold.size(); i++) {
            editFold.add(fold.get(i).getPath().replace(sour, dest));
        }
        out.println(Arrays.toString(editFold.toArray()));
        for (int i = 0; i < existFile.size(); i++) {
            String te = existFile.get(i).getPath();
            int is = editFile.indexOf(te);
            if (is >= 0) {
                editFile.remove(is);
                ar.remove(is);
            }
        }
        for (int i = 0; i < existFold.size(); i++) {
            String te = existFold.get(i).getPath();
            int is = editFold.indexOf(te);
            if (is >= 0) {
                editFold.remove(is);
                fold.remove(is);
            }
        }
//       Make this more efficent by doing mkdirs and just off the file
        Collections.sort(editFold);
        for (int i = 0; i < editFold.size(); i++) {
            File f = new File(editFold.get(i));
            f.mkdir();
        }
        out.println(Arrays.toString(editFile.toArray()));
        out.println(Arrays.toString(ar.toArray()));
        for (int i = 0; i < editFile.size(); i++) {
            copyFileUsingJava7Files(ar.get(i), new File(editFile.get(i)));
        }
//            copyFileUsingJava7Files(ar.get(1) , new File(editFile.get(1)));
        System.gc();
    }

    private static String[] getSourAndDest(Scanner scan) {
        String a[] = new String[2];
        out.println("Enter in the input source folder path");
        String s = scan.nextLine();
        while (!(new File(s).isDirectory())) {
            out.println("That is not a folder");
            s = scan.nextLine();
        }
        out.println("Enter in the destination source folder path");
        String d = scan.nextLine();
        while (!(new File(d).isDirectory())) {
            out.println("That Destination doesn't exist");
            d = scan.nextLine();
        }
        a[0] = s;
        a[1] = d;
        return a;
    }

    private static ArrayList<File> getAllFiles(String sour) {
        ArrayList<File> temp = new ArrayList();
        ArrayList<File> fin = new ArrayList();
        File f = new File(sour);
        File fl[] = f.listFiles();
        for (int i = 0; i < fl.length; i++) {
            temp.add(fl[i]);
        }
        while (!(temp.isEmpty())) {
            File te = temp.remove(0);
            if (te.isFile()) {
                fin.add(te);
            } else if (te.isDirectory()) {
                File s[] = te.listFiles();
                for (int i = 0; i < s.length; i++) {
                    temp.add(s[i]);
                }
            }
        }
        return fin;
    }

    private static ArrayList<File> getAllFolders(String sour) {
        ArrayList<File> temp = new ArrayList();
        ArrayList<File> fold = new ArrayList();
        File f = new File(sour);
        File fl[] = f.listFiles();
        for (int i = 0; i < fl.length; i++) {
            temp.add(fl[i]);
        }
        while (!(temp.isEmpty())) {
            File te = temp.remove(0);
            if (te.isDirectory()) {
                fold.add(te);
                File s[] = te.listFiles();
                for (int i = 0; i < s.length; i++) {
                    temp.add(s[i]);
                }
            }
        }
        return fold;
    }

    private static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}
