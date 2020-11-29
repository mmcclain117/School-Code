package BinarySearchTree;

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
        root = null;
        inod = new ArrayList();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
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
    private void insert(Node n, int data) {
//        if (data < n.getData()) {
        if (data <= n.getData()) {
            if (n.getLeft() == null) {
                n.setData(data);
                n.setLeft(n);
            } else {
                insert(n.getLeft(), data);
            }
        } else if (data > n.getData()) {
            if (n.getRight() == null) {
                n.setData(data);
                n.setRight(n);
            } else {
                insert(n.getRight(), data);
            }
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

    public void inOrder() {
        Collections.sort(inod);
        out.print("inOrder: ");
        for (int i = 0; i < inod.size(); i++) {
            out.print(inod.get(i) + " ");
        }
        out.println();
    }

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

    /**
     * Need to edit the problem with getting data
     *
     * @param data
     */
    public void delete(int data) {
        if (inod.contains(data)) {
            inod.remove(data);
            Node tr = root;
            while (tr.getData() != data) {
                if (tr.getData() == data) { // Check this
                    root = tr.getLeft();
//                return true;
                } else if (tr.getLeft() != null) {
                    tr = root.getLeft();
                } else if (tr.getRight() != null) {
                    tr = root.getRight();
                }
            }
        } else {
            out.println("That does not exist");
        }
    }

}
