package Worked;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Master Ward
 */
public class BufferedExample {

    public static void main(String[] args) throws IOException {
        BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        File output = new File("Save.jpg");
        Graphics g = bi.getGraphics();
        int wide = bi.getWidth();
//        Color black = new Color(255, 255, 205);
//        Color white = new Color(0, 0, 0);
//        Color red = new Color(255, 0, 0);
        int hig = bi.getHeight();
        Random rnd = new Random();
        for (int i = 0; i < wide; i++) {
            for (int o = 0; o < hig; o++) {
                int num = (int) (rnd.nextDouble() * 256);
//                out.println(num);
//                Color c = num < 50 ? black : num < 50 ?white : red;
                Color ran = new Color((int) (rnd.nextDouble() * 256), (int) (rnd.nextDouble() * 256), (int) (rnd.nextDouble() * 256));
                g.setColor(ran);
                g.fillRect(i, o, 1, 1);
            }
        }
        ImageIO.write(bi, "jpg", output);
        bi.flush();
    }
}
