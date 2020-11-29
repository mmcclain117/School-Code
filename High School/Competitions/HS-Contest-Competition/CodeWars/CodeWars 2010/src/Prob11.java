
import java.io.File;
import static java.lang.Math.abs;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class Prob11 {
//        Problem: Museum Area
//        Subject: Covex Polygon Area\
//        Points: 11

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        int n = scan.nextInt(); // Number of verticies
        /* Store vertices in 2D array */
        vertex point[] = new vertex[n + 1];
        for (int i = 0; i < n; i++) {
            point[i] = new vertex();
            point[i].x = scan.nextDouble();
            point[i].y = scan.nextDouble();
        }
        /* Adding final Vertex */
        point[n] = new vertex();
        point[n].x = point[0].x;
        point[n].y = point[0].y;
        n++;
        /* Last vertex == first vertex */
        System.out.println(calArea(point, n));
    }

    /*
     * Calculate the area of a polygon
     * Formula: A = 1/2 * SUM[(x(i)y(i+1) - (x(i+1)y(i)] for all i.          
     * Nodes that are clockwise have a negative area.
     * (Still correct)
     */
    private static double calArea(vertex point[], int numb) {
        double d = 0.0;
        for (int i = 0; i < numb - 1; i++) {
            d += ((point[i].x * point[i + 1].y) - (point[i + 1].x * point[i].y));
        }
        return abs(0.5 * d);
    }
}

/* Keep track of points */
class vertex {

    double x, y;
}
