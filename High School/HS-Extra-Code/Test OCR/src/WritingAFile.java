
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

/**
 *
 * @author Master Ward
 */
public class WritingAFile {

    public static void main(String[] args) throws IOException {
        File in1 = new File("2015-11-23 12.07.04.jpg");
        File in2 = new File("2015-11-23 12.07.04_1.jpg");
        File out1 = new File("Blue.jpg");
        File out2 = new File("r.jpg");
        BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        ImageObserver io = new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        ImageInputStream i1 = ImageIO.createImageInputStream(in1);
        ImageOutputStream o1 = ImageIO.createImageOutputStream(out1);
        String a = i1.readLine();
        o1.write(a.getBytes());
        out.println(Arrays.toString(a.getBytes()));
        out1.createNewFile();
    }
}
