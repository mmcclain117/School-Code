
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author 180869
 */
public class openSource2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("open.dat"));
        String a = scan.nextLine();
        String b = scan.nextLine();
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String> hm2 = new HashMap();
        HashSet hs = new HashSet();
        HashMap<String, HashSet> hp = new HashMap();
        while (!(a.equals("1") && b.equals("0"))) {
            HashSet hh = new HashSet();
            while (!(b.equals(b.toUpperCase()))) {
                hm.put(b, a);
                hm2.put(a, b);
                hs.add(b);
                hh.add(b);
                b = scan.nextLine();
            }
            a = b;
            b = scan.nextLine();
            out.println(Arrays.toString(hs.toArray()));
        }
        Object[] v = hm.values().toArray();
        Object[] k = hm.keySet().toArray();
        out.println(v.length + " " + k.length + " " + hp.size());
        for (int i = 0; i < v.length; i++) {
            out.println(k[i].toString() + " " + v[i].toString());
        }
        out.println(hp.size() + "\nValues: " + Arrays.toString(hp.values().toArray()) + "\nKeys: " + Arrays.toString(hp.keySet().toArray()));
    }
}
