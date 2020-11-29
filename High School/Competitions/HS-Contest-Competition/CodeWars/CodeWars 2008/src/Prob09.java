
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));
        while (scan.hasNext()) {
            String name = scan.next();
            System.out.println(name);
            int x = scan.nextInt();
            int y = scan.nextInt();
            String d = scan.next(); // Manipulation
            scan.nextLine();
            char grid[][] = new char[y][x];
            for (int i = 0; i < y; i++) {
                grid[i] = scan.nextLine().toCharArray();
            }
            if (d.equals("R")) { // Reversal
                /* Print array */
                for (int yy = 0; yy < y; yy++) {
                    for (int xx = x - 1; xx > -1; xx--) {
                        System.out.print(grid[yy][xx]);
                    }
                    System.out.println();
                }
            } else if (d.equals("IR")) { // Inverse
                /* Print array */
                for (int yy = y - 1; yy > -1; yy--) {
                    for (int xx = x - 1; xx > -1; xx--) {
                        System.out.print(grid[yy][xx]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
