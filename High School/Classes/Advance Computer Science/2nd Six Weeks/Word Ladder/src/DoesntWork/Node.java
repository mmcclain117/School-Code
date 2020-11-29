package DoesntWork;

public class Node {

    private Node b4;
    private Object da;
    private Node ap;

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
        return b4;
    }

    public void setB4(Node b4) {
        this.b4 = b4;
    }

    @Override
    public String toString() {
        return da.toString();
    }
}
