
import java.util.Random;

/**
 *
 * @author Master
 */
public class Monte {

    public double h, k, r;
    private Random rnd = new Random();

    public Monte(double h, double k, double r) {
        this.h = h;
        this.k = k;
        this.r = r;
    }

    public double NRD_X() {
        double x = rnd.nextDouble() * (2 * r) + (h - r);
        return x;

    }

    public double NDR_Y() {
        double y = rnd.nextDouble() * (r * 2) + (k - r);
        return y;
    }

    public boolean INC(double x, double y) {

        return ((x - h) * (x - h) + (y - k) * (y - k)) <= r * r;

    }
}
