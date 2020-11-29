
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author Master
 */
public class ShellSort {

    public static void main(String[] args) {
        int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 0, 1, 7, 9, 6, 4, 6, 8, 6, 4, 4, 678564, 9, 8767698, 5236, 3434, 55, 5, 6, 6, 6, 6, 6, 54, 3, 3, 54, 122335423, 0, 123344};
        shell(a);
        out.println(Arrays.toString(a));
    }

    public static void shell(int[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
