
import java.util.ArrayList;

public class Node {

    private double x;
    private Node left;
    private Node right;

    public Node(double d) {
        x = d;
        left = null;
        right = null;
    }

    public Node add(double n, Node t) {
        if (t == null) {
            t = new Node(n);
        } else if (n <= t.x) {
            t.left = add(n, t.left);

        } else {
            t.right = add(n, t.right);
        }
        return t;
    }

    public ArrayList<Integer> inorder(Node r, ArrayList ar) {
        if (r != null) {
            inorder(r.left, ar);
            ar.add((int) r.x);
            System.out.print((int) r.x + " ");
            inorder(r.right, ar);
        }
        return ar;
    }

    public int getNodeHeight(Node root, int x, int height) {
        if (root == null) {
            return 0;
        }
        if (root.x == x) {
            return height;
        }
        int level = getNodeHeight(root.left, x, height + 1);
        if (level != 0) {
            return level;
        }
        return getNodeHeight(root.right, x, height + 1);
    }
}
