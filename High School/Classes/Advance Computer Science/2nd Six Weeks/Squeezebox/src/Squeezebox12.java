
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
public class Squeezebox12 {

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
            int con = 0;
            int i = 1;
//            for (int i = 1; i < ll.size(); i++) {
//            for (int i = 1; i < ll.size(); i++) {
            while (i < ll.size()) {
                con = i;
//                boolean move = false;
//                if(con < ll.size() ) {
                do {
                    String cur1 = ll.get(con).getLast().toString();
                    char ch1[] = cur1.toCharArray();
                    if (con > 2 && con < ll.size()) {
                        String cur3 = ll.get(con - 3).getLast().toString();
                        char ch3[] = cur3.toCharArray();
                        if (ch1[0] == ch3[0] || ch1[1] == ch3[1]) {
                            Collections.reverse(ll.get(con));
                            ll.get(con - 3).addAll(ll.get(con));
                            ll.remove(con);
                            i--;
//                            move = true;
//                            con--;
                        }
                    }
                    if (con > 0) {
                        cur1 = ll.get(con).getLast().toString();
                        ch1 = cur1.toCharArray();
                        String cur2 = ll.get(con - 1).getLast().toString();
                        char ch2[] = cur2.toCharArray();
                        if (ch1[0] == ch2[0] || ch1[1] == ch2[1]) {
                            Collections.reverse(ll.get(con));
                            ll.get(con - 1).addAll(ll.get(con));
                            ll.remove(con);
                            i--;
//                        move = true;
//                        con--;
                        }
                    }
                    con--;

//                    if (move) {
//                        con--;
//                    } else {
//                        move = true;
//                    }
//                } while (con > 0 && con <= ll.size() && move);
                } while (con > 0 && con - 1 <= ll.size());
                i++;
            }
//            }
            int size = ll.size();
            String pil = size == 1 ? "pile" : "piles";
            out.print(size + " " + pil + " remaining: ");
            for (int f = 0; f < ll.size(); f++) {
                out.print(ll.get(f).size() + " ");
            }
            out.println();
            for (int f = 0; f < ll.size(); f++) {
                out.println(Arrays.toString(ll.get(f).toArray()));
            }
            out.println();
            ll.clear();
            a = scan.nextLine();
        }
    }
}
