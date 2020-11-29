
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BinHeap2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a.txt"));
        String a = scan.nextLine();
        String b[] = a.split("\\s+");
        /**
         * Building Min-Heap
         */
        int min[] = new int[b.length + 1];
        for (int i = 0; i < min.length - 1; i++) {
            min[i + 1] = Integer.parseInt(b[i]);
            int te = i;
            int sq = (te) / 2;
            if (te % 2 == 1) {
                sq++;
            }
            while (min[te + 1] < min[sq]) {
//                System.out.println("Before " + Arrays.toString(min));
//                System.out.println(min[te + 1] + " switched " + min[sq]);
                int tem = min[sq];
                min[sq] = min[te + 1];
                min[te + 1] = tem;
//                System.out.println("Switched " + Arrays.toString(min));
                te /= 2;
                sq = te / 2;
                if (te % 2 == 1) {
                    sq++;
                }
            }
//            System.out.println();
        }
        System.out.println("MIN: " + Arrays.toString(min));
        /**
         * Removing Min-heap Root
         */
        int c = min.length - 1;
        while (min[c] == 0) { // Finds last element
            c--;
//            System.out.println(min[c]);
        }
//        System.out.println(c);
//        while (isEmpty(min)) {
//        while (isEmpty(min)) {
        for (int ii = 0; ii < 5; ii++) {
            System.out.println(min[1]);
            min[1] = min[c]; // replaces last
            System.out.println(min[c]);
            min[c] = 0; // Clears last
            System.out.println("Before Replacing: " + Arrays.toString(min));
//            min = ch1(min, 1);
//            min = ch(min, 1);
//            min = ch2(min, 1);
            siftdown(min, 0);

            System.out.println("MIN DELETE: " + Arrays.toString(min));
//            c--;
            c = last(min);
        }
        /**
         * Building Max-heap
         */
        int max[] = new int[b.length + 1];
        max[0] = Integer.MAX_VALUE;
        for (int i = 0; i < max.length - 1; i++) {
            max[i + 1] = Integer.parseInt(b[i]);
            int te = i;
            int sq = (te) / 2;
            if (te % 2 == 1) {
                sq++;
            }
            while (max[te + 1] > max[sq]) {
//                System.out.println("Before " + Arrays.toString(max));
//                System.out.println(max[te + 1] + " switched " + max[sq]);
                int tem = max[sq];
                max[sq] = max[te + 1];
                max[te + 1] = tem;
//                System.out.println("Switched " + Arrays.toString(max));
                te /= 2;
                sq = te / 2;
                if (te % 2 == 1) {
                    sq++;
                }
            }
//            System.out.println();
        }
        max[0] = 0;
        System.out.println(Arrays.toString(max));
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
//                System.out.println("Check " + i);
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

    private static int[] ch1(int min[], int i) {
        while (true) {
            try {
                if (min[2 * i] < min[(2 * i) + 1]) {
                    if (min[i] > min[(2 * i) + 1]) { // Checks right
                        System.out.println(min[i] + " checked");
                        int te = min[i];
                        min[i] = min[2 * i + 1];
                        i = (2 * i) + 1; // Change to new spot
                        min[i] = te;
                    } else {
                        break;
                    }
                } else if (min[i] > min[2 * i]) { // Checks Left
                    System.out.println(min[i] + " checked");
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
        while (min[c] == 0) { // Finds last element
            c--;
//            System.out.println(min[c]);
        }
        return c;
    }

    private static int[] ch2(int[] min, int i) {
        boolean go = true;
        while (go) {
            try {
//                System.out.println("Check " + i);
                int m2 = min[(2 * i) + 1]; // Right
                int m3 = min[(2 * i)]; // Left
                if (m2 < m3) {
                    if (min[i] > m2) { // Checks right
//                    System.out.println(min[i] + " checked");
                        int te = min[i];
                        min[i] = m2;
                        i = (2 * i) + 1; // Change to new spot
                        min[i] = te;
                    } else {
                        go = false;
                    }
                } else {
                    if (min[i] > m3) { // Checks Left
//                    System.out.println(min[i] + " checked");
                        int te = min[i];
                        min[i] = m3;
                        i = 2 * i; // Change to new spot
                        min[i] = te;
                    } else {
                        go = false;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return min;
    }

    /*
     public void removeMin() {
     data[0] = data[heapSize - 1];
     heapSize--;
     if (heapSize > 0) {
     siftDown(0);
     }
     }

     private void siftDown(int nodeIndex) {
     int data[] = new int[10];
     int leftChildIndex, rightChildIndex, minIndex, tmp;
     leftChildIndex = getLeftChildIndex(nodeIndex);
     rightChildIndex = getRightChildIndex(nodeIndex);
     if (rightChildIndex >= heapSize) {
     if (leftChildIndex >= heapSize) {
     return;
     } else {
     minIndex = leftChildIndex;
     }
     } else {
     if (data[leftChildIndex] <= data[rightChildIndex]) {
     minIndex = leftChildIndex;
     } else {
     minIndex = rightChildIndex;
     }
     }
     if (data[nodeIndex] > data[minIndex]) {
     tmp = data[minIndex];
     data[minIndex] = data[nodeIndex];
     data[nodeIndex] = tmp;
     siftDown(minIndex);
     }
     }*/
    private static int[] siftdown(int[] min, int k) {
        int lci = 2 * k + 0;
        int rci = 2 * k + 1;
        int minI;
        int tmp;
        if (rci >= min.length) {
            if (lci >= min.length) {
                return min;
            } else {
                minI = lci;
            }
        } else {
            if (min[lci] < min[rci]) {
                minI = lci;
            } else {
                minI = rci;
            }
        }
        if (min[k] > min[minI]) {
            tmp = min[minI];
            min[minI] = min[k];
            min[k] = tmp;
            siftdown(min, minI);
        }
        return min;
    }

}
