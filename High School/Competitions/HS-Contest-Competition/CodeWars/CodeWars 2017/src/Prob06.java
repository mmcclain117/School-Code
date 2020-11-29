
import java.util.*;
import java.io.*;

/**
 *
 * @author Ryan Talbot and Master
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int l = scan.nextInt();
            int arr[] = new int[l];

            for (int x = 0; x < l; x++) {
                arr[x] = scan.nextInt();
            }

            int delta[] = new int[l - 1];

            for (int x = 0; x < l - 1; x++) {
                delta[x] = -1 * (arr[x + 1] - arr[x]);
            }
//	    System.out.println(Arrays.toString(delta));
            int te = arr[0];
            System.out.print(te + " ");
            for (int x = 0; x < l - 1; x++) {
                System.out.print(te + delta[x] + " ");
                te += delta[x];
//		System.out.println(delta[x]);
            }
            System.out.println();
        }
    }

}
