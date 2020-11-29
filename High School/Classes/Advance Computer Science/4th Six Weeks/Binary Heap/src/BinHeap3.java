
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BinHeap3 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a.txt"));
        String a = scan.nextLine();
        String b[] = a.split("\\s+");
        /**
         * Building Min-Heap
         */
        BH bh = new BH();
        int min[] = new int[b.length + 1];
        for (int i = 0; i < min.length - 1; i++) {
            min[i + 1] = Integer.parseInt(b[i]);
//            bh.add(min[i + 1]);
            bh.add(min[i + 1]);
            int te = i;
            int sq = (te) / 2;
            if (te % 2 == 1) {
                sq++;
            }
            while (min[te + 1] < min[sq]) {
                int tem = min[sq];
                min[sq] = min[te + 1];
                min[te + 1] = tem;
                te /= 2;
                sq = te / 2;
                if (te % 2 == 1) {
                    sq++;
                }
            }
        }
        System.out.println(Arrays.toString(bh.getMin()));
        System.out.println("MIN: " + Arrays.toString(min));
        int mm[] = new int[min.length - 1];
        for (int i = 0; i < min.length - 1; i++) {
            mm[i] = min[i + 1];
        }
//        min = mm;
        min[0] = (int) Double.NaN;
        /**
         * Removing Min-heap Root
         */
        /*
        int c = min.length - 1;
        while (min[c] == 0) { // Finds last element
            c--;
        }
        while (c > 0) {
//        for (int ii = 0; ii < 5; ii++) {
            System.out.println(min[1]);
            min[1] = min[c]; // replaces last
            System.out.println(min[c]);
            min[c] = 0; // Clears last                                  
            System.out.println("Before Replacing: " + Arrays.toString(min));
            siftdown(min, 0);
            System.out.println("MIN DELETE: " + Arrays.toString(min));
            c = last(min);
        }
         */
    }

    private static boolean isEmpty(int[] min) {
        int d = min.length - 1;
        while (d > 0) {
            if (min[d] == 0) {
                d--;
            } else {
                return true;
            }
        }
        return false;
    }

    private static int[] ch(int[] min, int i) {
        while (true) {
            try {
                if (min[i] > min[(2 * i) + 1]) { // Checks right
//                    System.out.println(min[i] + " checked");
                    int te = min[i];
                    min[i] = min[(2 * i) + 1];
                    i = (2 * i) + 1; // Change to new spot
                    min[i] = te;
                } else if (min[i] > min[2 * i]) { // Checks Left
//                    System.out.println(min[i] + " checked");
                    int te = min[i];
                    min[i] = min[2 * i];
                    i = 2 * i; // Change to new spot
                    min[i] = te;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return min;
    }

    private static int last(int min[]) {
        int c = min.length - 1;
        while (min[c] == 0 && c > 0) { // Finds last element
            c--;
        }
        return c;
    }

    private static int[] ch2(int[] min, int i) {
        boolean go = true;
        while (go) {
            try {
                int m2 = min[(2 * i) + 1]; // Right
                int m3 = min[(2 * i)]; // Left
                if (m2 < m3) {
                    if (min[i] > m2) { // Checks right
                        int te = min[i];
                        min[i] = m2;
                        i = (2 * i) + 1; // Change to new spot
                        min[i] = te;
                    } else {
                        go = false;
                    }
                } else if (min[i] > m3) { // Checks Left
                    int te = min[i];
                    min[i] = m3;
                    i = 2 * i; // Change to new spot
                    min[i] = te;
                } else {
                    go = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return min;
    }

    private static int[] siftdown(int[] min, int k) {
        int lci = 2 * k + 1;
        int rci = 2 * k + 2;
        k++;
        int minI = 1;
        int tmp;
        if (rci >= min.length) {
            if (lci >= min.length) {
                return min;
            } else {
                minI = lci;
            }
        } else if (min[lci] < min[rci]) {
            minI = lci;
        } else {
            minI = rci;
        }
        System.out.println(min[k] + " " + min[minI]);
        if (min[k] > min[minI]) {
            tmp = min[minI];
            min[minI] = min[k];
            min[k] = tmp;
            System.out.println(Arrays.toString(min));
            siftdown(min, minI);
        }
        return min;
    }

}
