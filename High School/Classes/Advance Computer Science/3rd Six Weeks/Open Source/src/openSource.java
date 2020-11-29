
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 180869
 */
public class openSource {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("open.dat"));
        String a = scan.nextLine();
        String b = scan.nextLine();
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String> hm2 = new HashMap();
        HashSet hs = new HashSet();
//        HashSet hh = new HashSet();
        HashMap<String, HashSet> hp = new HashMap();
        while (!(a.equals("1") && b.equals("0"))) {
//            ArrayList ar = new ArrayList();
            HashSet hh = new HashSet();
            while (!(b.equals(b.toUpperCase()))) {
                hm.put(b, a);
                hm2.put(a, b);
                hs.add(b);
                hh.add(b);
                b = scan.nextLine();
//                ar.add(b);
            }
//            hh.add(hs);
//            hp.put(hs, a);
//            hp.put(a, hs);
            hp.putIfAbsent(a, hh);
//            hp.put(a, ar);
            a = b;
//            hh.clear();
//            hs.clear();
            b = scan.nextLine();
            out.println(Arrays.toString(hs.toArray()));
        }
//        out.println(Arrays.toString(hh.toArray()));
//        out.println(hm.size() + "\nValues: " + Arrays.toString(hm.values().toArray()) + "\nKeys: " + Arrays.toString(hm.keySet().toArray()));
//       Set s =  hm.keySet();
//        Object[] s = hm.keySet().toArray();
        Object[] v = hm.values().toArray();
        Object[] k = hm.keySet().toArray();
        out.println(v.length + " " + k.length + " " + hp.size());

//        for (int i = 0; i < hp.size(); i++) {
//            out.print(v[i]);
//            out.println(v[i] + " " + (hp.get(v[i].toString()).size()));
//        }
        out.println(hp.size() + "\nValues: " + Arrays.toString(hp.values().toArray()) + "\nKeys: " + Arrays.toString(hp.keySet().toArray()));
//        out.println(hm2.size() + "\nValues: " + Arrays.toString(hm2.values().toArray()) + "\nKeys: " + Arrays.toString(hm2.keySet().toArray()));
    }
}
