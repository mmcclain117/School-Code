
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward (Frequency Histogram)
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        String s = "";
        while (scan.hasNextLine()) {
            s += scan.nextLine();
        }
        char ch[] = s.replaceAll("[^A-Z]+", "").toCharArray();
        int count[] = new int[26];
        int max = 0; // Max height
        for (char c : ch) {
            count[c - 65]++;
            if (count[c - 65] > 35) { // Setting cap
                count[c - 65] = 35;
            }
            if (count[c - 65] > max) {
                max = count[c - 65];
            }
        }
        for (int i = 0; i < max; i++) {
            for (int o = 0; o < 26; o++) {
                if (count[o] >= max - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            /* Goes down a row */
            System.out.println();
        }
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (65 + i));
        }
        System.out.println();
    }
}
