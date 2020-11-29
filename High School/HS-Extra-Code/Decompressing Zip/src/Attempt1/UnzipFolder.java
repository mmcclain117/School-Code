package Attempt1;

import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class UnzipFolder {

    public static void main(String args[]) {
        String startingFolder = "C:\\Users\\Jacob\\Dropbox\\WardsWeb emails\\INBOX\\Testing";
//        String zipFilePath = "C:\\Users\\Jacob\\Desktop\\Coolmaster Photo.zip";
        File zips = new File("C:\\Users\\Jacob\\Dropbox\\WardsWeb emails\\INBOX");
        File zipin[] = zips.listFiles();
        out.println(Arrays.toString(zipin));
        String destDirectory = "C:\\Users\\Jacob\\Dropbox\\WardsWeb emails\\INBOX\\Testing";
        UnzipUtility unzipper = new UnzipUtility();
        ArrayList trouble = new ArrayList();
        ArrayList<Character> def = new ArrayList<>();
        /**
         * Adds to it the default ones that works
         */
        // Adding the capital letters
        for (int i = 65; i <= 90; i++) {
            def.add((char) i);
        }
        // Adding lowercase letters
        for (int i = 97; i < 122; i++) {
            def.add((char) i);
        }
//         Adding numbers
        for (int i = 48; i <= 57; i++) {
            def.add((char) i);
        }
        out.println(Arrays.toString(def.toArray()));
        try {
            for (File s : zipin) {
                String zipFilePath = s.getPath();
//                String tempZip = s.getName();
//                char ch[] = tempZip.toCharArray();
//                ArrayList<Character> f = new ArrayList<>();
//                for (char c : ch) {
//                    f.add(c);
//                }
//                f.removeAll(def);
//                out.println(Arrays.toString(f.toArray()));
//                if (f.isEmpty()) {
//                    unzipper.unzip(zipFilePath, destDirectory);
//                } else {
//                    trouble.add(zipFilePath);
//                }
                unzipper.unzip(zipFilePath, destDirectory);
                System.gc();
            }
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
}
