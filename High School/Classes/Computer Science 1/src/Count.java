
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Count {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.print("Type in a sentence and press ENTER. ");
        String as = "exit";
        String sa = "sa+";
        String b = scan.nextLine();
        while (!b.contains(as)) {
            String a[] = b.split("sa|\\s+");
            out.println("There are " + (a.length - 1) + " occurances");
            out.print("Type in a sentence and press ENTER. ");
            b = scan.nextLine();
        }
        out.println("This is it");
    }
}
