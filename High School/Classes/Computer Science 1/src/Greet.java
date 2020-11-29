
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 *
 * @author Master
 */
public class Greet {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));
        out.println("Greetings, " + scan.nextLine() + " the Great! I genuflect in your general direction!");
    }

}
