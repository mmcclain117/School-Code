package Part3;

public class Node {

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

    @Override
    public String toString() {
        return da.toString();
    }
}
