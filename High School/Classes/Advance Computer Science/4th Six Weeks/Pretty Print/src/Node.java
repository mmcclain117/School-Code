
/**
 *
 * @author Master
 */
public class Node {

    private Node right;
    private Node left;
    private double data;

    public Node() {
        right = null;
        left = null;
        data = 0.0;

    }

    public Node(double n) {
        right = null;
        left = null;
        data = n;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(double d) {
        data = d;
    }

    public double getData() {
        return data;
    }

    public Node getParent(Node r) {
        return r;
    }

}
