package Round_609;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_USBFlashDrives {

    /**
     * Tags: Greedy, Implementation, Sorting
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scan.nextInt();
        }
        Arrays.sort(p);
        // Sort
        int sum = 0;
        int numb = 0;
        int i = n - 1;
        while (!(sum >= m)) {
            sum += p[i];
            i--;
            numb++;
        }
        out.println(numb);
    }

}
