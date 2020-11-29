
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    private static char grid[][];

    public static void main(String[] args) throws Exception {
//        Problem: Shooting Star
//        Points: 6
        Scanner scan = new Scanner(new File("prob07.txt"));
        grid = new char[3][3];
        setup();
        while (scan.hasNext()) {
            int a = scan.nextInt();
            switch (a) {
                case 1:
                    update(0, 0);
                    print();
                    break;
                case 2:
                    update(1, 0);
                    print();
                    break;
                case 3:
                    update(2, 0);
                    print();
                    break;
                case 4:
                    update(0, 1);
                    print();
                    break;
                case 5:
                    update(1, 1);
                    print();
                    break;
                case 6:
                    update(2, 1);
                    print();
                    break;
                case 7:
                    update(0, 2);
                    print();
                    break;
                case 8:
                    update(1, 2);
                    print();
                    break;
                case 9:
                    update(2, 2);
                    print();
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        }
    }

    /* Setting up the grid on new game */
    private static void setup() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                grid[x][y] = '.';
            }
        }
        grid[1][1] = '*';
    }

    /* Updating surroundings when hit */
    private static void update(int x, int y) {
        if (grid[x][y] == '.') {
            grid[x][y] = '*';
        } else {
            grid[x][y] = '.';
            if (x + 1 < 3) {
                opposite(x + 1, y);
            }
            if (y + 1 < 3) {
                opposite(x, y + 1);
            }
            if (x - 1 >= 0) {
                opposite(x - 1, y);
            }
            if (y - 1 >= 0) {
                opposite(x, y - 1);
            }
        }
    }

    /* Makes it the opposite of current state */
    private static void opposite(int x, int y) {
        if (grid[x][y] == '*') {
            grid[x][y] = '.';
        } else {
            grid[x][y] = '*';
        }
    }

    /* Prints out the grid */
    private static void print() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
