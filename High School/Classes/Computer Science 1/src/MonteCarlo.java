
import java.util.*;

/**
 *
 * @author Master
 */
public class MonteCarlo {

    public double h;
    public double k;
    public double r;
    private Random rndm = new Random();

    public MonteCarlo(double h, double k, double r) {
        this.h = h;
        this.k = k;
        this.r = r;
    }

    public double nextRainDrop_x() {
        double x = rndm.nextDouble() * (2 * r) + (h - r);
        return x;
    }

    public double nextRainDrop_y() {
        double y = rndm.nextDouble() * (r * 2) + (k - r);
        return y;
    }

    public boolean insideCircle(double x, double y) {
        if (((x - h) * (x - h)) + ((y - k) * (y - k)) <= r * r) {
            return true;
        } else {
            return false;
        }
    }
}
