
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.function.BiFunction;

/**
 *
 * @author Master
 */
public class Adam {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("adam.txt"));
        BiFunction<Integer, Integer, Boolean> match = (Integer a, Integer b) -> a.compareTo(b) > 0;
        while (scan.hasNext()) {
            Integer x = scan.nextInt();
            Integer y = scan.nextInt();
            out.println(match.apply(x, y));
        }
    }
}
