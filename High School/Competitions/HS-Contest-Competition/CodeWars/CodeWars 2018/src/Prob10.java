
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: The Cover Up
//        Points: 6
        Scanner scan = new Scanner(new File("prob10.txt"));
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int top = (int) Math.sqrt(scan.nextInt()); // Top
            int height = scan.nextInt(); // Height
            int sum = 0;
            for (int j = top; j < top + height; j++) {
                if (j == top) {
                    sum += j * j;
                } else {
                    sum += (j - 2) * 2 + 3;
                }
                if (j == 1) {
                    sum += 4;
                } else {
                    sum += 4 * j;
                }
            }
            System.out.println(sum + " liters");
        }
    }
}
