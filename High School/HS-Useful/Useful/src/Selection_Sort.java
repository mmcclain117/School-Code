
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Selection_Sort {

    public static void main(String[] args) {
        int a[] = {1, 2, 27, 3, 23, 5, 5453, 1234, 4543, 2343, 2523523, 234634254, 272457, 9};
        int small[] = new int[a.length];
        sort(a, small);
        int z = 0;
        do {
            out.print(small[z] + " ");
            z++;
        } while (z < a.length);
    }

    public static void sort(int a[], int[] small) {
        int Sma = 1000000;
        int s = a.length;
        for (int bb = 0; bb < s; bb++) {
            for (int ta = bb + 1; ta < s; ta++) {
                if (Sma > a[ta]) {
                    Sma = a[bb];
                } else {
                    Sma = a[ta];
                }
            }
            small[bb] = Sma;
        }
    }
}
