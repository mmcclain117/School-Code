
import java.util.Arrays;

public class SpiralAlgorithm {

    public static void main(String[] args) {
        char[][] arr = new char[3][3];

        int c1 = 0, c2 = arr[0].length - 1, r1 = 0, r2 = arr.length - 1;

        int num = 0;
        String val = "HELLO";

        while (r1 <= r2 + 1) {
            for (int i = c1; i <= c2 - 1; i++) {
                arr[r1][i] = val.charAt(num++ % val.length());
            }
            for (int i = r1; i <= r2 - 1; i++) {
                arr[i][c2] = val.charAt(num++ % val.length());
            }
            for (int i = c2; i >= c1 + 1; i--) {
                arr[r2][i] = val.charAt(num++ % val.length());
            }
            for (int i = r2; i >= r1 + 1; i--) {
                arr[i][c1] = val.charAt(num++ % val.length());
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        System.out.println(Arrays.toString(arr[1]));
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                System.out.printf("%3s", arr[y][x] == 0 ? ' ' : arr[y][x]);
            }
            System.out.println();
        }

    }

}
