
/**
 *
 * @author Master
 */
public class Bubble_Sort {

    public static void main(String[] args) {
        int n, c, d, swap;
        int a[] = {10, 2, 9, 56, 3, 56, 2, 4, 6, 4, 2, 3, 42, 2, 11, 1, 2, 3, 4, 54, 6, 7, 8, 9, 10, 0, 0, 11, 1};
        n = a.length;
        int array[] = new int[n];
        for (c = 0; c < n; c++) {
            array[c] = a[c];
        }
        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d + 1]) {
                    swap = array[d];
                    array[d] = array[d + 1];
                    array[d + 1] = swap;
                }
            }
        }
        for (c = 0; c < n; c++) {
            System.out.print(array[c] + " ");
        }
    }
}
