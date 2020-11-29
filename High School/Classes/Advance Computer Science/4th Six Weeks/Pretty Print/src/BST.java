
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Master
 */
public class BST {

    private Node root;
    private ArrayList inod; // In order

    public BST() {
        root = new Node();
        inod = new ArrayList();
    }

    public BST(double d) {
        root = new Node(d);
        inod = new ArrayList();
        inod.add(d);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(double data) {
        inod.add(data);
        insert(root, data);
    }

    /**
     * Need to edit
     *
     * @param n
     * @param data
     * @return
     */
    private void insert(Node n, double data) {
//        if (data < n.getData()) {
        if (data <= n.getData()) {
            if (n.getLeft() == null) {
                Node t = new Node(data);
                n.setLeft(t);
            } else {
//                System.out.println("You broke it");
                insert(n.getLeft(), data);
            }
        } else if (n.getRight() == null) {
            Node t = new Node(data);
            n.setRight(t);
        } else {
//            System.out.println("You broke the right one");
            insert(n.getRight(), data);
        }
    }

    public int nodeCount() {
        return countNodes(root);
    }

    private int countNodes(Node r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /**
     * Need to adjust that it is searching and return something, also null
     * stuff.
     *
     * @param val
     * @return
     */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node r, int val) {
        if (r.getData() == val) {
            return true;
        }
        if (r.getLeft() != null) {
            if (search(r.getLeft(), val)) {
                return true;
            }
        }
        if (r.getRight() != null) {
            if (search(r.getRight(), val)) {
                return true;
            }
        }
        return false;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }
//    public void inOrder() {
//        Collections.sort(inod);
//        out.print("In Order: ");
//        for (int i = 0; i < inod.size() - 1; i++) {
//            out.print(inod.get(i) + ", ");
//        }
//        out.println(inod.get(inod.size() - 1));
//    }

    public void postOrder() {
        Node lm = root; // Left Most Node
        while (!(lm == null)) {
            lm = lm.getLeft();
        }
        System.out.print("PostOrder: " + lm.getData() + " "); // May be a null pointer error
//        Node tr = lm.getParent(); // Temperary root
        Node tr = lm; // Temperary root
        while (true) {
            if (tr.getRight() != null) {
                out.print(tr.getRight().getData() + " ");
                lm = tr.getLeft();
                while (!(lm == null)) {
                    lm = lm.getLeft();
                }
                tr = lm;
            } else if (tr == root) {
                break;
            } else {
                tr = tr;
            }
        }
    }

    public Node findParent(double k, Node n) {
//        if(k <= n.getData() && T.leftChild(n) == null) {
        if (k <= n.getData()) {
            return n;
//        } else if(k > n.getData() && T.rightChild(n) == null) {
        } else if (k > n.getData()) {
            return n;
        } else if (k <= n.getData()) {
//                findParent(k , T.leftChild(n));
        } else {
//                findParent (k , T.rightChild(n));
        }
        return n;
    }

    public Node getRoot() {
        return root;
    }

    public void printLevels(Node root, int h) {
        if (root == null) {
            return;
        }
        if (h == 1) {
            System.out.print(" " + root.getData());
        } else {
            printLevels(root.getLeft(), h - 1);
            printLevels(root.getRight(), h - 1);
        }
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }
}
