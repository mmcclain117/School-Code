
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    private static char gridA[][]
            = {{'0', '0', '1', '0', '0'},
            {'0', '1', '0', '1', '0'},
            {'1', '0', '0', '0', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '0', '1'}
            };

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob12.txt"));
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String split[] = s.split("[,]+");
            char grid[][] = new char[8][8];
//            System.out.println(Arrays.toString(split));
            for (int i = 0; i < split.length; i++) {
                int q = Integer.parseInt(split[i].trim());
                String tmp = Integer.toBinaryString(q);
                int more = 8 - tmp.length(); // Adding to make a 8x8 grid
//                System.out.println(tmp.length() + " " + more);
                while (more > 0) { // Adding to make them 8 long
                    tmp = "0" + tmp;
                    more--;
                }
                grid[i] = tmp.toCharArray();
//                System.out.println(tmp);
            }
            System.out.println(searchGrid(grid) ? "Yes" : "No");
            printGrid(grid);
        }
    }

    /* Searches the grid for an A */
    private static boolean searchGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int o = 0; o < grid[0].length; o++) {
                if (grid[i][o] == '1') { // Found a spot
//                    System.out.println(checkA(grid, i, o));
                    if (checkA(grid, i, o)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* X,Y = top of the A. Checks if it is an A */
    private static boolean checkA(char[][] grid, int x, int y) {
        if (x - 2 >= 0 && x + 2 < grid.length) {
            if (y + 5 < grid.length) {
                for (int i = 0; i < x + 2; i++) {
                    for (int p = 0; p < 5; p++) {
                        if (grid[x - 2 + i][y + p] != gridA[i][p]) {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /* Prints out the grid */
    private static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int o = 0; o < grid[0].length; o++) {
                System.out.print(grid[i][o] + "");
            }
            System.out.println();
        }
    }
}
