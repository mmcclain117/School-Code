
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Rocket Science
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob02.txt"));
        double a = scan.nextDouble();
        System.out.println(a * 28.3495);
    }

}
