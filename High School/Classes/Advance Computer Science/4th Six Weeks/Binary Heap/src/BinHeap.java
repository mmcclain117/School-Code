
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinHeap {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a.txt"));
        List<Integer> b = new ArrayList();
        b.add(null);
        while (scan.hasNext()) {
            int t = scan.nextInt();
            b.add(t);
            int con = b.size() - 1;
            System.out.println("Before: " + Arrays.toString(b.toArray()));
            boolean r = con % 2 == 0;
            while (con > 1) {
                con /= 2;
                if (b.get(con) > t) {
//                    int te = 0;
                    int te = b.get(con * 2);
//                    if (r) {
//                        te = b.get(con * 2 + 1);
//                    } else {
//                        te = b.get(con * 2);
//                    }
                    b.set(con, t);
                    b.set((con * 2), te);
                    System.out.println(Arrays.toString(b.toArray()));
                }
            }
        }
        System.out.println(Arrays.toString(b.toArray()));
    }
}
