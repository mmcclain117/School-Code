
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    private static char ch[][];

    public static void main(String[] args) throws Exception {
//        Problem: Haunted House Inspector
        Scanner scan = new Scanner(new File("prob12.txt"));
        int w = scan.nextInt(); // X
        int h = scan.nextInt(); // Y
        int l = scan.nextInt(); // Length of maze
        scan.nextLine();
        ch = new char[h][w];
        for (int i = 0; i < h; i++) {
            ch[i] = scan.nextLine().toCharArray();
        }
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
//                System.out.print(ch[i][j] + " ");
                if (ch[i][j] == 'S') {
                    sx = j;
                    sy = i;
                    break;
                }
            }
//            System.out.println();
        }
//        System.out.println(sx + " " + sy);
        fill(sx, sy, l);
        if (!check()) {
            System.out.println("All Fires Extinguished!");
        } else {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(ch[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void fill(int x, int y, int c) {
        if (c != 0 && ch[y][x] != '#' && ch[y][x] != '.') {
            ch[y][x] = '.';
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
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                fin += ch[i][j];
            }
        }
        return fin.contains("F") || fin.contains(" ");
    }
}
