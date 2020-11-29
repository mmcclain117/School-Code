
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static char grid[][] = new char[9][9];

    public static void main(String[] args) throws Exception {
//        Problem: Sudoku Judging
//        Points: 8
        Scanner scan = new Scanner(new File("prob07.txt"));
        for (int i = 0; i < grid[0].length; i++) {
            grid[i] = scan.nextLine().toCharArray();
        }
        if (check()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

    /* Checks the grid */
    private static boolean check() {
        /* Checks rows */
        for (int o = 0; o < 9; o++) {
            boolean numbers[] = new boolean[9]; // If number exist
            for (int i = 0; i < 9; i++) {
                int point = grid[o][i] - 49; // Checking point
                numbers[point] = !numbers[point];
            }
            if (!validation(numbers)) {
//                System.out.println("The rows are the problem");// Error Checking Message
                return false;
            }
        }
        /* Checks columns */
        for (int o = 0; o < 9; o++) {
            boolean numbers[] = new boolean[9]; // If number exist
            for (int i = 0; i < 9; i++) {
                int point = grid[i][o] - 49; // Checking point
                numbers[point] = !numbers[point];
            }
            if (!validation(numbers)) {
//                System.out.println("The columns are the problem");// Error Checking Message
                return false;
            }
        }
        /* Checking the boxes */
        for (int i = 0; i < 9; i += 3) { // Has the three column of boxes
            for (int o = 0; o < 9; o += 3) { // Check 3 boxes on each row
                boolean numbers[] = new boolean[9]; // If number exist
                for (int x = i; x < i + 3; x++) {
                    for (int y = o; y < o + 3; y++) {
                        int point = grid[x][y] - 49; // Checking point
                        numbers[point] = !numbers[point];
                    }
                }
                if (!validation(numbers)) {
//                    System.out.println("Boxes ");// Error Checking Message
                    return false;
                }
            }
        }
        return true;
    }

    /* Checks to see if the whole boolean array is true */
    public static boolean validation(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
