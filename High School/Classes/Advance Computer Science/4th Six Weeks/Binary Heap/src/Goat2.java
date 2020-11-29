
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Goat2 {

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
            int count = 0;
            int counts = 0;
            PriorityQueue pq = new PriorityQueue();
            boolean tr = true;
            while (tr) {
                BH bh = new BH();
                pq.clear();
//                PriorityQueue pq = new PriorityQueue();
                for (int ix = 0; ix < tt; ix++) {
                    pq.add(ar2.get(ix).get(count % ar2.get(ix).size()));
                    bh.add(ar2.get(ix).get(count % ar2.get(ix).size()));
                }
//                if (bh.min.length == 1) {
//                    System.out.println("Done");
//                    break;
//                }
//                System.out.println(Arrays.toString(pq.toArray()));
//                if (pq.size() == 1) {
//                    System.out.println("Done");
//                    break;
//                }
                int f1 = (int) pq.poll();
                int f2 = (int) pq.poll();
                int f3 = (int) pq.poll();
//                System.out.println(f1 + " " + f2 + " " + f3 + " " + f4);

//                if (bh.check()) {
//                    count++;
//                    con++;
//                }
                if (f1 == f2 || f1 == f3) {
                    count++;
                    con++;
                } else {
                    System.out.print(f1 + " " + f2 + " " + f3 + "\t");
                    System.out.println(dead + " " + (count - con));
                    System.out.println();
                    con = 0;
                    dead++;
                    tt--;
                    for (int i = 0; i < tt; i++) {
                        int te = ar2.get(i).get(count % ar2.get(i).size());
                        if (te == f1) {
                            ar2.remove(i);
                            break;
                        }
                    }
                    count++;
                }
                if (con > ar2.size()) {
                    tr = false;
                }
            }
            System.out.println(562 - dead + " " + (count - con));
//            System.out.println(562 - dead + " " + con);
        }
    }
}
