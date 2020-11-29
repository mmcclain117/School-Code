
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob18 {

    private int rows; // Row Size
    private int cols; // Column Size
    private Point start;
    private Point end;
    private ArrayList<Point> visited;
    private char[][] output = null;
    private int count;

    public static void main(String[] args) throws Exception {
//        Problem: 
//        Points: 
        new Prob18();
    }

    public Prob18() throws Exception {
        Scanner scan = new Scanner(new File("prob18.txt"));
        rows = scan.nextInt(); // Rows
        cols = scan.nextInt(); // Columns
        scan.nextLine();
        int input[][] = new int[rows][cols];
        /* Scan in the array */
        for (int r = 0; r < rows; r++) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
            for (int c = 0; c < cols; c++) {
                if (split[c].equals("X")) { // Ending Point
                    input[r][c] = -1;
                    end = new Point(c, r);
                } else if (split[c].equals("S")) { // Starting Point
                    input[r][c] = 10;
                    start = new Point(c, r);
                } else { // Other Points
                    input[r][c] = Integer.parseInt(split[c]);
                }
            }
        }
        scan.close();

        visited = new ArrayList<>();
        visited.add(start);

        output = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                output[r][c] = '#';
            }
        }
        count = 0;
        rollBoulder(input, new Point(start));
        output[start.y][start.x] = 'S';
        output[end.y][end.x] = 'X';

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(output[r][c] + " ");
            }
            System.out.println();
        }
    }

    private boolean rollBoulder(int[][] grid, Point location) {
        if (location.equals(end)) { // Reached the end
            return true;
        }
        if (roll(grid, location, new Point(1, 0))) { // Roll Left
            return true;
        }

        if (roll(grid, location, new Point(-1, 0))) { // Roll Right
            return true;
        }
        if (roll(grid, location, new Point(0, 1))) { // Roll Down
            return true;
        }
        if (roll(grid, location, new Point(0, -1))) { // Roll Up
            return true;
        }
        return false;
    }

    private boolean roll(int[][] grid, Point location, Point offset) {
        boolean rolled = false;
        int height = grid[location.y][location.x];
        Point current = new Point(location);
        current.x += offset.x;
        current.y += offset.y;
        if (isInBounds(current)) {
            boolean v = visited.contains(current); // If has been visited
            if (!v && isDownhill(grid, height, current)) {
                visited.add(current);
                rolled = rollBoulder(grid, new Point(current));
                if (!rolled) {
                    visited.remove(current);
                } else {
                    output[current.y][current.x] = '.';
                }
            }
        }
        return rolled;
    }

    /* If it is rolling downhill */
    private boolean isDownhill(int[][] grid, int height, Point location) {
        return grid[location.y][location.x] <= height;
    }

    /* Is a valid point in array */
    private boolean isInBounds(Point location) {
        return location.x >= 0 && location.x < cols && location.y >= 0 && location.y < rows;
    }

}
