package Round_44;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;

public class C_Holidays {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Number of days in berland holidays
        int m = scan.nextInt(); // Number of people in charge of the watering
        int d[] = new int[n]; // Days
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            while (a < b) {
                d[a]++;
                a++;
            }
        }
        int con = 0;
        boolean wo = true;
        while (con < d.length && wo) {
            if (d[con] != 1) {
                System.out.println(con + " " + d[con]);
                wo = false;
            }
            con++;
        }
        if (wo) {
            System.out.println("OK");
        }
    }
}
