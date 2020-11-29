
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
public class openSource4 {

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
//                hm.put(Arrays.toString(hs.toArray()), a);
                hm.put(hs.toString(), a);
            }
            a = b;
            hs.clear();
            b = scan.nextLine();
        }
//        Set<Entry<String, String>> p = hm.entrySet();
        Set<String> ky = hm.keySet();
        out.println(Arrays.toString(ky.toArray()));
//        out.println(Arrays.toString(ky.toArray()[1].toString().split("[,]+")));
        ArrayList<String> ar = new ArrayList();
        ArrayList as = new ArrayList();
//        as.add(",");
//        for (int i = 0; i < ky.size(); i++) {
        Object k[] = ky.toArray();
        for (int ii = 0; ii < k.length; ii++) {
            String ss[] = k[ii].toString().split("[, ]+");
            for (int hp = 0; hp < ss.length; hp++) {
                String te = ss[hp];
//                out.println(te);
                if (as.indexOf(te) > 0) {
                    out.println();
//                if (ar.contains(te)) {
                    ar.add(te);
                    out.println(Arrays.toString(ar.toArray()));
                } else {
//                    out.println(Arrays.toString(as.toArray()));
                    as.add(te);
                }
//                }
            }
//            out.println();
        }
//        out.println("As: " + Arrays.toString(as.toArray()));
        ArrayList fin = new ArrayList();
        for (int i = 0; i < ky.size(); i++) {
            int con = 0;
            String pp[] = k[i].toString().replace("[", "").replaceAll("]", "").split("[, ]+");
//            String pp[] = k[i].toString().split("[,]+");
//            out.println(Arrays.toString(pp));
//            for (int ii = 0; ii < k.length; ii++) {
            for (int ii = 0; ii < pp.length; ii++) {
//                out.println(as.contains(pp[ii]));
                if (!(as.contains(k[ii]))) {
                    con++;
                    out.println(pp[ii]);
                }
            }
            String temp = con + " " + hm.get(k[i]);
            fin.add(temp);
        }
//        out.println(Arrays.toString(fin.toArray()));
//        out.println(Arrays.toString(l));
//        Arrays.sort(fin.toArray());
        Collections.sort(fin);
        Collections.reverse(fin);
        out.println(Arrays.toString(fin.toArray()));
        Object o[] = fin.toArray();
        for (int i = 0; i < o.length; i++) {
            out.println(o[i]);
//            out.println(k[o.length-( i + 1)]);
        }
//        out.println(hm.entrySet());
        out.println(hm.size() + "\nValues: " + Arrays.toString(hm.values().toArray()) + "\nKeys: " + Arrays.toString(hm.keySet().toArray()));
    }
}
