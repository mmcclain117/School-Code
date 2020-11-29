
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Master Ward
 */
public class ImageProp {

    public BufferedImage bi;
    public File file;

    ImageProp(File f) throws Exception {
        file = f;
        bi = getImage();
    }

    public BufferedImage getImage() throws Exception {
        return ImageIO.read(file);
    }

    public int getHeight() {
        return bi.getHeight();
    }

    public int getWidth() {
        return bi.getWidth();
    }

    public String getName() {
        return file.getName();
    }

    private int getType() {
        return bi.getType();
    }

    private BufferedImage subImage(int x, int y, int w, int h) {
        return bi.getSubimage(x, y, w, h);
    }
}
