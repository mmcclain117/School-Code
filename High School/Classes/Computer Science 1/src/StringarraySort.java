
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author Master
 */
public class StringarraySort {

    public static void main(String[] args) {
        String ss[] = {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Bernard", "Ezra", "Herman", "Horace", "PJ", "Benjamen", "Cal", "jackPot"};
        Arrays.sort(ss);
        int k = ss.length - 1;
        String spacing = "        ";
        out.println("Ascend" + spacing + "Decend");
        int regLength = 6;
        for (String s : ss) {
            out.print(s);
            for (int a = 0; a < spacing.length() - (s.length() - regLength); ++a) {
                out.print(" ");
            }
            out.print(ss[k]);
            out.println("");
            k--;
        }
    }
}
