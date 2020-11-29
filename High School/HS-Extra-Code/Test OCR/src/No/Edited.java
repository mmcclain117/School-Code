package No;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author Jacob
 */
public class Edited {

    public static void main(String[] args) {
        try {
            File file1 = new File("2015-11-23 12.07.04.jpg");
            BufferedImage image1 = ImageIO.read(file1);

            FileWriter fstream = new FileWriter(new File("pixellog.txt"));
            BufferedWriter out = new BufferedWriter(fstream);
            System.out.println(image1.hasTileWriters());
            System.out.println(Arrays.toString(image1.getWritableTileIndices()));
            int u = image1.getRGB(503, 867);
            Color cd = new Color(u);
            Color white = new Color(255, 255, 255);
            int set = white.getRGB();
            image1.setRGB(0, 0, set);
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    int c = image1.getRGB(x, y);
                    Color color = new Color(c);
                    //503, 867
                    //185  89   47
                    if (color.getRed() == 185 && color.getGreen() == 89 && color.getBlue() == 47) {
                        out.write(x + " " + y + " " + color.toString().substring(14));
                        out.newLine();
                    } else {
                        image1.setRGB(x, y, set);
                        image1.flush();
                    }
                }
            }
            image1.flush();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
