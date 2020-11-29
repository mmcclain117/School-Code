
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author Master
 */
public class StringClass {

    public static void main(String[] args) {
        String a = "This Is A String";
        out.println("Original: " + a);
        char c = a.charAt(1);
        out.println("Char Index 1: " + c);
        String s = a.substring(a.length() / 2);
        out.println("Substring Half: " + s);
        out.println("Uppercase: " + a.toUpperCase());
        out.println("Lovercase: " + a.toLowerCase());
        char ch[] = a.toCharArray();
        out.println("Char Array: " + Arrays.toString(ch));
    }
}
