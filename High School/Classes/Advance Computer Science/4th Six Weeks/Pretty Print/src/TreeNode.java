
import java.util.ArrayList;

public class TreeNode {

    private double x;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(double d) {
        x = d;
        left = null;
        right = null;
    }

    public TreeNode add(double n, TreeNode t) {
        if (t == null) {
            t = new TreeNode(n);
        } else if (n <= t.x) {
            t.left = add(n, t.left);

        } else {
            t.right = add(n, t.right);
        }
        return t;
    }
//    public void inorder(TreeNode r) {

    public ArrayList<Integer> inorder(TreeNode r, ArrayList ar) {
//        ArrayList ar = new ArrayList();
        if (r != null) {
//            System.out.print(r.x + " ");
            inorder(r.left, ar);
            ar.add((int) r.x);
            System.out.print((int) r.x + " ");
            inorder(r.right, ar);
//            System.out.println();
        }
        return ar;
    }

//    public void printLevel(TreeNode r, int l) {
    public String printLevel(TreeNode r, int l) {
        return DS(r, l - 1);
    }

//    public void DS(TreeNode r, int l) {
    public String DS(TreeNode r, int l) {
        if (r != null) {
            if (l > 0) {
                l--;
                DS(r.right, l);
                DS(r.left, l);
            } else if (l == 0) {
                System.out.print((int) r.x + " ");
                return (int) r.x + " ";
            }
        }
        return "";
    }

    public int getNodeHeight(TreeNode root, int x, int height) {
        if (root == null) {
            return 0;
        }
        if (root.x == x) {
            return height;
        }
        //check if the node is present in the left sub tree
        int level = getNodeHeight(root.left, x, height + 1);
        //System.out.println(level);
        if (level != 0) {
            return level;
        }

        //check if the node is present in the right sub tree
        return getNodeHeight(root.right, x, height + 1);
    }

    public int search(TreeNode r, double val, int count) {
        if (r.x == val) {
            return count;
        }
        if (r.left != null) {
//            count = search(r.left, val, count + 1);
            return search(r.left, val, count + 1);
        }
        if (r.right != null) {
//            count = search(r.right, val, count + 1);
            return search(r.right, val, count + 1);
        }
//        return count -1;
        return count;
    }
}
