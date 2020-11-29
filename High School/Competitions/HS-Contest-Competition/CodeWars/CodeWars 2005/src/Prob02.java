
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob02.txt"));
        System.out.println((scan.nextDouble() * 2.25 + 32) + " degrees Fahrenheit");
    }
}
