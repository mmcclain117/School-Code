
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Dirt Yard
//        Difficulty: Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob06.txt"));
        int l = scan.nextInt();
        int w = scan.nextInt();
        int d = scan.nextInt();
        double x = (double) l * w * d;
        System.out.println((int) Math.ceil(Math.cbrt((x / 3))));
    }

}
