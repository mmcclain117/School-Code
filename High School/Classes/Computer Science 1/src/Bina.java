
import java.util.Arrays;

/**
 *
 * @author Master
 */
public class Bina {

    public static void main(String[] args) {
        double myArray[] = {189.01, 2000, -32, 56, 182, 2, 2};
        Arrays.sort(myArray);
        double d = 2000;
        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.binarySearch(myArray, d));
    }

}
