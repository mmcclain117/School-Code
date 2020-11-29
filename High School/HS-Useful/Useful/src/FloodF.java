
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class FloodF {

    private void fillGrid(char[][] dim, int r, int c) {
        if (dim[r][c] == 'P') {
            dim[r][c] = 'W';
            fillGrid(dim, r + 1, c);
            fillGrid(dim, r - 1, c);
            fillGrid(dim, r, c + 1);
            fillGrid(dim, r, c - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Flood.dat"));
        int y = scan.nextInt();
        int x = scan.nextInt();
        char dim[][] = new char[y][x];
        int startx = 1;
        int starty = 1;
        FloodF ff = new FloodF();
        ff.fillGrid(dim, startx, starty);
    }
}
