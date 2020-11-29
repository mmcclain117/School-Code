
import static java.lang.System.out;
import java.util.*;

public class Main {

    public int ry[];
    public static ArrayList ar = new ArrayList();
    public static LinkedList ll = new LinkedList();

    public static void main(String[] args) {
        int a[] = rand();
//        int a[] = {1, 20, 1, 3, 51, 5, 4, 325, 24, 67, 27, 8, 85, 6, 4, 34, 5, 312, 3, 3};
        out.println("Original: " + Arrays.toString(a));
        int b[] = copyArray(a);
        Arrays.sort(b);
        out.println("Sorted: " + Arrays.toString(b));
        long s = System.nanoTime();
        long e = 0;
        long time = 0;
        out.print("Bubble: " + Arrays.toString(bubbleSort(copyArray(a))));
        e = System.nanoTime();
        time = e - s;
        ar.add(time);
        out.println("\t\t" + time);
        s = System.nanoTime();
        out.print("Selection: " + Arrays.toString(selectionSort(copyArray(a))));
        e = System.nanoTime();
        time = e - s;
        ar.add(time);
        s = System.nanoTime();
        out.println("\t" + time);
        out.print("Shell: " + Arrays.toString(shell(copyArray(a))));
        e = System.nanoTime();
        time = e - s;
        out.println("\t\t" + time);
        s = System.nanoTime();
        out.print("Insertion: " + Arrays.toString(insertion(copyArray(a))));
        e = System.nanoTime();
        time = e - s;
        ar.add(time);
        out.println("\t" + time);
        s = System.nanoTime();
        out.print("Merge: " + Arrays.toString(merge(copyArray(a))));
        e = System.nanoTime();
        time = e - s;
        out.println("\t\t" + time);
        s = System.nanoTime();
        out.println("Quick: " + Arrays.toString(quick(copyArray(a), 0, a.length - 1)) + "\t\t" + time);
        e = System.nanoTime();
        time = e - s;
        ar.add(time);
        out.print("Random: " + Arrays.toString(rand(copyArray(a))));
        out.println("\t\t" + time);
        out.println("\n\n\n\n\n" + Arrays.toString(ar.toArray()));
    }

    private static int[] rand() {
//        Scanner scan = new Scanner(System.in);
//        int a = scan.nextInt();
        int a = 16000;
        int bb[] = new int[a];
        for (int ii = 0; ii < bb.length; ii++) {
            bb[ii] = (int) (Math.random() * 1000);
        }
        return bb;
    }

    private static int[] copyArray(int[] a) {
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    private static int[] selectionSort(int[] b) {
        for (int x = 0; x < b.length - 1; x++) {
            int place = 0;
            int least = Integer.MAX_VALUE;
            for (int y = 0; y + x < b.length; y++) {
                if (b[y + x] < least) {
                    least = b[y + x];
                    place = y + x;
                }
            }
            int swap = b[x];
            b[x] = b[place];
            b[place] = swap;
        }
        return b;
    }

    private static int[] bubbleSort(int[] b) {
        int swap;
        for (int c = 0; c < b.length - 1; c++) {
            for (int d = 0; d + c < b.length - 1; d++) {
                if (b[d] > b[d + 1]) {
                    swap = b[d];
                    b[d] = b[d + 1];
                    b[d + 1] = swap;
                }
            }
        }
        return b;
    }

    private static int[] shell(int[] b) {
        int increment = b.length / 2;
        while (increment > 0) {
            for (int i = increment; i < b.length; i++) {
                int j = i;
                int temp = b[i];
                while (j >= increment && b[j - increment] > temp) {
                    b[j] = b[j - increment];
                    j = j - increment;
                }
                b[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
        return b;
    }

    private static int[] insertion(int[] b) {
        for (int i = 1; i < b.length; i++) {
            int key = b[i];
            int x;
            for (x = i - 1; x >= 0 && (b[x] > key); x--) {
                b[x + 1] = b[x];
            }
            b[x + 1] = key;
        }
        return b;
    }

    public static int[] quick(int b[], int start, int end) {
        int i = start;
        int k = end;
        if (end - start >= 1) // check that there are at least two elements to sort
        {
            int pivot = b[start];
            while (k > i) {
                while (b[i] <= pivot && i <= end && k > i) {
                    //Left
                    i++;
                }
                while (b[k] > pivot && k >= start && k >= i) {
                    // Right
                    k--;
                }
                if (k > i) {
                    swap(b, i, k);
                }
            }
            swap(b, start, k);
            quick(b, start, k - 1); // Quicksort Left
            quick(b, k + 1, end);   // Quicksort Right
        }
        return b;
    }

    public static void swap(int array[], int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static int[] merge(int b[]) {
        for (int x = 0; x < b.length / 2; x++) {
            for (int y = 0; y < b.length / 2; y++) {
                if (b[y] > b[y + 1]) {
                    int d = b[y];
                    b[y] = b[y + 1];
                    b[y + 1] = d;
                }
            }
        }
        return b;
    }

    public static int[] rand(int b[]) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            ar.add(b[i]);
        }
        Collections.shuffle(ar);
        for (int i = 0; i < b.length; i++) {
            b[i] = ar.get(i);
        }
        return b;
    }
}
