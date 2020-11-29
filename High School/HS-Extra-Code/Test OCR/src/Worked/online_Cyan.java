package Worked;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Jacob
 */
public class online_Cyan {

    public static void main(String[] args) {
        try {
            File file1 = new File("2015-11-23 12.07.04.jpg");
            BufferedImage image1 = ImageIO.read(file1);

            //write file
            FileWriter fstream = new FileWriter(new File("pixellog1.txt"));
            BufferedWriter out = new BufferedWriter(fstream);

            //color object
            //Color cyan = new Color(0, 255, 255);
            //find cyan pixels
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {

                    int c = image1.getRGB(x, y);
                    Color color = new Color(c);

                    //int  red = (c & 0x0000FFFF) >> 16;
                    //int  green = (c & 0x0000FFFF) >> 8;
                    //int  blue = c & 0x0000FFFF;
                    //if (cyan.equals(image1.getRGB(x, y)){
                    if (color.getRed() < 30 && color.getGreen() > 255 && color.getBlue() > 255) {
                        out.write("CyanPixel found at=" + x + "," + y);
                        out.newLine();

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
