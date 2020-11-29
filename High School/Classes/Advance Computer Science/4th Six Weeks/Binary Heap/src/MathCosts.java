
import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathCosts {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("mathCosts.dat"));
        int a;
        do {
            a = scan.nextInt();
            if (a == 0) {
                break;
            }
            int b[] = new int[a];
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int i = 0; i < a; i++) {
                b[i] = scan.nextInt();
                pq.add(b[i]);
            }
            int sum = 0;
            while (pq.size() != 1) {
                if (pq.size() >= 3) {
                    int aa = pq.poll();
                    int bb = pq.poll();
                    int cc = pq.poll();
                    if (bb > cc) {
                        pq.add(bb);
                        pq.add(cc + aa);
                        sum += cc + aa;
                    } else {
                        pq.add(cc);
                        pq.add(bb + aa);
                        sum += bb + aa;
                    }
                } else {
                    int aa = pq.poll() + pq.poll();
                    pq.add(aa);
                    sum += aa;
                }
//                System.out.println(Arrays.toString(pq.toArray()));
            }
            System.out.println(sum);
        } while (a != 0);
    }

}
