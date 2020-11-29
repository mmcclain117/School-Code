
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Year of Astronomy
//        Dificulty: Very easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob01.txt"));
        int fo = scan.nextInt(); // Focal Length of Object
        int d = scan.nextInt(); // Diameter
        int fe = scan.nextInt(); // Focal Length of eyepiece
        double f = (double) fo / d;
        double p = fe / f;
        System.out.println(f);
        System.out.println(p);
    }
}
