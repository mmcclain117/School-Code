
import java.io.*;
import static java.lang.System.out;
import java.util.*;

public class cash {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("cash.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0 ; i < a ; i++) {
            int b = scan.nextInt();
            int c = scan.nextInt();
            int sum = 0;
            ArrayList<Integer> ar = new ArrayList<>();
            for (int u = 0 ; u < b ; u++) {
                int op = scan.nextInt();
                ar.add(op);
                sum += op;
            }
            int goal = Math.abs(c - sum);
            boolean xx = true;
//            for (int o = 0 ; o < ar.size() ; o++) {
//                if (ar.get(o) > goal) {
//                    ar.remove(o);
//                }
//            }
            out.println(goal);
            while (xx) {
                int point = ar.size() - 1;
                for (; point > 0 ; point += 0) {
                    int y = 0;
                    for (int p = ar.size() - 1 ; p > 0 ; p--) {
                        y += ar.get(p);
                        if (y == goal) {
                            xx = false;
                            break;
                        } else if (y > goal) {
                            break;
                        } else {
                            xx = (y - ar.get(p)) == goal;
                        }
                    }
//                    out.println(y);
                    point--;
                }
                break;
            }
            String yu = xx ? "is not possible" : "is possible";
            out.println(c + " " + yu);
        }
    }
}
