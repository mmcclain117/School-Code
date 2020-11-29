
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));
        int n = scan.nextInt();
        int A[][] = new int[n][n];
        int k = (n * n) - 1, c1 = 0, c2 = n - 1, r1 = 0, r2 = n - 1;
        while (k >= 0) {
            for (int i = c2; i >= c1; i--) {
                A[r2][i] = k--;
            }
            for (int j = r2 - 1; j >= r1; j--) {
                A[j][c1] = k--;
            }
            for (int i = c1 + 1; i <= c2; i++) {
                A[r1][i] = k--;
            }
            for (int j = r1 + 1; j <= r2 - 1; j++) {
                A[j][c2] = k--;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }
        /* Printing the Circular matrix */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.print(A[i][j] + "\t");
                System.out.printf("%4s", A[i][j]);
            }
            System.out.println();
        }
    }
}
