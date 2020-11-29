package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* So screwed and don't know where screwed up */
public class Prob05 {

    static int packs[] = {13, 11, 6, 0};
    static int counts[] = {0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
//        Problem: Peter's Peppers
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        int n = scan.nextInt(); // Number of peppers
        int lef = n % 13; // Number left
        int a1 = n / 13; // Number of 13 peppers 
        int a2 = 0; // Number of 11 pepper
        int a3 = 0; // Number of 6 peppers
        System.out.println(a1 + " package of 13");
        System.out.println(lef);
//        pick(0, n, 0);
        int count[] = {0, 0, 0};
        while (lef > 0) {
            if (lef > 13) {
                count[0]++;
                lef -= 13;
            } else if (lef > 11) {
                count[1]++;
                lef -= 11;
            } else if (lef > 6) {
                count[2]++;
                lef -= 6;
            } else {
                if (count[0] > 0) {
                    lef += 13;
                    count[0]--;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(count));
    }

    private static void pick(int t, int r, int l) {
        int i, s;
        System.out.println(Arrays.toString(packs));
        System.out.println(Arrays.toString(counts));
        System.out.println(r);
        if (r == 0) {
            System.out.println("Peppers packed in ");
            for (i = s = 0; i < packs.length; i++) {
                if (true) {
                    System.out.println(counts[i] + " pacakges ");
                } else {
                    s += counts[i];
                }
            }
            System.out.println(s + " total pacages");
        } else {
            if (r >= packs[l]) {
                counts[l]++;
                pick(t, r - packs[l], l);
                counts[l]--;
//            } else if (packs.length > l) {
//            if (packs[l + 1]) {
                pick(t, r, l + 1);
            }
        }
    }
}
