package Collections;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Master
 */
public class HashSet1 {

    public static void main(String[] args) {
        int as[] = {1, 3, 2, 10, 3, 9, 4, 6, 3, 10}; // Number Array Set
        Hashset hs = new Hashset();
        HashSet hsj = new HashSet();
        ArrayList ar = new ArrayList();
        for (int i = 0; i < as.length; i++) {
            hs.add(as[i]);
            hsj.add(as[i]);
            ar.add(as[i]);
        }
        hs.add(null);
        hsj.add(null);
        out.println("ADD:      " + hs);
        out.println("Java ADD: " + hsj);
        hs.remove(1);
        hs.remove(4);
        hsj.remove(1);
        hsj.remove(4);
        out.println("Remove:      " + hs);
        out.println("Java Remove: " + hsj);
        hs.clear();
        hsj.clear();
        hs.remove(1);
        hsj.remove(1);
        out.println(hs.toString());
        out.println(hsj.toString());
    }
}
