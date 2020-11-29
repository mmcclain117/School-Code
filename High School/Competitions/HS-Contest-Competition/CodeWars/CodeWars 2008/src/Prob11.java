
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    private static int[][] gr = new int[11][11];
    private static boolean[][] as = new boolean[11][11]; // Astrik array 

    public static void main(String[] args) throws Exception {
//        Problem: Diffusion Limited Aggresssion
//        Points: 9
        Scanner scan = new Scanner(new File("prob11.txt"));
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 11; x++) {
                gr[x][y] = scan.nextInt();
            }
        }
        scan.nextLine();
        String li = scan.nextLine(); // Line
        while (!"-1 -1".equals(li)) {
            int x = Integer.parseInt(li.split(" ")[0]);
            int y = Integer.parseInt(li.split(" ")[1]);
            flood(x, y);
            li = scan.nextLine();
        }
        /* Print out the Astriks Array */
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 11; x++) {
                System.out.print(as[x][y] ? "*" : ".");
            }
            System.out.println();
        }

    }

    /* Finds and follows least resisting path based on 8 cornering spots */
    private static void flood(int x, int y) {
        as[x][y] = true;
        int minx = -1; // Minimum X spot
        int miny = -1; // Minimum Y Spot
        int minV = gr[x][y]; // Minimum Value
        if (Check(x, y + 1)) {// Down
            if (gr[x][y + 1] < minV) {
                miny = y + 1;
                minx = x;
                minV = gr[minx][miny];
            }
        }
        if (Check(x + 1, y)) { // Right
            if (gr[x + 1][y] < minV) {
                miny = y;
                minx = x + 1;
                minV = gr[minx][miny];
            }
        }
        if (Check(x - 1, y)) { // Left
            if (gr[x - 1][y] < minV) {
                miny = y;
                minx = x - 1;
                minV = gr[minx][miny];
            }
        }
        if (Check(x, y - 1)) { // Up
            if (gr[x][y - 1] < minV) {
                miny = y - 1;
                minx = x;
                minV = gr[minx][miny];
            }
        }

        if (Check(x - 1, y + 1)) {// Down Left
            if (gr[x - 1][y + 1] < minV) {
                miny = y + 1;
                minx = x - 1;
                minV = gr[minx][miny];
            }
        }
        if (Check(x + 1, y + 1)) { // Down Right
            if (gr[x + 1][y + 1] < minV) {
                miny = y + 1;
                minx = x + 1;
                minV = gr[minx][miny];
            }
        }
        if (Check(x - 1, y - 1)) { // Up Left
            if (gr[x - 1][y - 1] < minV) {
                miny = y - 1;
                minx = x - 1;
                minV = gr[minx][miny];
            }
        }
        if (Check(x + 1, y - 1)) { // Up Right
            if (gr[x + 1][y - 1] < minV) {
                miny = y - 1;
                minx = x + 1;
                minV = gr[minx][miny];
            }
        }

        if (minx != -1 && miny != 0) { // Can Move somewhere
            flood(minx, miny);

        }
    }

    /* Checks to see if it is in the grid */
    private static boolean Check(int x, int y) {
        try {
            int c = gr[y][x];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
