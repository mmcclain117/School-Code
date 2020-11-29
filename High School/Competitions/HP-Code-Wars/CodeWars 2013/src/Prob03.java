
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Weight Calculator
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        String line = scan.nextLine();
        String b[] = line.split("\\s");
        while (!"END 0 0 0".equals(line.trim())) {
            String n = b[0]; // Name
            double w = Double.parseDouble(b[1]); // Weight
            String p = b[2]; // Planet
            double r = Double.parseDouble(b[3]); // Ratio
            System.out.println("On " + p + ", " + n + " would weigh " + (w * r) + " pounds.");
            line = scan.nextLine();
            b = line.split("\\s");
        }
    }
}
