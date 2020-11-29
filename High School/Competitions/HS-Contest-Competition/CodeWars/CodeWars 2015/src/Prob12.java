
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Master Ward & used some of Sebastian Schagerer Code
 */
public class Prob12 {

    private static double grid[][];
    private static int size;
    private static Point steep1;
    private static Point steep2;
    private static double steepest = 0;
    private static ArrayList<Point> straights;
    private static ArrayList<Point> diagonals;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob12.txt"));
        size = scan.nextInt();
        scan.nextLine();
        grid = new double[size][size];
        /* Scan in the grid */
        for (int i = 0; i < size; i++) {
            String tmp = scan.nextLine();
            grid[i] = doublify(tmp);
        }
        checkAdjacent();

        System.out.printf("Max angle is %.2f degrees\n", steepest);
    }

    /* Print out the array */
    private static void print() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }

    /* Turns String  into Double Array */
    private static double[] doublify(String s) {
        String a[] = s.split("[ ]+");
        double x[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = Double.parseDouble(a[i]);
        }
        return x;
    }

    private static void checkAdjacent() {
        ArrayList<Point> grids = Prob12.straightOffsets();
        ArrayList<Point> diagonals = Prob12.diagonalOffsets();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Point location = new Point(c, r);
                for (Point straight : grids) {
                    updateAngle(location, straight, false);
                }
                for (Point diagonal : diagonals) {
                    updateAngle(location, diagonal, true);
                }
            }
        }
    }

    private static ArrayList<Point> straightOffsets() {
        if (straights == null) {
            straights = new ArrayList<>();
            straights.add(new Point(0, -1));
            straights.add(new Point(-1, 0));
            straights.add(new Point(1, 0));
            straights.add(new Point(0, 1));
        }
        return straights;
    }

    private static ArrayList<Point> diagonalOffsets() {
        if (diagonals == null) {
            diagonals = new ArrayList<>();
            diagonals.add(new Point(-1, -1));
            diagonals.add(new Point(1, -1));
            diagonals.add(new Point(-1, 1));
            diagonals.add(new Point(1, 1));
        }
        return diagonals;
    }

    private static void updateAngle(Point location, Point offset, boolean isDiagonal) {
        Point adjacent = new Point(location);
        adjacent.x += offset.x;
        adjacent.y += offset.y;
        if (true == isInBounds(adjacent)) {
            double angle = calcAngle(grid[location.y][location.x], grid[adjacent.y][adjacent.x], isDiagonal);
            if (angle > steepest) {
                steepest = angle;
                steep1 = new Point(location);
                steep2 = new Point(adjacent);
            }
        }
    }

    /* Returns if it is in the grid */
    private static boolean isInBounds(Point aPoint) {
        return aPoint.x > 0 && aPoint.x < size && aPoint.y > 0 && aPoint.y < size;
    }

    private static double calcAngle(double h1, double h2, boolean isDiagonal) {
        double angle = 0;
        double a = (h1 - h2);
        double b = 1;
        if (isDiagonal) {
            b = Math.sqrt(2);
        }
        double c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
        double sinTheta = (a / c);
        double thetaRadians = Math.asin(sinTheta);
        angle = Math.toDegrees(thetaRadians);
        return angle;
    }

}
