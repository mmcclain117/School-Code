
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));
        System.out.println("Hey how you doing " + scan.nextLine() + "?");
        System.out.println("We are Athens High School Lions: Batman, Joker, and Venom");
    }
}
