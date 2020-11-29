
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Squeezebox6 {

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
            int i = 0;
            while (i < ll.size()) {
//            for (int i = 0; i < ll.size(); i++) {
                int con = i;
                while (con > 0) {
                    String cur1 = ll.get(con).getFirst().toString();
                    char ch1[] = cur1.toCharArray();
                    String cur2 = ll.get(con - 1).getFirst().toString();
                    char ch2[] = cur2.toCharArray();
                    if (ch1[0] == ch2[0] || ch1[1] == ch2[1]) {
                        ll.get(con - 1).addFirst(ll.get(con).getFirst());
                        ll.get(con).removeFirst();
                        if (ll.get(con).size() == 0) {
                            ll.remove(con);
                            con--;
                            i--;
                        }
                        con--;
                    }
//                    if (con > 0) {
                    if (con > 3) {
                        cur1 = ll.get(con).getFirst().toString();
                        ch1 = cur1.toCharArray();
                        String cur3 = ll.get(con - 3).getFirst().toString();
                        char ch3[] = cur3.toCharArray();
                        if (ch1[0] == ch3[0] || ch1[1] == ch3[1]) {
                            ll.get(con - 3).addFirst(ll.get(con).getFirst());
                            ll.get(con).removeFirst();
                            if (ll.get(con).size() == 0) {
                                ll.remove(con);
                                con--;
                                i--;
                            }
                            con--;
                        }
                    }
                    con--;
                }
//                }
                i++;
            }
            int size = ll.size();
            String pil = size == 1 ? "pile" : "piles";
            out.print(size + " " + pil + " remaining: ");
            for (int f = 0; f < ll.size(); f++) {
                out.print(ll.get(f).size() + " ");
            }
            for (int f = 0; f < ll.size(); f++) {
                out.println(Arrays.toString(ll.get(f).toArray()));
            }
            out.println();
            ll.clear();
            a = scan.nextLine();
        }
    }
}
