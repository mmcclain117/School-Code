
import java.io.File;
import static java.lang.Math.abs;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob11 {

    private static final int minX = -100;
    private static final int maxX = 100;
    private static final int minY = -100;
    private static final int maxY = 100;
    private static final int x0 = 0;
    private static final int y0 = 100;
    private static final int x1 = -100;
    private static final int y1 = -100;
    private static final int x2 = 100;
    private static final int y2 = -100;

    public static void main(String[] args) throws Exception {
//        Problem: Location Awareness
//        Points: 7
        Scanner scan = new Scanner(new File("prob11.txt"));
        double a = scan.nextDouble(); // 1st Tower Strength
        double b = scan.nextDouble(); // 2nd Tower Strength
        double c = scan.nextDouble(); // 3rd Tower Strength
        scan.nextLine();
        while (a != 0 && b != 0 && c != 0) {
            double newX = 0;
            double newY = 0;
            double minPowerDiff = a * 40000;
            for (int i = minX; i < maxX; i++) {
                for (int j = minY; j < maxY; j++) {
                    double d0sq = (x0 - i) * (x0 - i) + (y0 - j) * (y0 - j);
                    double d1sq = (x1 - i) * (x1 - i) + (y1 - j) * (y1 - j);
                    double d2sq = (x2 - i) * (x2 - i) + (y2 - j) * (y2 - j);
//             s = P / ( d * d ), so P = s*(d-squared)            
                    double P0 = a * d0sq;
                    double P1 = b * d1sq;
                    double P2 = c * d2sq;
                    double newPowerDiff = max(abs(P1 - P0), max(abs(P2 - P0), abs(P2 - P1)));
                    if (newPowerDiff < minPowerDiff) {
                        newX = i;
                        newY = j;
                        minPowerDiff = newPowerDiff;
                    }
                }
            }
            System.out.printf("%.0f %.0f\n", newX, newY);

            a = scan.nextDouble();
            b = scan.nextDouble();
            c = scan.nextDouble();
        }
    }

    private static double max(double a, double b) {
        if (a > b) {
            return a;
        }
        return b;
    }

}
