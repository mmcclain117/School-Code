
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: My Dear Friend VIR
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        double voltage = scan.nextDouble();
        double ohm = scan.nextDouble();
        System.out.printf("%.4f\n", voltage / ohm * 1000);
    }

}
