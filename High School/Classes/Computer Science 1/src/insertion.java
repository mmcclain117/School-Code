
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author Master
 */
public class insertion {

    public static void main(String[] args) {
        int b[] = {1, 1, 21, 45, 147, 0, 3, 2, 8, 5, 65, 1, 3, 2, 5, 2, 4, 3, 3, 6, 36, 3463, 346, 34634, 6346, 346, 346, 346, 346, 64, 4, 3, 44, 4, 4, 4, 4, 2, 3, 5, 2, 5, 2, 23, 1, 5, 32, 3, 5, 11, 235, 1, 2, 11, 3, 3, 1, 5, 35, 35, 1, 35, 35, 3,};
        insertionSort(b);
        out.println(Arrays.toString(b));
    }

    public static void insertionSort(int a[]) {
        int in, out;
        for (out = 1; out < a.length; out++) // out is dividing line
        {
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                a[in] = a[in - 1]; // shift item right,
                --in; // go left one position
            }
            a[in] = (int) temp; // insert marked item
        }

    }
}
