
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob15 {

    public static char visit[][]; // What has visited where

    public static void main(String[] args) throws Exception {
//        Problem: Reverse Crossword
//        Points: 17
        Scanner scan = new Scanner(new File("prob15.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.nextLine();
        char grid[][] = new char[a][b];
        visit = new char[a][b];
        for (int i = 0; i < a; i++) {
            grid[i] = scan.nextLine().toCharArray();
            for (int ii = 0; ii < b; ii++) {
                visit[i][ii] = 'N';
            }
        }
        ArrayList<String> across = new ArrayList(); // Across words
        ArrayList<String> down = new ArrayList(); // Down words
        ArrayList<String> ord = new ArrayList(); // Order
        for (int x = 0; x < a; x++) {
            for (int y = 0; y < b; y++) {
                if (grid[x][y] != '*') { // Is a word
                    int dir = getDir(grid, x, y); // Gets Direction
                    String tmp = check(grid, x, y); // Checks for word
                    if (!tmp.equals("")) {
                        if (dir == 1) {
                            ord.add("D");
                            down.add(tmp);
                        } else if (dir == 2) {
                            ord.add("A");
                            across.add(tmp);
                        }
                    }
                }
            }
        }

        /* Print out the Across */
        System.out.println("Across");
        int con = 0; // Counter for Across
        for (int i = 0; i < ord.size(); i++) {
            if ("A".equals(ord.get(i))) {
                System.out.println((i + 1) + ". \t" + across.get(con));
                con++;
            }
        }

        /* Print out the Down */
        System.out.println("Down");
        con = 0; // Counter for Down
        for (int i = 0; i < ord.size(); i++) {
            if ("D".equals(ord.get(i))) {
                System.out.println((i + 1) + ". \t" + down.get(con));
                con++;
            }
        }
//        System.out.println(Arrays.toString(across.toArray()));
//        System.out.println(Arrays.toString(down.toArray()));
//        System.out.println(Arrays.toString(ord.toArray()));
    }

    /* Checks and returns word */
    private static String check(char gr[][], int x, int y) {
        int direct = getDir(gr, x, y);
        if (direct > 0) {
            String fin = gr[x][y] + "";
            if (direct == 2) { // Goes Down
                int con = 1; // Counter
                while (con + y < gr[x].length) {
                    if (gr[x][y + con] != '*') {
                        fin += gr[x][y + con];
                        con++;
                    } else {
                        break;
                    }
                }
                /* Mark that the spot has been visited Downward */
                for (int i = 0; i < con; i++) {
                    visit[x][y + i] = 'D';
                }
            } else if (direct == 1) { // Goes Across
                int con = 1; // Counter
                while (con + x < gr[x].length) {
                    if (gr[x + con][y] != '*') {
                        fin += gr[x + con][y];
                        con++;
                    } else {
                        break;
                    }
                }
                /* Mark that the spot has been visited Across */
                for (int i = 0; i < con; i++) {
                    visit[x + i][y] = 'A';
                }
            }
            return fin;
        } else {
            return "";
        }
    }

    /* Gets the Direction. 1 = across; 2 = Down ; 0 = None */
    private static int getDir(char gr[][], int x, int y) {
        try {
            if (gr[x + 1][y] != '*' && visit[x + 1][y] != 'A') {
                return 1;
            } else if (gr[x][y + 1] != '*' && visit[x][y + 1] != 'D') {
                return 2;
            } else {
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }
}
