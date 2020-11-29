
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main2 {

    public static void main(String[] args) {
        double l[] = {5, 2, 6, 1, 3, 9};
//        double l[] = {1, 2, 3};
//        double l[] = {2, 1, 3};
//        double l[] = {3, 4, 1, 2};
        TreeNode tn = new TreeNode(l[0]);
        for (int i = 1; i < l.length; i++) {
            tn.add(l[i], tn);
        }
//        tn.inorder(tn);
        ArrayList<Integer> ar = tn.inorder(tn, new ArrayList());
        System.out.println();
//        ArrayList<String> as = new ArrayList();
        for (int i = 1; i < 4; i++) {
//            for (int ii = i * 3; ii < 12; ii++) {
//                System.out.print(" ");
//            }
//            tn.printLevel(tn, i);
            String lay = tn.printLevel(tn, i);
//            as.add(lay);
            System.out.println();
//            System.out.println(l[i] + " was found at " + tn.search(tn, l[i], 0));
        }
//        System.out.println(Arrays.toString(ar.toArray()));
        Collections.reverse(ar);
        System.out.println();
        for (int a : ar) {
//            System.out.println(a + " was found at " + tn.search(tn, a, 0));
            int s = tn.search(tn, a, 0);
            int con = 0;
            s = tn.getNodeHeight(tn, a, 0);
//            System.out.println(a + " was found at " + tn.getNodeHeight(tn, a, 0));
//            System.out.println(s);
            while (con < s) {
                System.out.print("  ");
                con++;
            }
            System.out.println(a);
        }
//        System.out.println(Arrays.toString(as.toArray()));
    }
}
