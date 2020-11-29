
import java.util.*;
import java.io.*;

/**
 *
 * @author Cody Chang
 */
public class ArrayListBlitz {

    private ArrayList arrayList;

    public static void main(String args[]) throws Exception {
        ArrayListBlitz ab = new ArrayListBlitz();

        ab.readInDataFile("arraydata1.dat");
        System.out.println("Array: \t\t" + ab.getArrayList().toString());
        System.out.println("Sum: \t\t" + ab.sum());
        System.out.println("Average: \t" + ab.average());
        System.out.println("Max: \t\t" + ab.max());
        System.out.println("Min: \t\t" + ab.min());
        System.out.println("Ascending: \t" + ab.isAscending());
        System.out.println("Descending:\t" + ab.isDescending());
        System.out.println("Above 10: \t" + ab.aboveThreshold(10).toString());
        System.out.println("Below 10: \t" + ab.belowThreshold(10).toString());

    }

    public void readInDataFile(String fileName) throws Exception {
        try {
            Scanner file = new Scanner(new File(fileName));
            int number = file.nextInt();
            arrayList = new ArrayList<>();
            while (file.hasNext()) {
                arrayList.add(file.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file.");
        }

    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    /*
     *  Calculates and returns the sum of the array elements
     */
    public int sum() {
        int sum = 0;

        for (Object arrayList1 : arrayList) {
            sum += (int) arrayList1;
        }

        return sum;
    }

    /*
     * Calculates and returns the average of the array elements as a double
     */
    public double average() {

        return (double) sum() / arrayList.size();
    }

    /*
     * Returns the largest value in the array
     */
    public int max() {

        int max = (int) arrayList.get(0);

        for (int i = 0; i < arrayList.size(); i++) {

            if ((int) arrayList.get(i) > max) {
                max = (int) arrayList.get(i);
            }
        }

        return max;
    }

    /*
     *  Returns the smallest value in the array
     *
     */
    public int min() {
        int min = (int) arrayList.get(0);
        for (Object arrayList1 : arrayList) {
            if ((int) arrayList1 < min) {
                min = (int) arrayList1;
            }
        }

        return min;
    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isAscending() {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((int) arrayList.get(i) > (int) arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Returns true if all the elements are in ascending order.
     * Duplicate values are allowed in ascending order.
     */
    public boolean isDescending() {
        for (int i = 0; i < arrayList.size(); i++) {

            if ((int) arrayList.get(i) < (int) arrayList.get(i + 1)) {
                return false;
            }

        }
        return true;
    }

    /*
     *  Returns an array of the all the values in the array above a threshold
     */
    public ArrayList<Integer> aboveThreshold(int thresh) {
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if ((int) arrayList.get(i) > thresh) {
                newArray.add((int) arrayList.get(i));
            }
        }
        return newArray;
    }

    /*
     *  Returns an array of the all the values in the array below a threshold
     */
    public ArrayList<Integer> belowThreshold(int thresh) {
        ArrayList<Integer> newArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if ((int) arrayList.get(i) < thresh) {
                newArray.add((int) arrayList.get(i));
            }
        }
        return newArray;
    }

}
