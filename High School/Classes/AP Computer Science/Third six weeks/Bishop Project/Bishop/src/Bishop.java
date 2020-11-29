
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class Bishop {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("bishop.dat"));
        int a = scan.nextInt();
        scan.nextLine();
//        int i = 0;
//        while (i < a) {
        for (int i = 0; i < a; i++) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int k = scan.nextInt();
            int bo[][] = new int[m][n];
            for (int o = 0; o < m; o++) {
                for (int oo = 0; oo < n; oo++) {
                    bo[o][oo] = 0;
                }
            }
//            out.println(m+ " " + n + " " + k);
//            scan.nextLine();
            for (int o = 0; o < k; ++o) {
//                scan.nextLine();
//                String aa[] = scan.nextLine().split("\\s+");
                int x = scan.nextInt();
//                scan.nextInt();
//                int x = Integer.parseInt(aa[0]);
//                int y = Integer.parseInt(aa[1]);
                int y = scan.nextInt();
//                out.println(x + " " + y);
//                out.println(Arrays.toString(bo));
                int con = 0;
                bo[x][y] = 1;
                while (x - con >= 0 || y - con >= 0 || x + con <= 1000 || y + con <= 1000) {
                    if (x - con > 0) {
                        if (y + con < n) {
                            bo[x - con][y + con] = 1; // up left
                        }
                        if (y - con > 0) {
                            bo[x - con][y - con] = 1; // down left                            
                        }
                    }
                    if (x + con < m) {
                        if (y + con < n) {
                            bo[x + con][y + con] = 1; // up Right
                        }
                        if (y - con > 0) {
                            bo[x + con][y - con] = 1; // down left                            
                        }
                    }
//                    y - con > 0 || x + con < m || y + con < n
//                    bo[x + con][y + con] = 1; // up right
//                    bo[x + con][y - con] = 1; // down right
//                    bo[x - con][y + con] = 1; // up left
                    ++con;
                }
                con = 0;
            }
            int sum = 0;
            for (int o = 0; o < m; o++) {
                for (int oo = 0; oo < n; oo++) {
                    out.print(bo[o][oo] + " ");
                    sum += bo[o][oo] == 1 ? 1 : 0;
                }
                out.println();
            }
            out.println((m * n) - sum);
//            scan.nextLine();
//            i++;
        }
    }
}
