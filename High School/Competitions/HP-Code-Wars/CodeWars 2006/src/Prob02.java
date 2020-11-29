
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Sales Tax
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        double t = scan.nextDouble();
        double cost = scan.nextDouble();
        double tax = t / 100;
        tax *= cost;
        System.out.println("Your sales tax is: $" + tax);
        System.out.println("The total cost of the item (including sales tax) is: $" + (tax + cost));
    }

}
