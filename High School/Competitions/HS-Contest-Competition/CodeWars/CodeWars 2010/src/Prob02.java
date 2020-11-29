
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: My Dear Friend VIR
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob02.txt"));
        double v = scan.nextDouble();
        double i = scan.nextDouble();
        System.out.printf("%.4f\n", v / i * 1000);
    }

}
