package Done;

/**
 *
 * @author Master Ward
 */
public class Tester {

    public static void main(String[] args) {
        int[] theArray = {4, 2, 5, 1, 3, 1, 8, 0, 9, 6};
        sort(theArray, 0, 9);
        for (int i = 0; i < theArray.length; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println(" ");
    }

    public static void sort(int[] a, int left, int right) {
        if (left < right) {
            int k = left;
            int j = right;
            int pivotValue = a[(left + right) / 2]; //salient feature
            while (k < j) {
                while (a[k] < pivotValue) //salient feature (pivot)
                {
                    k++;
                }
                while (pivotValue < a[j]) {
                    j--;
                }
                if (k <= j) {
                    int temp = a[k]; //swap a[k] and a[j]
                    a[k] = a[j];
                    a[j] = temp;
                    k++;
                    j--;
                }
            }
            sort(a, left, j); //salient feature (recursion)
            sort(a, k, right);
        }
    }
}
