

import java.util.*;
import static java.lang.System.*;
/**
 * 
 * @author Kyle Fromm
 */
public class A_One {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int x = 0;
        for (x = 0; x < list.size(); x++) {
            out.print(list.get(x));
        }
        out.println();
        x = 0;
        while (x < list.size()) {
            out.print(list.get(x));
            x++;
        }
        out.println();
        x = 0;
        do {
            out.print(list.get(x));
            x++;
        } while (x < list.size());
        out.println();
        for (int n : list) {
            out.print(n);
        }
        out.println();
    }

}
