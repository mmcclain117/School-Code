
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Goat3 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("goat.dat"));
        int n = scan.nextInt();// Number of cases
        for (int ni = 0; ni < n; ni++) {
            int tt = scan.nextInt(); // Cycle of ith Goat
            ArrayList<ArrayList<Integer>> ar2 = new ArrayList();
            ArrayList<int[]> ar = new ArrayList();
            int p = 0;
            for (int ti = 0; ti < tt; ti++) {
                p = scan.nextInt();
                ArrayList<Integer> tem = new ArrayList(tt);
                int t[] = new int[p];
                for (int i = 0; i < p; i++) {
                    t[i] = scan.nextInt();
                    tem.add(t[i]);
                }
                ar2.add(tem);
                ar.add(t);
            }
            int dead = 0;
            int con = 0;
//            int count = 0;
            int counts = 0;
            PriorityQueue pq = new PriorityQueue();
            boolean tr = true;
            while (tr) {
                BH bh = new BH();
                pq.clear();
                for (int ix = 0; ix < tt; ix++) {
//                    pq.add(ar2.get(ix).get(counts % ar2.get(ix).size()));
                    bh.add(ar2.get(ix).get(counts % ar2.get(ix).size()));
                }
//                if (bh.min.length == 1) {
//                    System.out.println("Done");
//                    break;
//                }
//                if (pq.size() == 1) {
//                    System.out.println("Done");
//                    break;
//                }
//                int f1 = (int) pq.poll();
//                int f2 = (int) pq.peek();
                if (bh.check()) { // If multiple
                    counts++;
                    con++;
                } else {
                    con = 0;
                    dead++;
                    tt--;
                    for (int i = 0; i < tt; i++) {
                        int te = ar2.get(i).get(counts % ar2.get(i).size());
                        if (te == bh.getMin()[1]) {
                            ar2.remove(i);
                        } else {
//                            System.out.println(te + " " + bh.getMin()[1]);
                        }
                    }
                    counts++;
//                    System.out.println(dead + " " + con + " " + counts);
                }
                if (con > ar2.size()) {
                    tr = false;
                }
//                if (f1 == f2) {
//                    count++;
//                    con++;
//                } else {
//                    con = 0;
//                    dead++;
//                    tt--;
//                    for (int i = 0; i < tt; i++) {
//                        int te = ar2.get(i).get(count % ar2.get(i).size());
//                        if (te == f1) {
//                            ar2.remove(i);
//                        }
//                    }
//                    count++;
//                }
//                if (con > ar2.size()) {
//                    tr = false;
//                }
            }
//            System.out.println(dead + " " + (count - con));
            System.out.println(dead + " " + (counts - con));
        }
    }
}
