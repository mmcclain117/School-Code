package Worked;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Jacob
 */
public class SepertateRGB {

    public static int wide;
    public static int hig;

    public static void main(String[] args) throws Exception {
        File file1 = new File("2015-11-23 12.07.04.jpg");
        BufferedImage image1 = ImageIO.read(file1);
        BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        File R = new File("Red.jpg");
        File G = new File("Green.jpg");
        File B = new File("Blue.jpg");
        Graphics g = bi.getGraphics();
        int wide = bi.getWidth();
        int hig = bi.getHeight();
        Random rnd = new Random();
//        int c = image1.getRGB(0, 0);
//        int d = image1.getRGB(1, 1);
//        int s = image1.getRGB(100, 100);
//        image1.setRGB(1, 1, s);
//        out.println(R.canRead() + " " + R.canWrite());
//        Green(image1, g);
//        ImageIO.write(bi, "jpg", G);
//        bi.flush();
//        g.clearRect(0, 0, 2000, 3000);
//        Red(image1, g);
//        bi.flush();
//        ImageIO.write(bi, "jpg", R);
//        out.println(R.compareTo(G));
//        Blue(image1, g);
//        ImageIO.write(bi, "jpg", B);
//        bi.flush();
    }

    public static Graphics Green(BufferedImage image1, Graphics g) {
        Color cr;
        Color temp;
        for (int i = 0; i < wide; i++) {
            for (int o = 0; o < hig; o++) {
                int se = image1.getRGB(i, o);
                cr = new Color(se);
                int g1 = cr.getGreen();
                temp = new Color(0, g1, 0);
                g.setColor(temp);
                g.fillRect(i, o, 1, 1);
            }
        }
        return g;
    }

    public static Graphics Blue(BufferedImage image1, Graphics g) {
        Color cr;
        Color temp;
        for (int i = 0; i < wide; i++) {
            for (int o = 0; o < hig; o++) {
                int se = image1.getRGB(i, o);
                cr = new Color(se);
                int b1 = cr.getBlue();
                temp = new Color(0, 0, b1);
                g.setColor(temp);
                g.fillRect(i, o, 1, 1);
            }
        }
        return g;
    }

    public static Graphics Red(BufferedImage image1, Graphics g) {
        Color cr;
        Color temp;
        for (int i = 0; i < wide; i++) {
            for (int o = 0; o < hig; o++) {
                int se = image1.getRGB(i, o);
                cr = new Color(se);
                int r1 = cr.getRed();
                temp = new Color(r1, 0, 0);
                g.setColor(temp);
                g.fillRect(i, o, 1, 1);
            }
        }
        return g;
    }
}
