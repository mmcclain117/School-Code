
import java.awt.Color;
import static java.lang.Math.random;

/**
 *
 * @author Master
 */
public class ColorRandom {

    public Color randomColor(int r, int G, int b) {
        r = (int) (random() * 256);
        G = (int) (random() * 256);
        b = (int) (random() * 256);
        return new Color(r, G, b);
    }
}
