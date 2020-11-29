
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    public static char grid[][];
    public static boolean used[][];

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob13.txt"));
        int n = scan.nextInt(); // Number of words
        int sizeX = scan.nextInt(); // Size of X
        int sizeY = scan.nextInt(); // Size of Y
        scan.nextLine();
        grid = new char[sizeY][sizeX];
        used = new boolean[sizeY][sizeX];
        String words[] = new String[n]; // Words Looking for
        /* Scan in words looking for */
        for (int i = 0; i < n; i++) {
            words[i] = scan.nextLine();
        }
        /* Scan in the grid */
        for (int y = 0; y < sizeY; y++) {
            String tmp = scan.nextLine().replaceAll(" ", "");
            grid[y] = tmp.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            OUTER:
            for (int y = 0; y < sizeY; y++) {
                for (int x = 0; x < sizeX; x++) {
                    if (grid[y][x] == words[i].charAt(0)) { // Found in grid first letter
//                        System.out.println(y + " " + x + " " + grid[y][x]);
                        if (findWord(words[i], y, x)) {
                            break OUTER;
                        }
                    }
                }
            }
        }

        /* Print out the results */
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (used[y][x]) {
                    System.out.print(grid[y][x] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private static boolean findWord(String word, int y, int x) {
        int len = word.length(); // Length of word
        if (len + x <= grid[0].length) { // Right
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y][x + con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y][x + con] = true;
                    con++;
                }
                return true;
            }
        }
        if (x - len >= -1) { // Left
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y][x - con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots                
                con = 0;
                while (con < len) {
                    used[y][x - con] = true;
                    con++;
                }
                return true;
            }
        }
        if (y - len >= -1) { // Up
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y - con][x];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y - con][x] = true;
                    con++;
                }
                return true;
            }
        }
        if (len + y <= grid.length) { // Down
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y + con][x];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y + con][x] = true;
                    con++;
                }
                return true;
            }
        }
        if (len + x <= grid[0].length && len + y <= grid.length) { // Down Right
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y + con][x + con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y + con][x + con] = true;
                    con++;
                }
                return true;
            }
        }
        if (len + x <= grid[0].length && y - len >= -1) { // Up Right
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y - con][x + con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y - con][x + con] = true;
                    con++;
                }
                return true;
            }
        }
        if (len + y <= grid.length && x - len >= -1) { // Down Left
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y + con][x - con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y + con][x - con] = true;
                    con++;
                }
                return true;
            }
        }
        if (x - len >= -1 && y - len >= -1) { // Up Left
            String fin = "";
            int con = 0;
            while (con < len) {
                fin += grid[y - con][x - con];
                con++;
            }
            if (fin.equals(word)) { // Mark visited spots
                con = 0;
                while (con < len) {
                    used[y - con][x - con] = true;
                    con++;
                }
                return true;
            }
        }
        return false;
    }
}
