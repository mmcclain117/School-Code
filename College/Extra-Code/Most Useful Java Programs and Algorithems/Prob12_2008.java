
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    private static char gr[][];

    public static void main(String[] args) throws Exception {
//        Problem: Haunted House Inspector
//        Points: 10
        Scanner scan = new Scanner(new File("prob12.txt"));
        int w = scan.nextInt(); // X
        int h = scan.nextInt(); // Y
        int l = scan.nextInt(); // Length of maze
        scan.nextLine();
        gr = new char[h][w];
        for (int i = 0; i < h; i++) {
            gr[i] = scan.nextLine().toCharArray();
        }
        int sx = 0; // Start X
        int sy = 0; // Start Y
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
//                System.out.print(ch[i][j] + " ");
                if (gr[i][j] == 'S') {
                    sx = j;
                    sy = i;
                    break;
                }
            }
        }
        fill(sx, sy, l);
        if (!check()) {
            System.out.println("All Fires Extinguished!");
        } else {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(gr[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void fill(int x, int y, int c) {
        if (c != 0 && gr[y][x] != '#' && gr[y][x] != '.') {
            gr[y][x] = '.';
            c--;
            try {
                fill(x + 1, y, c);
                fill(x, y + 1, c);
                fill(x, y - 1, c);
                fill(x - 1, y, c);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    private static boolean check() {
        String fin = "";
        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[0].length; j++) {
                fin += gr[i][j];
            }
        }
        return fin.contains("F") || fin.contains(" ");
    }
}
