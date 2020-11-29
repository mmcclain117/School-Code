
import java.io.File;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class Flood {

    public static int maps[][];
    public static int endx;
    public static int endy;
    public static boolean grid[][];

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("maps.txt"));
        int map[][] = new int[10][10];
        int sx = scan.nextInt();
        int sy = scan.nextInt();
        int ex = scan.nextInt();
        int ey = scan.nextInt();
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                map[x][y] = scan.nextInt();
            }
        }
        maps = map;
        endx = ex;
        endy = ey;
        grid = new boolean[5][5];
        for (int x = 0; x < 5; x++) {
            for (int yy = 0; yy < 5; yy++) {
                grid[x][yy] = maps[x][yy] == 1;
            }
        }
        boolean go[][] = grid;

        floodFill(0, 0);
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                out.print(maps[x][y] + " ");
            }
            out.println();
        }
    }

    /*
     public static int floodFill(int x, int y) {
     if (endx == x || endy == x || !grid[x][y]) {
     return -1;
     } else {
     if (x - 1 > 0 && maps[x - 1][y] == 1) {
     ar.add(x);
     out.println("11");
     ar.add(y);
     grid[x - 1][y] = false;
     return floodFill(x - 1, y);
     }
     if (x + 1 < 5 && maps[x + 1][y] == 1) {
     out.println("12");
     ar.add(x);
     ar.add(y);
     grid[x + 1][y] = false;
     return floodFill(x + 1, y);
                
     }
     if (y - 1 > 0 && maps[x][y - 1] == 1) {
     out.println("13");
     ar.add(x);
     ar.add(y);
     grid[x][y - 1] = false;
     return floodFill(x, y - 1);
     }
     if (y + 1 < 5 && maps[x][y + 1] == 1) {
     out.println("14");
     ar.add(x);
     ar.add(y);
     grid[x][y + 1] = false;
     return floodFill(x, y + 1);
     }
     }
     return -1;
     } */
    private static void floodFill(int x, int y) {
        if (maps[x][y] == 1) {
            maps[x][y] = 2;
            if (x - 1 > 0) {
                floodFill(x - 1, y);
            }
            if (x + 1 < maps.length) {
                floodFill(x + 1, y);
            }
            if (y + 1 < maps.length) {
                floodFill(x, y + 1);
            }
            if (y - 1 > 0) {
                floodFill(x, y - 1);
            }
        }
    }
}
