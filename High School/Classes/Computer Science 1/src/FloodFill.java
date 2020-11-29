
import java.util.Arrays;
import java.util.Scanner;

public class FloodFill {

    private void fillGrid(char[][] dim, int r, int c) {
        if (dim[r][c] == 'P') {
            dim[r][c] = 'W';
            fillGrid(dim, r + 1, c);
            fillGrid(dim, r - 1, c);
            fillGrid(dim, r, c + 1);
            fillGrid(dim, r, c - 1);
        }
    }

    /**
     * Main method
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Flood Fill Test\n");

        /**
         * Accept dimensions *
         */
        System.out.println("Enter dimensions of grid");
        int M = scan.nextInt();
        int N = scan.nextInt();

        /**
         * make grid with border as obstacle to avoid boundary conditions *
         */
        char[][] dim = new char[M + 2][N + 2];
        for (int i = 0; i < M + 2; i++) {
            Arrays.fill(dim[i], 'O');
        }

        /**
         * Accept grid *
         */
        System.out.println("Enter grid with 'P' for passage and 'O' for obstacle");

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dim[i][j] = scan.next().charAt(0);
            }
        }

        System.out.println("Enter coordinates to start ");
        int sr = scan.nextInt();
        int sc = scan.nextInt();

        if (dim[sr][sc] != 'P') {
            System.out.println("Invalid coordinates");
            System.exit(0);
        }

        FloodFill ff = new FloodFill();
        ff.fillGrid(dim, sr, sc);
    }
}
