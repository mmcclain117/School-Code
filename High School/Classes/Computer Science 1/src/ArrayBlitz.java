
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ArrayBlitz {

    private int[] array;

    /*	Create a ArrayBlitz object
     *  Calls all the methods to test the results
     */
    public static void main(String args[]) throws Exception {
        ArrayBlitz ab = new ArrayBlitz();
        Write1();
        Write2();
        Write2();
        ab.readInDataFile("arraydata1.dat");
        System.out.println("Array: \t\t" + Arrays.toString(ab.array));
        System.out.println("Sum: \t\t" + ab.sum());
        System.out.println("Average: \t" + ab.average());
        System.out.println("Max: \t\t" + ab.max());
        System.out.println("Min: \t\t" + ab.min());
        System.out.println("Ascending: \t" + ab.isAscending());
        System.out.println("Descending:\t" + ab.isDescending());
        System.out.println("Above 10: \t" + ab.aboveThreshold(10));
        System.out.println("Below 10: \t" + ab.belowThreshold(10));
    }

    public static void Write1() throws Exception {
        FileWriter fw = new FileWriter("arraydata1.dat");
        fw.write("15\n"
                + "14\n"
                + "11\n"
                + "9\n"
                + "7\n"
                + "15\n"
                + "13\n"
                + "12\n"
                + "11\n"
                + "10\n"
                + "8\n"
                + "19\n"
                + "13\n"
                + "18\n"
                + "16\n"
                + "14");
        fw.flush();
        fw.close();
    }

    public static void Write2() throws Exception {
        FileWriter fw = new FileWriter("arraydata1.dat");
        fw.write("15\n"
                + "1\n"
                + "2\n"
                + "3\n"
                + "4\n"
                + "5\n"
                + "6\n"
                + "7\n"
                + "8\n"
                + "9\n"
                + "10\n"
                + "11\n"
                + "12\n"
                + "13\n"
                + "14\n"
                + "15");
        fw.flush();
        fw.close();
    }

    public static void Write3() throws Exception {
        FileWriter fw = new FileWriter("arraydata1.dat");
        fw.write("15\n"
                + "15\n"
                + "14\n"
                + "13\n"
                + "12\n"
                + "11\n"
                + "10\n"
                + "9\n"
                + "8\n"
                + "7\n"
                + "6\n"
                + "5\n"
                + "4\n"
                + "3\n"
                + "2\n"
                + "1");
        fw.flush();
        fw.close();
    }

    /*  Reads a data file and fill the array with data
     *  Initializes and fills array
     *  The first integer in the datafile is the size of the array.
     */
    public void readInDataFile(String fileName) throws Exception {
        Scanner scan = new Scanner(fileName);
        int a = scan.nextInt();
        for (int b = 0; b < array.length; b++) {
            array[b] = a;
            a = scan.nextInt();
        }
    }

    /*
     *  Returns the array
     */
    public int[] getArray() {
        return array;
    }

    /*
     *  Calculates and returns the sum of the array elements
     */
    public int sum() {
        int sum = 0;
        for (int b = 0; b < array.length; b++) {
            sum += array[b];
        }
        return sum;
    }

    /*
     * Calculates and returns the average of the array elements as a double
     */
    public double average() {
        int sum = 0;
        int ave = 0;
        for (int b = 0; b < array.length; b++) {
            sum += array[b];
        }
        ave = sum / array.length;
        return ave;
    }

    /*
     * Returns the largest value in the array
     */
    public int max() {
        int max = array[0];
        for (int b = 0; b < array.length; b++) {
            if (max < array[b]) {
                max = array[b];
            }
        }
        return max;
    }

    /*
     *  Returns the smallest value in the array
     *
     */
    public int min() {
        int min = 0;
        for (int b = 0; b < array.length; b++) {
            if (min > array[b]) {
                min = array[b];
            }
        }
        return min;
    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isAscending() {
        boolean x = false;
        for (int b = 0; b < array.length - 1; b++) {
            if (array[b] > array[b + 1]) {
                x = true;
            } else {
                x = false;
                break;
            }
        }
        return x;
    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isDescending() {
        boolean x = false;
        for (int b = 0; b < array.length - 1; b++) {
            if (array[b] < array[b + 1]) {
                x = true;
            } else {
                x = false;
                break;
            }
        }
        return x;
    }

    /*
     *  Returns an array of the all the values in the array above a threshold
     */
    public int[] aboveThreshold(int thresh) {
        int num[] = null;
        int x = 0;
        for (int b = 0; b < array.length - 1; b++) {
            if (array[b] > 10) {
                array[b] = num[x];
                x++;
            }

        }
        return num;
    }

    /*
     *  Returns an array of the all the values in the array below a threshold
     */
    public int[] belowThreshold(int thresh) {
        int num[] = null;
        thresh = 0;
        for (int b = 0; b < array.length - 1; b++) {
            if (array[b] < 10) {
                array[b] = num[thresh];
                thresh++;
            }
        }
        return num;
    }
}
