package Collections;

import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class stack {

    private ArrayList ar;

    public stack() {
        ar = new ArrayList();
    }

    public void push(Object o) {
        ar.add(o);
    }

    public void pop() {
        ar.remove(ar.size() - 1);
    }

    public Object peek() {
        return ar.get(ar.size() - 1);
    }

    public boolean empty() {
        return ar.isEmpty();
    }

    public int search(Object o) {
        for (int i = 1; i < ar.size(); i++) {
            if (ar.get(ar.size() - i) == o) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String fin = "[";
        if (ar.isEmpty()) {
            return fin + "]";
        } else {
            for (int i = 0; i < ar.size() - 1; i++) {
                fin += ar.get(i) + ", ";
            }
            return (fin + ar.get(ar.size() - 1) + "]");
        }
    }
}
