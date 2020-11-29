

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 *
 */
public class Prob10 {

    public static char grid[][];

    public static void main(String[] args) throws Exception {
//            Problem: PacMan
//            Points: 13
        Scanner in = new Scanner(new File("grid.in"));
        int sx = 0; // Starting X
        int sy = 0; // Starting Y
        grid = new char[20][20];
        /* Scanning in the grid */
        for (int i = 0; i < grid.length; i++) {
            String t = in.nextLine();
            grid[i] = t.toCharArray();
            if (t.contains("P")) {
                sy = i;
                sx = t.indexOf("P");
            }
        }
        grid[sx][sy] = 'Q';
        // System.out.println(sx + " "+ sy);
        in.close();
        Scanner scan = new Scanner(new File("prob10_1.txt"));
        String controls = scan.nextLine(); // The controls used
        char direct[] = controls.toCharArray();
        boolean game = true; // Game continue
        int score = 0;
        /* Moving PacMan */
        for (int i = 0; i < direct.length; i++) {
            if (!game) {
                break;
            }
//            try {
            switch (direct[i]) { // Moves PacMan
                case 'R':
                    sx++;
                    if (sx < 0) {
                        sx = 0;
                    } else if (sx >= 20) {
                        sx = 19;
                    }
                    if (grid[sy][sx] == '#') { // Wall
                        sx--;
                    } else if (grid[sy][sx] == '[') { // Left Portal
                        sx = 19;
                    } else if (grid[sy][sx] == ']') { // Right Portal
                        sx = 0;
                    }
                    break;
                case 'L':
                    sx--;
                    if (sx < 0) {
                        sx = 0;
                    } else if (sx >= 20) {
                        sx = 19;
                    }
                    if (grid[sy][sx] == '#') { // Wall
                        sx++;
                    } else if (grid[sy][sx] == '[') { // Left Portal
                        sx = 19;
                    } else if (grid[sy][sx] == ']') { // Right Portal
                        sx = 0;
                    }
                    break;
                case 'U':
                    sy--;
                    if (sy < 0) {
                        sy = 0;
                    } else if (sy >= 20) {
                        sy = 19;
                    }
                    if (grid[sy][sx] == '#') { // Wall
                        sy++;
                    }
                    break;
                case 'D':
                    sy++;
                    if (sy < 0) {
                        sy = 0;
                    } else if (sy >= 20) {
                        sy = 19;
                    }
                    if (grid[sy][sx] == '#') { // Wall
                        sy--;
                    }
                    break;
            }
//                System.out.println(grid[sy][sx]);
            switch (grid[sy][sx]) {
                case '.': // Crum
                    score += 1;
                    break;
                case '*': // Target
                    score += 10;
                    break;
                case '%': // Cherries
                    score += 25;
                    break;
                case 'O': // Watermelon
                    score += 50;
                    break;
                case '@': // Ghost
                    game = false; // Game Over
                    break;
                default:
//                        System.out.println("SHIT that didn't work " + grid[sy][sx] + " " + direct[i]);
//                    print();
                    break;
            }
            grid[sy][sx] = 'Q';
//            print();
            // System.out.println();
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("SHIT THat also didnt work");
//            }
        }
        System.out.println(score + " pts.");
    }

    /* Print the grid array */
    private static void print() {
        for (int q = 0; q < 20; q++) {
            for (int o = 0; o < 20; o++) {
                System.out.print(grid[q][o]);
            }
            System.out.println();
        }
    }
}
