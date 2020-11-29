
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Screwed up format but don't care. */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Simple Database
//        Points: 7
        Scanner scan = new Scanner(new File("prob07.txt"));
        /* Header */
        int df = scan.nextInt(); // Data Fields
        int dr = scan.nextInt(); // Data Records
        int q = scan.nextInt(); // Query
        scan.nextLine();
        /* Data Section */
//      Scans in the array into a 2d array
        String grid[][] = new String[dr + 1][df];
        for (int i = 0; i < dr + 1; i++) {
            String tmp[] = scan.nextLine().split("[,]+");
            for (int p = 0; p < tmp.length; p++) {
                grid[i][p] = tmp[p].trim();
            }
        }
        /* Query Section */
        for (int i = 0; i < q; i++) {
            String s = scan.nextLine();
            String split[] = s.split("[=]");
            String deli = split[0].trim(); // Header looking into
            int x = -1;
            /* Print out the top header */
            for (int o = 0; o < grid[0].length; o++) {
                System.out.print(grid[0][o] + "\t");
            }
            System.out.println();
            /* Finds inderx of Header */
            for (int p = 0; p < df; p++) {
                if (grid[0][p].equals(deli)) {
                    x = p;
                }
            }
            String rec = split[1].trim(); // Data Looking for
            /* Finds the matches */
            for (int p = 1; p < df + 2; p++) {
                if (grid[p][x].equals(rec)) {
                    print(grid[p]);
                }
            }
            System.out.println();
        }
    }

    /* Print out the specific row of the grid */
    private static void print(String[] grid) {
        for (String a : grid) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
}
