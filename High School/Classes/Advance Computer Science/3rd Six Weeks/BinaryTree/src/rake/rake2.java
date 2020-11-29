package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class rake2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("righttree.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String aa = scan.nextLine();
//            System.out.println(aa);
            if (aa.length() == 1 || aa.length() == 3) {
                if ("1".equals(aa) || "111".equals(aa)) {
                    System.out.println("Tree " + (i + 1) + " is a right-tree");
                } else {
                    System.out.println("Tree " + (i + 1) + " is not a right-tree");
                }
            } else {
                Node r = new Node(Integer.parseInt(aa.substring(0, 1)));
                Node p = new Node(Integer.parseInt(aa.substring(1, 2)));
                r.setLeft(p);
                for (int ii = 2; ii < aa.length() - 1; ii++) {
                    Node s = new Node(Integer.parseInt(aa.substring(ii, ii + 1)));
                    boolean add = true;
                    Node temp = r;
                    while (add) {
                        if (temp.getLeft() != null) {
                            if (temp.getRight() != null) {
                                temp = temp.getLeft();
                            } else {
                                temp.setRight(s);
                                r.setRight(temp);
                                add = false;
                            }
                        } else {
                            temp.setLeft(s);
                            r.setLeft(temp);
                            add = false;
                        }
                    }
                }
                boolean ri = rig(r);
                System.out.println("Tree " + (i + 1) + " is " + (ri ? "" : "not ") + "a right-tree");
            }
        }
    }

    public static Node add(Node a) {
        if (a.getData() == 1) {
            a.setLeft(a);
        } else {
            a.setRight(a);
        }
        return a;
    }

    private static boolean rig(Node r) {
        int l = lefts(r);
        int rg = rights(r);
//        System.out.println(rg + " " + l);
        return rg == l;
    }

    private static int lefts(Node r) {
        if (r == null || r.getData() == 0) {
            return 0;
        } else if (r.getLeft() == null) {
            return lefts(r.getRight());
        } else {
            return 1 + lefts(r.getLeft()) + lefts(r.getRight());
        }
    }

    private static int rights(Node r) {
        if (r == null) {
            return 0;
        } else if (r.getRight() == null) {
            return rights(r.getLeft());
        } else {
            return 1 + rights(r.getLeft()) + rights(r.getRight());
        }
    }
}
