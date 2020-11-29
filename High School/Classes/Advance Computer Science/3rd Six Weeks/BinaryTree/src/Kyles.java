
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class Kyles {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("righttree.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < cases; i++) {
            String Line = scan.nextLine();
            BT binaryTree = new BT();
            char nodes[] = Line.toCharArray();
//            for (int ii = 0; ii < aa.length(); ii++) {
            for (int ii = 0; ii < nodes.length; ii++) {
//                btt.insert(Integer.parseInt(aa.substring(ii, ii + 1)));
                binaryTree.insert(Integer.parseInt(nodes[ii] + ""));
            }
            boolean p = (rig(binaryTree.root));
//            if (i % 3 == 2) {
//                p = !p;
//            }
            System.out.println("Tree " + (i + 1) + ((p ? " is a right-tree" : " is not a right-tree")));
        }
    }

    private static boolean rig(Tree root) {
        int l = lefts(root);
        int rg = rights(root);
        System.out.println(rg + " " + l);
//        System.out.println("LEFT " + cLN(root));
//        System.out.println("Right " + cRN(root));
        return rg == l;
    }

    /*
     private static int cLN(Tree root) {
     int count = 0;
     if (root.left != null) {
     count += 1 + cLN(root.left);
     }
     if (root.right != null) {
     count += cLN(root.right);
     }
     return count;
     }

     private static int cRN(Tree root) {
     int count = 0;
     if (root.right != null) {
     count += 1 + cRN(root.right);
     }
     if (root.left != null) {
     count += cRN(root.left);
     }
     return count;
     } */
    private static int lefts(Tree root) {
//        if (root == null || root.getData() == 0) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null) {
            return lefts(root.getRight());
        } else {
            return 1 + lefts(root.getLeft()) + lefts(root.getRight());
        }
    }

    private static int rights(Tree root) {
//        if (root == null || root.data == 0) {
        if (root == null) {
            return 0;
        } else if (root.getRight() == null) {
            return rights(root.getLeft());
        } else {
            return 1 + rights(root.getLeft()) + rights(root.getRight());
        }
    }
}

class BT { // Binary Tree to handle insertion

    public Tree root;

    public BT() {
        root = null;
    }

    public void insert(int data) {
//        Tree te = insert(root, data);
//        root = insert(te, 2);
//        root = te;
        root = insert(root, data);
    }

    private Tree insert(Tree node, int data) {
        if (node == null) {
            node = new Tree(data);
        } else if (data == 0) {
            return root;
        } else {
            if (node.getRight() == null) {
                node.setRight(insert(node.right, data));
            } else {
                node.setLeft(insert(node.left, data));
//                node.left = insert(node.left, data);
            }
        }
        return node;
    }
}

class Tree {

    public Tree left, right;
    public int data;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

//    public Tree(int data, Tree left, Tree right) {
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

}
