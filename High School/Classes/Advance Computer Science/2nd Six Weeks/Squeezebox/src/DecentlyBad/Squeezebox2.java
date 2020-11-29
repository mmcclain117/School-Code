package DecentlyBad;

import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Squeezebox2 {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("squeezebox.dat"));
        String a = scan.nextLine();
        String b = "";
        LinkedList<LinkedList> ll = new LinkedList();
        while (!(a.equals("#"))) {
            b = scan.nextLine();
            String aa[] = a.split("[ ]+");
            String bb[] = b.split("[ ]+");
            for (int i = 0; i < aa.length; i++) {
                LinkedList p = new LinkedList();
                p.add(aa[i]);
                ll.add(p);
            }
            for (int i = 0; i < bb.length; i++) {
                LinkedList p = new LinkedList();
                p.add(bb[i]);
                ll.add(p);
            }
            out.println(ll.get(0).element());
            for (int i = 0; i < ll.size(); i++) {
                boolean tr = true;
                int con = i;
                while (con > 1 && con < ll.size()) {
//                if (i > 1 && i < ll.size()) {
//                    String cur1 = ll.get(i).element().toString();
                    String cur1 = ll.get(con).element().toString();
//                    String cur2 = ll.get(i - 1).element().toString();
                    String cur2 = ll.get(con - 1).element().toString();
                    char ch1[] = cur1.toCharArray();
                    char ch2[] = cur2.toCharArray();
                    if ((ch1[0] == ch2[0] || ch1[1] == ch2[1]) && tr) {
//                        ll.get(i - 1).addAll(ll.get(i));
                        ll.get(con - 1).addAll(ll.get(con));
//                        ll.remove(i);
                        ll.remove(con);
                        i--;
                    }
                    con--;
                }
                if (i > 3 && i < ll.size() - 3) {
                    String cur1 = ll.get(i).element().toString();
                    String cur2 = ll.get(i - 3).element().toString();
                    char ch1[] = cur1.toCharArray();
                    char ch2[] = cur2.toCharArray();
                    if ((ch1[0] == ch2[0] || ch1[1] == ch2[1]) && tr) {
                        ll.get(i - 3).addAll(ll.get(i));
                        ll.remove(i);
                        i--;
                    }
                }
            }
            out.println(ll.size());
            for (int i = 0; i < ll.size(); i++) {
                out.println(Arrays.toString(ll.get(i).toArray()));
            }
            ll.clear();
            a = scan.nextLine();
        }
    }
}
