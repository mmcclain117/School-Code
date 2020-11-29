
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Couldn't test but wrote to the best of my abilities */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Benford's Law
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        System.out.println("Benford's Law Frequencies");
        int counts[] = new int[10];
        String n = scan.nextLine();
        double sum = 0;
        while (!"0".equals(n)) {
            sum++;
            counts[Integer.parseInt(n.substring(0, 1))]++;
            n = scan.nextLine();
        }
        System.out.println("Population includes " + (int) sum + " numbers.");
        System.out.println("Numeral   Sightings   Freq.");
        for (int i = 1; i < 10; i++) {
            System.out.printf("   %d\t\t%d\t%.0f%s\n", i, counts[i], (counts[i] / sum) * 100, "%");
        }

    }

}
