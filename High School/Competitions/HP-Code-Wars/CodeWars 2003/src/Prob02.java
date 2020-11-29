
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Compound Interest
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        int cost = scan.nextInt();
        int down = scan.nextInt(); // Down Payment
        double rate = scan.nextDouble();// Anual Rate
        int month = scan.nextInt(); // Number of months
        int L = cost - down; // Loan amount
        double c = (rate / 100) / 12; // Monthly interest rate
        double tot = (L * (c * (1 + c) * month)) / ((1 + c) * (month - 1));
        System.out.printf("Your monthly car payment is $%.2f\n", tot);
//        P = L[c(1 + c)n]/[(1 + c)n - 1]
    }
}
