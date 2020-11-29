
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: Tic-Tac-Toe
//        Points: 6
        Scanner scan = new Scanner(new File("prob10.txt"));
        String s = scan.nextLine();
        while (!s.equals("=========")) {
            char grid[][] = new char[3][3];
            grid[0] = s.substring(0, 3).toCharArray();
            grid[1] = s.substring(3, 6).toCharArray();
            grid[2] = s.substring(6).toCharArray();
            int win = 0; // 0 = tie, 1 = O, 2 = X
            /* Check Row */
            for (int i = 0; i < 3; i++) {
                if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) { // Winning row
                    if (grid[i][0] == 'O') {
                        win = 1;
                    } else {
                        win = 2;
                    }
                    grid[i][0] = '$';
                    grid[i][1] = '$';
                    grid[i][2] = '$';
                }
            }

            /* Check Columns */
            for (int i = 0; i < 3; i++) {
                if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) { // Winning Column
                    if (grid[0][i] == 'O') {
                        win = 1;
                    } else {
                        win = 2;
                    }
                    grid[0][i] = '$';
                    grid[1][i] = '$';
                    grid[2][i] = '$';
                }
            }
            /* Check Diagonals */
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) { // Winning Diagonal
                if (grid[0][0] == 'O') {
                    win = 1;
                } else {
                    win = 2;
                }
                grid[0][0] = '$';
                grid[1][1] = '$';
                grid[2][2] = '$';
            }
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) { // Winning Diagonal
                if (grid[0][0] == 'O') {
                    win = 1;
                } else {
                    win = 2;
                }
                grid[0][2] = '$';
                grid[1][1] = '$';
                grid[2][0] = '$';
            }

            if (win == 0) {
                System.out.println("There was a tie.");
            } else if (win == 1) {
                System.out.println("Player O won.");
            } else if (win == 2) {
                System.out.println("Player X won.");
            }
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    System.out.print(grid[x][y]);
                }
                System.out.println();
            }
            System.out.println();
            s = scan.nextLine();
        }
    }
}
