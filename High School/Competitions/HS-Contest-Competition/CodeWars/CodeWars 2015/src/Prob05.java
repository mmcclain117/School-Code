
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Distributive Law
//        Difficulty: Easy
//        Subject: Brute Force
        Scanner scan = new Scanner(new File("prob05.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println(a + " x (" + b + " + " + c + ") = " + a + " x " + b + " + " + a + " x " + c);
        System.out.println(a + " x " + (b + c) + " = " + (a * b) + " + " + (a * c));
        System.out.println((a * (b + c)) + " = " + ((a * b) + (a * c)));
    }
}
