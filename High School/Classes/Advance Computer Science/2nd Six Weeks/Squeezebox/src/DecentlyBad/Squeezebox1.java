package DecentlyBad;

import java.io.File;
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Squeezebox1 {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("squeezebox.dat"));
        String a = scan.nextLine();
        String b = "";
        ArrayDeque<String> aq = new ArrayDeque();
        Stack s = new Stack();
//        ArrayList<String> ar = new ArrayList();
        ArrayList<Integer> ar = new ArrayList();
        LinkedList<String> ll = new LinkedList();
//        HashMap<String, Integer> hm = new HashMap();
//        int u[] = new int[52];
//        Arrays.fill(u, 1);
        for (int i = 0; i < 51; i++) {
            ar.add(1);
        }
        while (!(a.equals("#"))) {
            b = scan.nextLine();
            String ap[] = a.split("[ ]+");
            String bp[] = b.split("[ ]+");
            String las = "  ";
            String as = "  ";
            int con = 1;
            for (int i = 0; i < ap.length; i++) {
//                aq.addLast(ap[i]);
                if (aq.size() > 1) {
                    las = aq.getLast();
                }
                if (aq.size() > 3) {
                    String te = aq.getLast();
                    String tem = aq.getLast();
                    as = aq.getLast();
                    aq.addLast(te);
                    aq.addLast(tem);
                }
//                out.println(as + " "+ ap[i]);
                aq.addLast(ap[i]);
//                ar.add(ap[i]);
//                ll.add(ap[i]);
                out.println(as);
                if (EQ(las, ap[i])) {
//                if (EQ(las, ap[i]) && i < ar.size() - 1) {
//                    out.println(i);
//                    ar.set(i - 1, (1 + ar.get(i)));
                    ar.set(con - 1, (1 + ar.get(con)));
//                    ar.remove(i);
                    ar.remove(con);
                    con++;
//                    out.println(ar.get(i - 1));
//                } else if (EQ(as, ap[i]) && i < ar.size() - 1) {
                } else if (EQ(as, ap[i])) {
//                    ar.set(i - 1, (1 + ar.get(i)));
//                    ar.set(con - 1, (1 + ar.get(i)));
                    ar.set(con - 1, (1 + ar.get(con)));
//                    ar.remove(i);
                    ar.remove(con);
                    con++;
//                    out.println(ar.get(i - 1));
                }
                /*
                 for (int ii = 0; ii < ll.size(); i++) {
                 int con = 1;
                 int las = 0;
                 int thir = 0;
                 while (con < ll.size() - 1 && con < ar.size()) {
                 if (con > 3) {
                 thir = con - 3;
                 if (EQ(ll.get(con), ll.get(thir))) {
                 ll.push(ll.get(con));
                 //                                ll.set(thir, ll.get(con));
                 //                                int uth = ar.get(thir);
                 //                                int cth = ar.get(con);
                 //                                ar.set(thir, uth++);
                 //                                if (cth == 1) {
                 //                                    ar.remove(con);
                 //                                }
                 //                                ar.set(con, cth--);
                 con++;
                 con = 0;
                 //                                ll.remove(con);
                 } else {
                 con++;
                 }
                 }
                 if (con > 1) {
                 las = con - 1;
                 if (EQ(ll.get(con), ll.get(las))) {
                 ll.set(las, ll.get(con));
                 //                                int uth = ar.get(thir);
                 //                                int cth = ar.get(con);
                 //                                ar.set(thir, uth++);
                 //                                if (cth == 1) {
                 //                                    ar.remove(con);
                 //                                }
                 //                                ar.set(con, cth--);
                 con++;
                                
                 con = 0;
                 ll.remove(con);
                 } else {
                 con++;
                 }
                 } else {
                 con++;
                 }
                 }
                 }
                
                 */
            }
            out.println("Size: " + ar.size());
            for (int i = 0; i < ar.size(); i++) {
                out.println(ar.get(i));
            }

//            for (int i = 0; i < bp.length; i++) {
//                aq.addLast(bp[i]);
//                aq.addFirst(bp[i]);
//                ar.add(bp[i]);
//                ll.add(bp[i]);
//            }
            /*
             int con = 0;
             while (con < aq.size()) {
             String as = aq.poll();
             }
             */
 /*
             int con = 1;
             int las = 0;
             int thir = 0;
             while (con < ll.size() - 1 && con < ar.size()) {
             int set = 0;
             while (set <= con  && set < ar.size() - 1) {
             if (set > 3) {
             thir = set - 3;
             if (EQ(ll.get(set), ll.get(thir))) {
             ll.set(thir, ll.get(set));
             //                        u[set]--;
             //                        u[thir]++;
             int uth = ar.get(thir) + 1;
             int cth = ar.get(set);
             ar.set(thir, uth);
             if (cth == 1) {
             ar.remove(set);
             //                        } else {
             }
             ar.set(set, cth--);
             set++;
             set = 0;
             ll.remove(set);
             //                        }
             } else {
             set++;
             }
             }
             if (set > 1) {
             las = set - 1;
             //                    out.println(set+" "+ las+ " "+ ar.size());
             if (EQ(ll.get(set), ll.get(las))) {
             ll.set(las, ll.get(set));
             int uth = ar.get(thir) + 1;
             int cth = ar.get(set);
             //                            out.println(cth);
             ar.set(thir, uth++);
             out.println(ar.get(thir));
             if (cth == 1) {
             ar.remove(set);
             //                        } else {
             }
             ar.set(set, cth--);
             set++;

             set = 0;
             ll.remove(set);
             //                        }
             //                        ll.remove(set);
             //                        set++;
             //                        set = 0;
             } else {
             set++;
             }
             } else {
             set++;
             }
             }
             con++;
             }
             out.println("\n" + ll.size());
             for (int i = 0; i < ll.size(); i++) {
             String aa = ll.get(i);
             //                out.println(aa);
             }
             out.println(Arrays.toString(ar.toArray()));
             ll.clear();
             */
 /*
             int con = 1;
             int las = 0;
             int thir = 0;
             while (con < ll.size() - 1 && con < ar.size()) {
             if (con > 3) {
             thir = con - 3;
             if (EQ(ll.get(con), ll.get(thir))) {
             ll.set(thir, ll.get(con));
             //                        u[con]--;
             //                        u[thir]++;
             int uth = ar.get(thir);
             int cth = ar.get(con);
             ar.set(thir, uth++);
             if (cth == 1) {
             ar.remove(con);
             //                        } else {
             }
             ar.set(con, cth--);
             con++;
             con = 0;
             ll.remove(con);
             //                        }
             } else {
             con++;
             }
             }
             if (con > 1) {
             las = con - 1;
             //                    out.println(con+" "+ las+ " "+ ar.size());
             if (EQ(ll.get(con), ll.get(las))) {
             ll.set(las, ll.get(con));
             int uth = ar.get(thir);
             int cth = ar.get(con);
             ar.set(thir, uth++);
             if (cth == 1) {
             ar.remove(con);
             //                        } else {
             }
             ar.set(con, cth--);
             con++;

             con = 0;
             ll.remove(con);
             //                        }
             //                        ll.remove(con);
             //                        con++;
             //                        con = 0;
             } else {
             con++;
             }
             } else {
             con++;
             }
             }
             out.println("\n" + ll.size());
             for (int i = 0; i < ll.size(); i++) {
             String aa = ll.get(i);
             out.println(aa);
             }
             out.println(Arrays.toString(ar.toArray()));
             ll.clear();
             */
 /*
             int con = 1;
             int las = 0;
             int thir = 0;
             while (con < ar.size() - 1) {
             if (con > 3) {
             thir = con - 3;
             if (EQ(ar.get(con), ar.get(thir))) {
             ar.set(thir, ar.get(con));
             ar.remove(con);
             } else {
             con++;
             }
             }
             if (con > 1) {
             las = con - 1;
             //                    out.println(con+" "+ las+ " "+ ar.size());
             if (EQ(ar.get(con), ar.get(las))) {
             ar.set(las, ar.get(con));
             ar.remove(con);
             } else {
             con++;
             }
             } else {
             con++;
             }
             }
             out.println("\n" + ar.size());
             for (int i = 0; i < ar.size(); i++) {
             out.println(ar.get(i));
             }
             ar.clear();
             */
 /*
             //            Iterator it = aq.iterator();
             out.println(aq.size());
             String tem = "";
             //            String las = it.next().toString();
             String las = aq.removeFirst();
             boolean cont = true;
             //            while (it.hasNext()) {
             while (cont) {
             //                tem = it.next().toString();
             tem = aq.removeFirst();
             if (EQ(tem, las)) {
             aq.remove(tem);
             }
             las = tem;
             }
             */
            aq.clear();
            a = scan.nextLine();
        }
    }
    //    public static boolean EQ(Object a, Object b) {
    //        char ch1[] = a.toString().toCharArray();
    //        char ch2[] = b.toString().toCharArray();
    //        return ch1[0] == ch2[0] || ch1[1] == ch2[1];
    //    }

    public static boolean EQ(String a, String b) {
        char ch1[] = a.toCharArray();
        char ch2[] = b.toCharArray();
        return ch1[0] == ch2[0] || ch1[1] == ch2[1];
    }
}
