
import java.io.File;
import static java.lang.Math.PI;
import static java.lang.Math.tan;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Height of a Rainbow
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        int d = scan.nextInt(); // Distance
        double height = tan(42.3333333333333333 * PI / 180) * d; // Height of rainbow
        System.out.printf("The height of the rainbow is %.4f meters.\n", height);
    }
}
