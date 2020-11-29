
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author Master
 */
public class squares {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("ASA.txt"));
        int x = scan.nextInt();
        int y = scan.nextInt();
//        String a = scan.nextLine();
        int xy[][] = new int[y][x];
        for (int u = 0; u < x; u++) {
            for (int i = 0; i < y; i++) {
                xy[u][i] = scan.nextInt();
            }
        }
//        HashSet o = new HashSet();
        scan.close();
    }
}
