
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int values[] = new int[100];
    public static int searchValue = (int) (Math.random() * 100);
    public static int low = 0;
    public static int high = 99;
    public static int midpoint = 49;

    public static void main(String[] args) {
        fillarray();
        runSearch();
    }

    private static void fillarray() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            values[i] = rnd.nextInt(100);
        }
        Arrays.sort(values);
    }

    private static void runSearch() {
        int count = 1;
        out.println("Searching for " + searchValue);
        while (true) {
            out.println("Iteration #" + count);
            midpoint = (low + high) / 2;
            out.println("Low: Index " + low + ", values " + values[low]);
            out.println("High: Index " + high + ", values " + values[high]);
            out.println("Midpoint: Index " + midpoint + ", values " + values[midpoint]);
            if (values[midpoint] == searchValue) {
                out.println(searchValue + " was found at " + midpoint);
                break;
            }
            if (high == low || high == midpoint || low == midpoint) {
                out.println("Nothing Found");
                break;
            }
            if (searchValue < values[midpoint]) {
                high = midpoint;
            } else if (searchValue > values[midpoint]) {
                low = midpoint;
            }
            count++;
        }
    }
}
