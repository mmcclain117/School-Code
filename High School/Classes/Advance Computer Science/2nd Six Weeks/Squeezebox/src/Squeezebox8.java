
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Squeezebox8 {

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
            for (int i = 0; i < ll.size(); i++) {
                int con = i;
                while (con > 0 && con < ll.size()) {
                    String cur1 = ll.get(con).getLast().toString();
                    String cur2 = ll.get(con - 1).getLast().toString();
                    char ch1[] = cur1.toCharArray();
                    char ch2[] = cur2.toCharArray();
                    if (ch1[0] == ch2[0] || ch1[1] == ch2[1]) {
//                        Collections.reverse(ll.get(con));
                        ll.get(con - 1).addAll(ll.get(con));
                        ll.remove(con);
                        i--;
//                        con--;
                    }
                    if (con > 2 && con < ll.size()) {
                        String cur3 = ll.get(con - 3).getLast().toString();
                        char ch3[] = cur3.toCharArray();
                        if (ch1[0] == ch3[0] || ch1[1] == ch3[1]) {
//                            Collections.reverse(ll.get(con));
                            ll.get(con - 3).addAll(ll.get(con));
                            ll.remove(con);
                            i--;
//                            con--;
                        }
                    }
                    con--;
                }

            }
            int size = ll.size();
            String pil = size == 1 ? "pile" : "piles";
            out.print(size + " " + pil + " remaining: ");
            for (int i = 0; i < ll.size(); i++) {
                out.print(ll.get(i).size() + " ");
            }
            for (int i = 0; i < ll.size(); i++) {
                out.println(Arrays.toString(ll.get(i).toArray()));
            }
            out.println();
            ll.clear();
            a = scan.nextLine();
        }
    }
}
