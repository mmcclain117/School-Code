
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

/**
 *
 * @author Master
 */
public class ImageFlooding {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Y&Y.png"));
        int a = scan.hashCode();
        BufferedImage bi = ImageIO.read(new File("Y&Y.png"));
        /*
         FileWriter fw = new FileWriter(new File("YY.txt"));
         while(scan.hasNext()) {
         fw.write(a +"");
         }
         fw.flush();
         fw.close();
         */
        int black = 0;
        int white = 0;
        FileWriter fw = new FileWriter(new File("Y.txt"));
        FileWriter cop = new FileWriter(new File("compr.txt"));
        String line = "";
        HashMap<String, Integer> ar = new HashMap();
        int linecon = 0;
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int u = 0; u < bi.getHeight(); u++) {
                if (bi.getRGB(i, u) == -16777216) {
                    black++;
                }
                if (bi.getRGB(i, u) == -1) {
                    white++;
                }
                fw.write(bi.getRGB(i, u) + "");
                line += bi.getRGB(i, u) + "";
            }
//            out.println(line.length());
            int v = white > black ? -1 : -16777216;
            int aa[] = longestSub(line, v);
            out.println(Arrays.toString(aa));
            ar.put(line, white - linecon);
            line = "";
            linecon = white;
            fw.write("\n");
        }
//        out.println(ar.toString());
        fw.flush();
        fw.close();
        /*
         FileWriter hms = new FileWriter(new File("HashMap Strings.txt"));
         FileWriter hmi = new FileWriter(new File("HashMap ints.txt"));
         String temp1 = Arrays.toString(ar.keySet().toArray());
         String temp2 = Arrays.toString(ar.values().toArray());
         hms.write(temp1);
         hmi.write(temp2);
         hmi.flush();
         hmi.close();
         hms.flush();
         hms.close();
         */
//        ImageWriter bw = ImageIO.getImageWriter(null);
//        RenderImage ri = new RenderImage(new File("compress.jpg"))
//        BufferedImage compress = ImageIO

//        Online Code
        int width = 200, height = 200;
        BufferedImage bi2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D ig2 = bi2.createGraphics();
        ig2.setColor(Color.blue);
        ig2.fillRect(0, 0, width - 1, height - 1);
        ig2.setColor(Color.red);
        ig2.fillOval(0, 0, width - 1, height - 1);
        Iterator imageWriters = ImageIO.getImageWritersByFormatName("JPG");
        ImageWriter imageWriter = (ImageWriter) imageWriters.next();
        File file = new File("filename.jpg");
        ImageOutputStream ios = ImageIO.createImageOutputStream(file);
        imageWriter.setOutput(ios);
        imageWriter.write(bi2);
    }

    private static int[] longestSub(String x, int val) {
        int a[] = {1, 1};
        String y[] = x.split("[-]+");
//        out.println(Arrays.toString(y));
        int num[] = new int[y.length];
        for (int i = 1; i < num.length; i++) {
            num[i] = Integer.parseInt(y[i]);
        }
        int con = 0;
        int l1 = 1;
        while (con < y.length) {
            while (l1 < y.length) {
//                out.println(l1 + " "+ con);
                if (num[l1] == val) {
                    l1++;
                } else {
                    l1++;
                    break;
                }
            }
//            out.println(l1+ " "+ con);
            if (con - l1 > a[0]) {
                a[0] = con - l1;
                a[1] = con;
            }
            con = l1;
        }
        return a;
    }

    public static int longestSubstr(String first, String second) {
        if (first == null || second == null || first.length() == 0 || second.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int fl = first.length();
        int sl = second.length();
        int[][] table = new int[fl + 1][sl + 1];

        for (int s = 0; s <= sl; s++) {
            table[0][s] = 0;
        }
        for (int f = 0; f <= fl; f++) {
            table[f][0] = 0;
        }

        for (int i = 1; i <= fl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    if (i == 1 || j == 1) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                    if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                    }
                }
            }
        }
        return maxLen;
    }
}
