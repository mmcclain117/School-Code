
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HackConMain {

    public static void main(String[] args) throws IOException {
        File f = new File("image.png");
        BufferedImage img = ImageIO.read(f);
        img.getRGB(0, 0);
        BufferedImage off_Image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);

    }

}
