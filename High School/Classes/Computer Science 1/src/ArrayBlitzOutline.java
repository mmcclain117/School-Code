
/**
 * @(#)ArraysForEveryone.java
 *
 *
 * @author Mrs. Peterson
 * @version 1.00 2015/1/22
 */
public class ArrayBlitzOutline {

    private int[] array;

    /*	Create a ArrayBlitz object
     *  Calls all the methods to test the results
     */
    public static void main(String args[]) throws Exception {
        ArrayBlitz ab = new ArrayBlitz();

        ab.readInDataFile("arraydata1.dat");

        System.out.println("Array: \t\t");
        System.out.println("Sum: \t\t");
        System.out.println("Average: \t");
        System.out.println("Max: \t\t");
        System.out.println("Min: \t\t");
        System.out.println("Ascending: \t");
        System.out.println("Descending:\t");
        System.out.println("Above 10: \t");
        System.out.println("Below 10: \t");

    }

    /*  Reads a data file and fill the array with data
     *  Initializes and fills array
     *  The first integer in the datafile is the size of the array.
     */
    public void readInDataFile(String fileName) {

    }

    /*
     *  Returns the array
     */
    public int[] getArray() {
        return null;

    }

    /*
     *  Calculates and returns the sum of the array elements
     */
    public int sum() {
        return 0;

    }

    /*
     * Calculates and returns the average of the array elements as a double
     */
    public double average() {
        return 0;

    }

    /*
     * Returns the largest value in the array
     */
    public int max() {
        return 0;

    }

    /*
     *  Returns the smallest value in the array
     *
     */
    public int min() {
        return 0;

    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isAscending() {
        return false;

    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isDescending() {
        return false;

    }

    /*
     *  Returns an array of the all the values in the array above a threshold
     */
    public int[] aboveThreshold(int thresh) {
        return null;

    }


    /*
     *  Returns an array of the all the values in the array below a threshold
     */
    public int[] belowThreshold(int thresh) {
        return null;

    }

}
