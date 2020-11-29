
import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Not 100% right as using random but is the same Concept */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Random Number Generator Analysis
//        Points: 3
        Scanner scan = new Scanner(new File("prob05.txt"));
        while (scan.hasNext()) {
            int n = scan.nextInt();
            System.out.println("Random number range is 0-" + n + "(n=" + n + ")");
            int max = 20000 * (n + 1);
            Random r = new Random(n);
            int counts[] = new int[n + 1]; // Frequence of random numbers
            /* Populates max number of ints to count */
            for (int i = 0; i < max; i++) {
                counts[r.nextInt(n + 1)]++;
            }
            int sum = 0;
            /* Prints out frequencies */
            for (int i = 0; i < n + 1; i++) {
                System.out.println(i + " = " + counts[i]);
                sum += counts[i];
            }
            System.out.println("Total = " + sum);
        }
    }
}
