
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Matrix {

    public static void main(String[] args) throws Exception {
        int c[][] = new int[3][2];
        int a[][] = {{1, 2, -2, 0},
        {-3, 4, 7, 2},
        {6, 0, 3, 1}};
        int b[][] = {{-1, 3},
        {0, 9},
        {1, -11},
        {4, -5}};
        c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0] + a[0][2] * b[2][0] + a[0][3] * b[3][0];
        c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1] + a[0][2] * b[2][1] + a[0][3] * b[3][1];
        c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1] + a[1][2] * b[2][1] + a[1][3] * b[3][1];
        c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0] + a[1][2] * b[2][0] + a[1][3] * b[3][0];
        c[2][1] = a[2][0] * b[0][1] + a[2][1] * b[1][1] + a[2][2] * b[2][1] + a[2][3] * b[3][1];
        c[2][0] = a[2][0] * b[0][0] + a[2][1] * b[1][0] + a[2][2] * b[2][0] + a[2][3] * b[3][0];
        System.out.println(c[0][0] + "   " + c[0][1]);
        System.out.println(c[1][0] + "    " + c[1][1]);
        System.out.println(c[2][0] + "    " + c[2][1]);
    }

    public static void Matrix() throws Exception {
        Scanner scan = new Scanner(new File("MATRIX.txt"));

    }
}
