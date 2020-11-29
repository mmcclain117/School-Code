

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Job Processing
//        Points: 11
        Scanner scan = new Scanner(new File("prob11.txt"));
        int tat = 0; // Task a Time
        int tbt = 0; // Task b Time
        int n = scan.nextInt(); // Number of Input Containers
        int inter = 0; // Number of Intermediate Containers
        int an = scan.nextInt(); // Number of A Machines
        int fina[] = new int[an]; // Permanant Times
        int ta[] = new int[an]; // Temperary Times
        for (int i = 0; i < an; i++) { // Scan in A Machine Times
            int tmp = scan.nextInt();
            fina[i] = tmp;
            ta[i] = tmp;
        }
//        Scan in A times
        int bn = scan.nextInt(); // Number of B Machines
        int finb[] = new int[bn]; // Permanant Times
        int tb[] = new int[bn]; // Temperary Times
        for (int i = 0; i < bn; i++) { // Scan in B Machine Times
            int tmp = scan.nextInt();
            finb[i] = tmp;
            tb[i] = tmp;
        }
        /* Sort Times for Fastest Time */
        Arrays.sort(fina);
        Arrays.sort(finb);
        Arrays.sort(finb);
        Arrays.sort(tb);
        while ((inter > 0 || n > 0)) {
            if (n > 0) { // Have Work for the A Machines
                /* Find any zeros and replace */
                for (int i = 0; i < an; i++) {
                    if (ta[i] == 0) {
                        n--;
                        inter++;
                        ta[i] = fina[i];
                    }
                }
                /* Do a motion through all machines */
                for (int i = 0; i < an; i++) {
                    ta[i]--;
                }
                tat++; // Increment total time
            }
            if (inter > 0) { // Have queue to do For B Machines
                /* Find any zeros and replace */
                for (int i = 0; i < bn; i++) {
                    if (tb[i] == 0) {
                        inter--;
                        tb[i] = finb[i];
                    }
                }
                /* Do a motion through all machines */
                for (int i = 0; i < bn; i++) {
                    tb[i]--;
                }
                tbt++; // Increment B Machine Time
            }
//            System.out.println(inter + " " + n);
        }
        System.out.println("Minimum time to complete subtask A: " + (tat + n));
        System.out.println("Minimum time to complete subtask B: " + (tbt + inter));
    }
}
