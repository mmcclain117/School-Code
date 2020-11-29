package DoesntWork;

public class LinkedList {

    Node head;
    Node tail;
    int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Object data) {

        Node top = new Node(data);

        Node middle = head;
        head = top;

        if (size() == 0) {
            tail = top;
        }
        try {

            head.setNextPtr(middle);
            middle.setB4(head);
        } catch (NullPointerException exception) {

        }
        count++;
    }

    public Object dequeue() {
        try {
            Object n = tail.get();
            Node newTail = tail.getB4();
            tail = newTail;
            //tail.setB4(null);
            count--;
            return n;
        } catch (NullPointerException exception) {
            return "";
        }
    }

    public Object peek() {
        Object n = head.get();
        return n;
    }

    public Object get(int index) {
        Node get;
        if (index >= count || index < 0) {
            get = null;

        } else {
            get = head;
            if (index > 0) {
                for (int x = 0; x < index; x++) {
                    get = get.getNextPtr();
                }
            }
        }
        return get.get();
    }

    public int size() {
        return count;
    }
}
