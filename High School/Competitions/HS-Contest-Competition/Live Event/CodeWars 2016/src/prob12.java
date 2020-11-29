
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class prob12 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob12-1-in.txt"));
        int r = scan.nextInt();
        int c = scan.nextInt();
        scan.nextLine();
        char na[][] = new char[r][c];
        for (int y = 0; y < r; y++) {
            String uu = scan.nextLine();
            char u[] = uu.toCharArray();
            for (int x = 0; x < c; x++) {
                na[y][x] = u[x];
            }
        }
        String fin = "";
        for (int x1 = 0; x1 < c; x1++) {
            for (int d = x1; d < r; d++) {
                fin += na[d][x1];
            }
            for (int l = 0; l + x1 < r; l++) {
                fin += na[x1][l];
            }
        }
        for (int i = fin.length() - 1; i > 0; i--) {
            out.print(fin.substring(i, i + 1));
        }
        out.println(fin);
//	out.println(Arrays.toString(na[0]));
    }
}
