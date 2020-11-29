
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("maps.txt"));
        int map[][] = new int[10][10];
        int sx = scan.nextInt();
        int sy = scan.nextInt();
        int ex = scan.nextInt();
        int ey = scan.nextInt();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                map[x][y] = scan.nextInt();
            }
        }
        boolean x = false;
        while (x) {

        }
//        int i = scan.nextInt();
//        out.println(i);

    }
}
