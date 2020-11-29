
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Lawn {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("lawn.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            char[][] ch = new char[y][x];
            int sx = 0; // Start x
            int sy = 0; // Start y
            for (int ii = 0; ii < y; ii++) {
                String s = scan.nextLine();
                char cc[] = s.toCharArray();
                for (int iu = 0; iu < cc.length; iu++) {
                    if (cc[iu] == 'X') {
                        sx = ii;
                        sy = iu;
                    }
                }
                ch[ii] = cc;
            }
            flodFlow(ch, sx, sy);
        }
    }

    private static void flodFlow(char ch[][], int sx, int sy) {
//        if (ch[sx][sy]) {
            
//        }
    }
}
