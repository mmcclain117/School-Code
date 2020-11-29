
public class Node {

    private Object da;
    private Node ap;
    private Node b;

    Node() {
    }

    Node(Object data) {
        da = data;
    }

    public void set(Object data) {
        da = data;
    }

    public Object get() {
        return da;
    }

    public void setNextPtr(Node next) {
        ap = next;
    }

    public Node getNextPtr() {
        return ap;
    }

    public Node getB4() {
        return b;
    }

    public void setB4(Node b1) {
        b = b1;
    }

    @Override
    public String toString() {
        return da.toString();
    }
}
