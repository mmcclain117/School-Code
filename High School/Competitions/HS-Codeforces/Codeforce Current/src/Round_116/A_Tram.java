package Round_116;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;

public class A_Tram {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Number of Stops
        int curCap = 0;
        int maxCap = 0;
        int a = 0;// Number Exit
        int b = 0;// Number Enter
        for (int i = 0; i < n; i++) {
            a = scan.nextInt();
            b = scan.nextInt();
            curCap -= a;
            curCap += b;
            if (curCap > maxCap) {
                maxCap = curCap;
            }
        }
        System.out.println(maxCap);
    }
}
