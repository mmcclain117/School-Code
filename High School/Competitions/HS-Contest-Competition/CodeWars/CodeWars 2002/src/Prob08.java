
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: What's Your Average?
//        Points: 7
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt(); // Number of Homework
        int b = scan.nextInt(); // Number of Test
        System.out.println("Averages");
        scan.nextLine();
        while (scan.hasNext()) {
            String line = scan.nextLine(); // Everything for one person
            String split[] = line.split("[ ]+"); // Seperates Everything
            String name = split[0];
            int con = 1;
            while (true) {
                if (split[con].equals("H")) {
                    con++;
                    break;
                } else {
                    name += " " + split[con];
                    con++;
                }
            }
            int hsum = 0; // Homework Sum
            int min = 100; // Dropping lowest
            while (true) {
                if (split[con].equals("T")) {
                    con++;
                    break;
                } else {
                    int tmp = Integer.parseInt(split[con]);
                    if (tmp < min) {
                        min = tmp;
                    }
                    hsum += tmp;
                    con++;
                }
            }
            int tsum = 0; // Test Sum
            while (con < split.length) {
                tsum += Integer.parseInt(split[con]);
                con++;
            }
            double sum = calSum(hsum - min, a - 1, tsum, b);
            System.out.printf("%s %.1f\n", name, sum);
        }
    }

    private static double calSum(int a, int b, int c, int d) {
        double sum = 0.0;
        sum = ((double) a / b) * .4; // Homeworks
        sum += ((double) c / d) * .6; // Test
        return sum;
    }
}
