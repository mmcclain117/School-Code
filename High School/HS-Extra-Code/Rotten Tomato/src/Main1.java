
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class Main1 {

    public static void main(String[] args) {
        String foldername = "C:\\Users\\Master"; // To be copied directory
        String newFoldPath = foldername + "\\Extracted"; // New path not creating directory
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
                af.remove(0);
            } catch (NullPointerException e) { // Catch if empty
                System.out.println("NULL");
                af.remove(0);
            }
        }

        /**
         * Get the list of file Then go through and get the website HTML code
         * Parse the code Mkae folders Write to txt file write to properties
         * file See if can link Close all
         *
         */
    }
}
