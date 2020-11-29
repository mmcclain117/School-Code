
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Hardware Troubles
//        Points: 7
        Scanner scan = new Scanner(new File("prob11.txt"));
        int x = scan.nextInt();
        int y = scan.nextInt();
        scan.nextLine();
        int grid[][] = new int[y][x];
        ArrayList<Integer> xI = new ArrayList(); // X indexs
        ArrayList<Integer> yI = new ArrayList(); // Y indexs
        /* Read in and fill the Grid */
        for (int i = 0; i < y; i++) {
            String tmp = scan.nextLine();
            String split[] = tmp.split("[ ]+");
            for (int o = 0; o < split.length; o++) {
                if (split[o].equals("x")) { // Empty spot
                    grid[i][o] = -1;
                    // Adds to be filled into
                    xI.add(o);
                    yI.add(i);
                } else { // Good Number
                    grid[i][o] = Integer.parseInt(split[o]);
                }
            }
        }
        /* Fill in the Empty Spots */
        while (!xI.isEmpty()) {
            grid[yI.remove(0)][xI.remove(0)] = Integer.parseInt(scan.nextLine());
        }
        /* Prints out the array */
        for (int yy = 0; yy < grid.length; yy++) {
            for (int xx = 0; xx < grid[0].length; xx++) {
                System.out.print(grid[yy][xx] + " ");
            }
            System.out.println();
        }
    }

}
