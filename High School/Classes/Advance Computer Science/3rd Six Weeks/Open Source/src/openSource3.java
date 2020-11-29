
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 180869
 */
public class openSource3 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("open.dat"));
        String a = scan.nextLine();
        String b = scan.nextLine();
        HashMap<String, String> hm = new HashMap();
//        HashMap<String, String> hm2 = new HashMap();
        HashSet<String> hs = new HashSet();
        while (!(a.equals("1") && b.equals("0"))) {
            while (!(b.equals(b.toUpperCase()))) {
//                hm.put(b, a);
//                hm2.put(a, b);
//                out.println(hm.entrySet());
                hs.add(b);
                b = scan.nextLine();
            }
            hm.put(Arrays.toString(hs.toArray()), a);
            a = b;
            hs.clear();
            b = scan.nextLine();
        }
        Object k[] = hm.keySet().toArray();
        for (int i = 0; i < hm.size(); i++) {
//            Object v[] = hm.get(k[i]);
//            for (int ii = 0; ii < v.length; ii++) {
//            out.println(hm.get(k[i]));
//            }
        }
        Set<Entry<String, String>> p = hm.entrySet();
        Object l[] = p.toArray();
        out.println(Arrays.toString(l));
        out.println(hm.entrySet());
        out.println(hm.size() + "\nValues: " + Arrays.toString(hm.values().toArray()) + "\nKeys: " + Arrays.toString(hm.keySet().toArray()));
//        out.println(hm2.size() + "\nValues: " + Arrays.toString(hm2.values().toArray()) + "\nKeys: " + Arrays.toString(hm2.keySet().toArray()));
    }
}
