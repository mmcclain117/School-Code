package rake;

/**
 *
 * @author Master
 */
public class Node {

    private Node right;
    private Node left;
    private int data;
    private int level;

    public Node() {
        right = null;
        left = null;
        data = 0;

    }

    public Node(int n) {
        right = null;
        left = null;
        data = n;
        level = 0;
    }

    public void setLeft(Node n) {
//        left.setParent(n); // Sets leaf parent to n
        left = n;
    }

    public void setRight(Node n) {
//        right.setParent(n); // Sets the leaf parent to n
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }

    public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }
}
