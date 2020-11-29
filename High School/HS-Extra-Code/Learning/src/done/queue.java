package done;

import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class queue {

    private ArrayList<Object> ar;

    public queue() {
        ar = new ArrayList();
    }

    public void offer(Object o) {
        ar.add(o);
    }

    public void poll() {
        ar.remove(0);
    }

    public Object peek() {
        return ar.get(0);
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
