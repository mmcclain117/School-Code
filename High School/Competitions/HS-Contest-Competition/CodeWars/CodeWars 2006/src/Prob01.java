
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));
        System.out.println("Hello, " + scan.nextLine() + "!");
    }

}
