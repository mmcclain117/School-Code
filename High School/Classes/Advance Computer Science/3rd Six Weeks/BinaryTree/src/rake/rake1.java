package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class rake1 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
        String aa = scan.nextLine();
        while (!aa.equals("-1")) {
            String a[] = aa.split("\\s+");
            int b[] = new int[a.length];
            for (int i = 0; i < b.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }
            boolean le = true;
            Node r = new Node(b[0]);
            Node temp = r;
            for (int i = 0; i < a.length; i++) {
                Node rt = new Node(b[i]);
                boolean add = true;
                while (add) {
                    if (rt.getData() == -1) {
//                        back
                        r.setLeft(temp);
//                        temp = r;
//                        break;
                    } else {
                        if (le) {
                            temp.setLeft(rt);
                            temp = temp.getLeft();
//                            r.setLeft(temp);
                            le = false;
                        } else {
                            le = true;
                            temp.setRight(rt);
//                            r.setRight(temp);
                            temp = temp.getRight();
                        }
                    }
                    add = false;
                }
                /*
                 if (i > 1) {
                 System.out.println(r.getData());
                 System.out.println(r.getLeft().getData());
                 }
                 //                temp = r.getLeft();
                 while (temp.getLeft() != null) {
                 System.out.println(temp.getData());
                 temp = temp.getLeft();
                 break;
                 }
                 */
//                while (add) {
//                    if (temp.getLeft() != null) {
//                        if (temp.getRight() != null) {
//                            temp = temp.getLeft();
//                        } else {
//                            temp.setRight(s);
//                            r.setRight(temp);
//                            add = false;
//                        }
//                    } else {
//                        temp.setLeft(s);
//                        r.setLeft(temp);
//                        add = false;
//                    }
//                }
            }
            while (r.getLeft() != null) {
                System.out.println(r.getData());
                r = r.getLeft();
            }
//            System.out.println(r.getLeft().getData());
            aa = scan.nextLine();
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
