package Part7;

import java.util.ArrayList;

public class LinkedList {

    private int count;
    private Node head;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public void add(Object data) {
        Node te = new Node(data);
        te.setNextPtr(head);
        head = te;
        ++count;
    }

    public Object get(int index) { // Not sure did this right
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
}
