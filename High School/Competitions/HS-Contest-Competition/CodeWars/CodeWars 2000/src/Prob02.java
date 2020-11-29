
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob02.txt"));
        double b = scan.nextDouble();
        double h = scan.nextDouble();
        while (!(b == 0 && h == 0)) {
            double area = .5 * b * h;
            System.out.printf("The area of the triangle is %.4f\n", area);
            b = scan.nextDouble();
            h = scan.nextDouble();
        }
    }
}
