
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class ReadImage2 {

    public static void main(String[] args) throws Exception {
//        String y = "C:\\Users\\Jacob\\Dropbox\\Comparing\\Image Extract"; // The file path
//        String y = "C:\\Users\\Jacob Ward\\Dropbox\\Comparing\\Image Extract"; // The file path
//        String y = "C:\\Users\\Jacob Ward\\Desktop\\PT 11";
//        String y = "C:\\Users\\Jacob Ward\\Desktop\\PT 11\\100APPLE";
        String y = "C:\\Users\\Jacob Ward\\Desktop\\PT 11";
        File start = new File(y);
        File st[] = start.listFiles(); // Starting list of files
        ArrayList<File> ar = new ArrayList<>();
        ArrayList<File> tempAR = new ArrayList<>();
        ArrayList<File> Final = new ArrayList<>();
        ar.addAll(Arrays.asList(st));
        while (!ar.isEmpty()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).isFile()) {
                    Final.add(ar.get(i));
                } else {
                    tempAR.add(ar.get(i));
                }
                ar.remove(i);
            }
            while (!tempAR.isEmpty()) {
                File g[] = tempAR.get(0).listFiles();
                ar.addAll(Arrays.asList(g));
                tempAR.remove(0);
            }
        }
        ArrayList<ImageProp> im = new ArrayList();
        for (File f : Final) {
//            out.println(f.getName());
//            if (!(f.getName().contains("AAE"))) {
            if (f.getName().contains("JPG") || f.getName().contains("PNG") || f.getName().contains("JPEG")) {
                im.add(new ImageProp(f));
            }
        }
        perm(im);
    }

    private static void perm(ArrayList<ImageProp> im) throws IOException {
        FileWriter fw = new FileWriter(new File("SameName.txt"));
        for (int i = 0; i < im.size() - 1; i++) {
            for (int ii = i + 1; ii < im.size(); ii++) {
                ImageProp x = im.get(i);
                ImageProp y = im.get(ii);
                if (x.getHeight() == y.getHeight() && x.getWidth() == y.getWidth()) {
                    BufferedImage xbi = x.bi;
                    BufferedImage ybi = y.bi;
                    double tot = x.getHeight() * x.getWidth();
                    double per = .80;
//                    int sameCount = 0;
                    int diffCount = 0;
                    double percent = tot * per;
//                    out.println(percent);
                    boolean printName = true;
//                    out.println(x.getHeight() + " " + y.getHeight() + " " + x.getWidth() + " " + y.getWidth());
//                    out.println(x.getWidth() + " " + x.getHeight());
//                    System.gc();
                    for (int xx = 0; xx < x.getWidth() - 1; xx++) {
                        for (int yy = 0; yy < x.getHeight() - 1; yy++) {
//                            out.println(tot - diffCount + " " + diffCount + " " + percent);
                            if (tot - diffCount <= percent) {
                                printName = false;
                                break;
                            } else {
                                diffCount += xbi.getRGB(xx, yy) == ybi.getRGB(xx, yy) ? 1 : 0;
                            }
                        }
                        if (!printName) {
                            fw.append("File 1: " + x.getName() + "\nFile 2: " + y.getName() + "\n");

                            break;
                        }
                    }
//                    out.println(tot - sameCount);
//                    out.println(printName);
//                    out.println("Pixels the same: " + sameCount + "\nNumber Total: " + tot + "\nPercent of same: " + (tot / sameCount));
                }
            }
        }
        fw.flush();
        fw.close();
        out.println(im.size());
    }
}
