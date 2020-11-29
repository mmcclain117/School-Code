
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Stellar Classification
//        Difficulty: Very Easy
//        Subject: Math, Switch
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.next();
        while (!"END".equals(a)) {
            double b = scan.nextDouble();
            double c = scan.nextDouble();
            double bv = b - c;
            System.out.print(a + " ");
            System.out.printf("%.2f ", bv);
            if (bv < -.251) {
                System.out.println("O");
            } else if (bv < -.001) {
                System.out.println("B");
            } else if (bv < .249) {
                System.out.println("A");
            } else if (bv < .499) {
                System.out.println("F");
            } else if (bv < .999) {
                System.out.println("G");
            } else if (bv < 1.499) {
                System.out.println("K");
            } else {
                System.out.println("M");
            }
            a = scan.next();
        }
    }
}