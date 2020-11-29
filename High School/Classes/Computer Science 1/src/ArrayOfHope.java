
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class ArrayOfHope {

    public static void main(String[] args) {
        char ch[] = new char[26];
        int a = 0;
        for (char b = 65; a < 26; a++) {
            ch[a] = b;
            b++;
        }
        for (int z = 0; z < 26; z++) {
            out.print(ch[z] + ", ");
        }
    }
}
