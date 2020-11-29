
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Making Waves
//        Points: 6
        Scanner scan = new Scanner(new File("prob05.txt"));
        String line = scan.nextLine(); // Input lines
        int length = line.length(); // Length of input
        int levels[] = new int[length];
        int cur = 0; // Current level
        int max = 0; // Max Level
        int min = 0; // Minimum Level
        char prev = line.charAt(0);

        for (int i = 1; i < length; i++) {
            char next = line.charAt(i);
            cur += next < prev ? -1 : 1;
            prev = next;
            levels[i] = cur;
            if (cur > max) {
                max = cur;
            } else if (cur < min) {
                min = cur;
            }
        }
        /* Prints it out */
        for (int l = max; l >= min; l--) {
            for (int i = 0; i < length; i++) {
                if (l == levels[i]) {
                    System.out.print(line.charAt(i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
