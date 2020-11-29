
import java.io.File;
import java.util.ArrayList;

/**
 * Printing all subfolders
 * @author Coder
 */
public class Main {

    public static void main(String[] args) throws Exception {
        File f = new File("path");
        File ff[] = f.listFiles(); // adding f's subfolders
        ArrayList<File> ar = new ArrayList(); // Used to store all files
        for (File q : ff) {
            ar.add(q);
        }
        int i = 0; // Interating
        while (i < ar.size()) {  
            File temp = ar.get(i); 
            if (temp.isDirectory()) { // Adds all the subfiles
                File qw[] = temp.listFiles();
                for (File q : qw) {
                    ar.add(q);
                }
//                ar.remove(ar.get(0));
                i++;
            } else { // If it is a file remove it
                ar.remove(ar.get(i));
//                i++;
            }
//            System.out.println("xx");
        }
        for (File q : ar) {
            System.out.println("  - " +q.getName());
        }
    }
}
