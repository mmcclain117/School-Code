
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Weight Calculator
//        Difficulty: Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob03.txt"));
        String a = scan.nextLine();
        String b[] = a.split("\\s");
        while (!"END 0 0 0".equals(a.trim())) {
            String n = b[0]; // Name
            double w = Double.parseDouble(b[1]); // Weight
            String p = b[2]; // Planet
            double r = Double.parseDouble(b[3]); // Ratio
            System.out.println("On " + p + ", " + n + " would weigh " + (w * r) + " pounds.");
            a = scan.nextLine();
            b = a.split("\\s");
        }
    }
}
