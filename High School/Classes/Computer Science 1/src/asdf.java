
import java.util.Random;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class asdf {

    public static void main(String[] args) {
        Integer a = null;
        Random rnd = new Random();
        out.println(a);
        int b[] = new int[10];
        for (a = 0; a < b.length; a++) {
            b[a] = rnd.nextInt();
            out.print(b[a] + ", ");
        }
    }
}
