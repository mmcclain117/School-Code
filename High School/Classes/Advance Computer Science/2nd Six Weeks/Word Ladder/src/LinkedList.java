
public class LinkedList {

    private int count;
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        count = 0;
        tail = null;
    }

    public void add(Object data) {
        Node te = new Node(data);
        Node middle = head;
        head = te;
        if (size() == 0) {
            tail = te;
        }
        try {
            head.setNextPtr(middle);
            middle.setB4(head);
        } catch (NullPointerException e) {
        }
        ++count;

    }

    public Object dequeue() {
        try {
            Object n = tail.get();
            Node nt = tail.getB4();
            tail = nt;
            --count;
            return n;
        } catch (NullPointerException exception) {
            return "";
        }
    }

    public Object get(int index) {
        if (index >= count || index < 0) {
            return null;
        } else {
            Node current = new Node();
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNextPtr();
            }
            return current;
        }
    }

    public int size() {
        return count;
    }

    public Object peek() {
        return head.get();
    }
}
