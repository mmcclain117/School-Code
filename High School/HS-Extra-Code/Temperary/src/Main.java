
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Master
 */
public class Main {

//    Instructions
//    Step 1: Get the List of files comparing
//    Step 2: Limit how many at a time to make it run and not crash
//    Step 3: compare the size of the files
//    Step 4: Add into a map the RGB
//    Step 5: Compare
//    Step 6: Add if Same
//    Step 7: Display
    public static void main(String[] args) {
        String StartFilePath = "C:\\Users\\Master\\Dropbox\\X";
        File start = new File(StartFilePath); // Folder with all the photos
//        Assuming there are no folders inside the start folder
        File ff[] = start.listFiles(); // List of all the photos
        ff = sort(ff);
        ff = sift(ff);
        System.out.println(Arrays.toString(ff));
        ArrayList<TreeMap<Integer, Integer>> ats = new ArrayList();
//            ImageIO.read(ff[0]);
        if (ff.length < 100) { // Limit on number for time purpose
            for (int i = 0; i < ff.length; i++) {
                TreeMap<Integer, Integer> tm = getRGBTM(ff[i]);
                ats.add(tm);
            }
            String treeAdapt[] = converting(ats);
            ArrayList<TreeMap<Integer, Integer>> finDup = CTTM(ats); // Need to be writed
        } else { // Needs tp be split up

        }
    }

    private static long[] longify(File[] ff) {
        long tef[] = new long[ff.length]; // Array for all the file sizes
        for (int i = 0; i < ff.length; i++) {
            try {
                tef[i] = Files.size(ff[i].toPath());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tef;
    }
//      Need to make faster becase right now it is a bad selection sort

    private static File[] sort(File[] f) { // Greatest -> least
        long sizes[] = longify(f);
        long max = -1;
        int place = 0;
        for (int ii = 0; ii < sizes.length - 1; ii++) { // Through the whole array
            for (int i = 1; i < sizes.length; i++) { // Selecting
                if (sizes[i] > max) { // The biggest one
                    max = sizes[i];
                    place = i;
                }
            }
            File temper = f[ii];
            f[ii] = f[place];
            f[place] = temper;
        }
        return f;
    }
//    Makes sure all the files are Image Files

    private static File[] sift(File[] ff) {
        ArrayList<File> ar = new ArrayList(ff.length);
        for (int i = 0; i < ff.length; i++) {
            if (isImage(ff[i].getName())) {
                ar.add(ff[i]);
            }
        }
        ar.trimToSize();
        File fin[] = new File[ar.size()];
        for (int i = 0; i < fin.length; i++) {
            fin[i] = ar.get(i);
        }
        return fin;
    }

    private static boolean isImage(String name) {
        return name.contains("png") || name.contains("jpeg") || name.contains("jpg")
                || name.contains("tiff") || name.contains("bmp");
    }

    private static TreeMap<Integer, Integer> getRGBTM(File f) { // Get the TreeMap<RGB> of the Image 
        TreeMap<Integer, Integer> tm = new TreeMap();
        try {
            BufferedImage bi = ImageIO.read(f);
            int w = bi.getTileWidth();
            int h = bi.getTileHeight();
//                Reads in and puts the RGB into TreeMap
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int rgb = bi.getRGB(x, y); // The RGB of the Grid
                    if (tm.containsKey(rgb)) {
                        tm.put(rgb, tm.get(rgb) + 1);
                    } else {
                        tm.put(rgb, 1);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tm;
    }

    private static ArrayList<TreeMap<Integer, Integer>> CTTM(ArrayList<TreeMap<Integer, Integer>> ats) {
        ArrayList<TreeMap<Integer, Integer>> at = new ArrayList();
        String y = "";

        return at;
    }

    private static String[] converting(ArrayList<TreeMap<Integer, Integer>> ats) {
        String fina[] = new String[ats.size()];
        int count = 0;
        for (int i = 0; i < ats.size(); i++) {
            Map.Entry<Integer, Integer> pFE = ats.get(0).pollFirstEntry();
//            Return to find if they are close
        }
        return fina;
    }
}
