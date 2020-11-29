package Round_630;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class O_Arrow {

    /**
     * Tags: Geometry
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double px = scan.nextInt();
        double py = scan.nextInt();
        double vx = scan.nextInt();
        double vy = scan.nextInt();
        double vn = sqrt(pow(vx, 2) + pow(vy, 2));
        double vnx = vx / vn;
        double vny = vy / vn;
        double a = scan.nextInt();
        double b = scan.nextInt();
        double c = scan.nextInt();
        double d = scan.nextInt();
        // Point 1
        double ax = px + (vnx * b);
        double ay = py + (vny * b);

//        double vlx = -1 * vny;
        double vlx = vny;
        double vly = -1 * vnx;
//        double vly = vnx;

        // Point 2
        double bx = px - (vlx * (a / 2));
        double by = py - (vly * (a / 2));
        // Point 3
        double cx = px - (vlx * (c / 2));
        double cy = py - (vly * (c / 2));
        // Point 4
        vlx = -1 * vny;
        vly = vnx;
        double dx = cx - (vnx * d);
        double dy = cy - (vny * d);
        // Point 5
        double ex = px - (vlx * (c / 2)) - (vnx * d);
        double ey = py - (vly * (c / 2)) - (vny * d);
        // Point 6
        double fx = px - (vlx * (c / 2));
        double fy = py - (vly * (c / 2));
        // Point 7
        double gx = px - (vlx * (a / 2));
        double gy = py - (vly * (a / 2));
        System.out.println(ax + " " + ay);
        System.out.println(bx + " " + by);
        System.out.println(cx + " " + cy);
        System.out.println(dx + " " + dy);
        System.out.println(ex + " " + ey);
        System.out.println(fx + " " + fy);
        System.out.println(gx + " " + gy);

    }
}
