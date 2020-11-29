
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Calendar
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        int day = scan.nextInt(); // Starting Day
        int days = scan.nextInt(); // Number of Days in the Month
        System.out.println("Sun Mon Tue Wed Thr Fri Sat");
        int grid[][] = new int[7][6];
        for (int i = 0; i <= days; i++) {
            int tmpInd = day + i - 2; // Temperary Index
            grid[tmpInd % 7][tmpInd / 7] = i;
        }
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] != 0) {
                    System.out.printf("%3d ", grid[y][x]);
                } else if (x != 0) {
                    break;
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}
