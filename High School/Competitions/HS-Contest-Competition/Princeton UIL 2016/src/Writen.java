

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Writen {

    public static void main(String[] args) {
        out.println(Integer.parseInt(5 + "10")); // problem 28
        out.println(Integer.toString(999999, 3)); // 
        out.println(Integer.toBinaryString(-55));
        prob11();
        prob19();
    }

    private static void prob11() {
        int total = 0;
        String msg = "4 -10 12 8 -6 7 3 -1 2 9 0";
        Scanner par = new Scanner(msg);
        while (par.nextInt() % 2 == 0) {
            total += par.nextInt();
        }
        out.println(total);
    }

    private static void prob19() {
        String ids[] = new String[3];
        ids = new String[]{"LBJ", "cop", "Doc", "null", "", "24k"};
        Arrays.sort(ids);
        out.println(Arrays.toString(ids));
    }
}
