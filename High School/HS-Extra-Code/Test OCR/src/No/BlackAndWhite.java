package No;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

/**
 *
 * @author Jacob
 */
public class BlackAndWhite {

    public static void main(String[] args) throws Exception {
        Attempt1();

    }

    private static void Attempt2() {

    }

    private static void Attempt1() {
        try {
            File file1 = new File("0Start.jpg");
            BufferedImage image1 = ImageIO.read(file1);

            //write file
            File file2 = new File("0Starts.jpg");
//            file2.setWritable(true);
//            boolean image2 = ImageIO.write(image1, "sta", file2);
            BufferedImage bi = new BufferedImage(image1.getHeight(), image1.getWidth(), BufferedImage.TYPE_INT_RGB);
            Graphics g2 = image1.createGraphics();
            BufferedImage images = ImageIO.read(file2);
            Graphics g = images.getGraphics();
            Graphics h = g;
            ImageInputStream imp = ImageIO.createImageInputStream(g);
            ImageOutputStream omp = ImageIO.createImageOutputStream(h);
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {

                    int c = image1.getRGB(x, y);
                    Color color = new Color(c);

                    //int  red = (c & 0x0000FFFF) >> 16;
                    //int  green = (c & 0x0000FFFF) >> 8;
                    //int  blue = c & 0x0000FFFF;
                    //if (cyan.equals(image1.getRGB(x, y)){
                    if (color.getRed() >= 245 || color.getGreen() >= 245 || color.getBlue() >= 245) {
                        g.setColor(Color.black);
                        out.println("This");
                        g2.fillRect(x, y, 1, 1);
                    } else {
                        g.setColor(Color.white);
                        g2.fillRect(x, y, 1, 1);
                    }
                }
            }
            images.flush();
//            ImageIO.write(file2, "jpg", g);
        } catch (IOException e) {
            e.printStackTrace();
        }
////        File file1 = new File("2015-11-23 12.07.04.jpg");
//        BufferedImage image1 = ImageIO.read(file1);
//        BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
//        File R = new File("Red.jpg");
//        Graphics g = bi.getGraphics();
//        int wide = bi.getWidth();
//        int hig = bi.getHeight();
//        Random rnd = new Random();
//        BufferedImage image2 = ImageIO.read(R);
//        BufferedImage bi2 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
//        Graphics g1 = bi2.getGraphics();
//        Color bl = new Color(256, 256, 256);
//        for (int i = 0 ; i < wide ; i++) {
//            for (int o = 0 ; o < hig ; o++) {
//                int r = image1.getRGB(wide, hig);
//                int r2 = image2.getRGB(wide, hig);
//
//            }
//        }
////        image1.setRGB(1, 1, s);
//        ImageIO.write(bi, "jpg", (ImageOutputStream) g);
    }
}
