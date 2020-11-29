
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Kyle Fromm
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));
        String name = scan.nextLine();
        System.out.println("Salutations, " + name + "! We are the Epic Failures from Heritage High School!");
    }
}
