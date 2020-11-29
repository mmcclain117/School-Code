
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Dirt Yard
//        Points: 3
        Scanner scan = new Scanner(new File("prob06.txt"));
        int length = scan.nextInt();
        int width = scan.nextInt();
        int depth = scan.nextInt();
        double x = (double) length * width * depth;
        System.out.println((int) Math.ceil(Math.cbrt((x / 3))));
    }

}
