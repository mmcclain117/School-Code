
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Goat {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("goat.txt"));
        int n = scan.nextInt();// Number of cases
//        System.out.println(n);
        for (int ni = 0; ni < n; ni++) {
            int tt = scan.nextInt(); // Cycle of ith Goat
            ArrayList<ArrayList<Integer>> ar2 = new ArrayList();
            ArrayList<int[]> ar = new ArrayList();
//            System.out.println(tt);
            int p = 0;
            for (int ti = 0; ti < tt; ti++) {
                p = scan.nextInt();
//                System.out.println(p);
                ArrayList<Integer> tem = new ArrayList(tt);
                int t[] = new int[p];
                for (int i = 0; i < p; i++) {
                    t[i] = scan.nextInt();
                    tem.add(t[i]);
                }
                ar2.add(tem);
                ar.add(t);
            }
//            System.out.println(ar2);
//            System.out.println(ar2.get(0).size());
//            System.out.println(p);
            int dead = 0;
            int con = 0;
            int count = 0;
            PriorityQueue pq = new PriorityQueue();
            boolean tr = true;
            while (tr) {
                pq.clear();
                for (int ix = 0; ix < tt; ix++) {
                    pq.add(ar2.get(ix).get(count % ar2.get(ix).size()));
//                    System.out.print(ar2.get(ix).get(count % ar2.get(ix).size()) + " ");
                }
//                System.out.println();
//                System.out.println(Arrays.toString(pq.toArray()));
                if (pq.size() == 1) {
                    System.out.println("Done");
                    break;
                }
                int f1 = (int) pq.poll();
//                System.out.println(f1);
                int f2 = (int) pq.peek();
                if (f1 == f2) {
                    count++;
                    con++;
//                    pq.add(f1);
                } else {
                    con = 0;
                    dead++;
                    tt--;
                    for (int i = 0; i < tt; i++) {
                        int te = ar2.get(i).get(count % ar2.get(i).size());
                        if (te == f1) {
//                            System.out.println(ar2.get(i));
                            ar2.remove(i);
                        }
                    }
                    count++;
                }
                if (con > ar2.size()) {
                    tr = false;
                }
//                if (ar2.isEmpty() || count > 100) {
//                    tr = false;
//                }
            }
            System.out.println(dead + " " + (count - con));
        }
    }
}
