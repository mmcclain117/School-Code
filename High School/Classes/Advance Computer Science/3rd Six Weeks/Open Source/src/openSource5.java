
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 180869
 */
public class openSource5 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("open.dat"));
        String a = scan.nextLine();
        String b = scan.nextLine();
        HashMap<String, String> hm = new HashMap();
        HashSet<String> hs = new HashSet();
        while (!(a.equals("1") && b.equals("0"))) {
            while (!(b.equals(b.toUpperCase()))) {
                hs.add(b);
                b = scan.nextLine();
            }
            if (hs.isEmpty()) {
                hm.put(",", a);
            } else {
                hm.put(hs.toString(), a);
            }
            a = b;
            hs.clear();
            b = scan.nextLine();
        }
        Set<String> ky = hm.keySet();
//        out.println(Arrays.toString(ky.toArray()));
        ArrayList<String> ar = new ArrayList();
        ArrayList as = new ArrayList();
        Object k[] = ky.toArray();
        for (int ii = 0; ii < k.length; ii++) {
//            String ss[] = k[ii].toString().split("[, ]+");
            String ss[] = k[ii].toString().split("[, ]+");
            for (int hp = 0; hp < ss.length; hp++) {
                String te = ss[hp].replaceAll("[^a-zA-Z]", "");
//                out.println(te);
                if (as.indexOf(te) >= 0) {
//                    out.println();
//                if (ar.contains(te)) {
                    ar.add(te);
//                    out.println(Arrays.toString(ar.toArray()));
                } else {
//                    out.println(Arrays.toString(as.toArray()));
                    as.add(te);
                }
            }
        }
//        out.println(Arrays.toString(ar.toArray()));
        ArrayList fin = new ArrayList();
        for (int i = 0; i < ky.size(); i++) {
            int con = 0;
            String pp[] = k[i].toString().replace("[", "").replaceAll("]", "").split("[, ]+");
            for (int ii = 0; ii < pp.length; ii++) {
                /**
                 * DIfference of a not
                 *
                 */
                if (!(ar.contains(pp[ii]))) {
                    con++;
//                    out.println(pp[ii]);
                }
//                out.println(con + " " + pp[ii]);
            }
            String temp = con + " " + hm.get(k[i]);
            fin.add(temp);
        }
        Collections.sort(fin);
        Collections.reverse(fin);
//        out.println(Arrays.toString(fin.toArray()));
        Object o[] = fin.toArray();
        for (int i = 0; i < o.length; i++) {
            out.println(o[i]);
        }
//        out.println(hm.size() + "\nValues: " + Arrays.toString(hm.values().toArray()) + "\nKeys: " + Arrays.toString(hm.keySet().toArray()));
    }
}
