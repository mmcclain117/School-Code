
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob17 {

    private static int turns;
    private static ArrayList<Point> points;
    private static int lowY;
    private static int lowX;

    public static void main(String[] args) throws Exception {
//        Problem: Spiral Triangles
//        Points: 12
        Scanner scan = new Scanner(new File("prob17.txt"));
        String line = scan.nextLine();
        while (!line.equals("# #")) {
            lowX = 0;
            lowY = 0;
            turns = 0;
            points = new ArrayList();
            String[] split = line.split(" "); // Direction, Endpoint
            int endPoint;
            if (split[1].charAt(0) > 'A') {
                endPoint = (split[1].charAt(0) - 'A') + 10;
            } else {
                endPoint = Integer.parseInt(split[1]);
            }
            String path = printPath(split[0], endPoint);
            int height = calculateHeight();
            int width = calculateWidth();

            char grid[][] = new char[height][width];
            /* Fill the grid */
            for (int r = 0; r < height; r++) {
                grid[r] = new char[width];
                for (int c = 0; c < width; c++) {
                    grid[r][c] = '.';
                }
            }

            Point start = new Point((-1 * lowX), (-1 * lowY)); // Starting Point
            grid[start.y][start.x] = '0';
            Point cur = new Point(start); // Current Point
            for (int p = 1; p < path.length(); p++) {
                char c = path.charAt(p);
                switch (c) {
                    case '\\':
                        cur.x++;
                        cur.y++;
                        grid[cur.y][cur.x] = c;
                        cur.x++;
                        cur.y++;
                        break;
                    case '-':
                        cur.x--;
                        grid[cur.y][cur.x] = c;
                        cur.x--;
                        grid[cur.y][cur.x] = c;
                        cur.x--;
                        grid[cur.y][cur.x] = c;
                        cur.x--;
                        p += 2;
                        break;
                    case '/':
                        cur.y--;
                        cur.x++;
                        grid[cur.y][cur.x] = c;
                        cur.y--;
                        cur.x++;
                        break;
                    default:
                        grid[cur.y][cur.x] = c;
                        break;
                }
            }
            printGrid(grid);
            System.out.println();
            line = scan.nextLine();
        }
        scan.close();
    }


    /* Prints the Grid */
    private static void printGrid(char grid[][]) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }

    private static String printPath(String start, int end) {
        String direction = start; // Start Direction
        int directionCount = 0; // Change Direction Count
        int incrementCount = 2; // Direction increment Counter
        String fin = ""; // Final Answer
        Point curLocation = new Point(0, 0); // Current Location
        for (int i = 0; i < end; i++) {
            points.add(curLocation);
            curLocation = new Point(curLocation);
            if (i > 9) {
                fin += (char) ('A' + (i - 10));
            } else {
                fin += i;
            }
            if (direction.equals("-")) {
                fin += direction + direction + direction;
                curLocation.x -= 4;
            } else {
                fin += direction;
                if (direction.equals("/")) {
                    curLocation.x += 2;
                    curLocation.y -= 2;
                } else if (direction.equals("\\")) {
                    curLocation.x += 2;
                    curLocation.y += 2;
                }
            }
            if (i == directionCount) {
                direction = getNextDirection(direction);
                directionCount += incrementCount;
                incrementCount++;
                turns++;
            }
        }
        points.add(curLocation);
        if (end > 9) {
            fin += (char) ('A' + (end - 10));
        } else {
            fin += end;
        }
        return fin;
    }

    private static int calculateHeight() {
        int highY = 0;
        for (Point p : points) {
            if (p.y < lowY) {
                lowY = p.y;
            }
            if (p.y > highY) {
                highY = p.y;
            }
        }
        return (-1 * lowY) + highY + 1; // Height
    }

    private static int calculateWidth() {
        int highX = 0;
        for (Point p : points) {
            if (p.x < lowX) {
                lowX = p.x;
            }
            if (p.x > highX) {
                highX = p.x;
            }
        }
        return (-1 * lowX) + highX + 1; // Width
    }

    private static String getNextDirection(String direction) {
        switch (direction) {
            case "/":
                return "\\";
            case "\\":
                return "-";
            case "-":
                return "/";
            default:
                return "";
        }
    }
}
