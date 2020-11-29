
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Linear E
//        Points: 7
        Scanner scan = new Scanner(new File("prob12.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.nextLine();
        char ch[][] = new char[a][b];
        for (int i = 0; i < a; i++) {
            String s = scan.nextLine();
            ch[i] = s.toCharArray();
        }
//        System.out.println(a + " " + b);
        spiralPrint(a, b, ch);
        /* Prints out the array */
//        for (int x = 0; x < a; x++) {
//            for (int y = 0; y < b; y++) {
//                if (Character.isAlphabetic(ch[x][y])) {
//                    System.out.print(ch[x][y]);
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
    }

    static void spiralPrint(int m, int n, char a[][]) {
        int i = 0; // Iterator
        int k = 0; // Starting row index
//        int m = 0; // ending row index
        int l = 0; // Starting column index
//        int n = 0; // Ending column index
        StringBuilder fin = new StringBuilder();
        while (k < m && l < n) {
            /* Adds first COlumn */
            if (l < n) {
                for (i = k; i <= m - 1; i++) {
                    fin.append(a[i][l]);
                }
                l++;
            }
            /* Adds last row */
            if (k < m) {
                for (i = l; i <= n - 1; i++) {
                    fin.append(a[m - 1][i]);
                }
                m--;
            }
            /* Adds last Column */
            for (i = m - 1; i >= k; i--) {
                fin.append(a[i][n - 1]);
            }
            n--;
            /* Adds first row */
            for (i = n - 1; i >= l; i--) {
                fin.append(a[k][i]);
            }
            k++;
        }
        fin.reverse();// Reverses string to be forwards
        System.out.println(fin.toString().trim());
    }
}
