package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Master
 */
public class Hashset {

//  Points
//  Doesn't maintain order, returned at random
//  No duplicates, When adding duplicate replaces old one
//  Adds null but only one
//  Non-synchronized
    private ArrayList ar;

    public Hashset() { // Creates new HashSet
        ar = new ArrayList();
    }

    public void add(Object e) {
        boolean isThere = false;
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == e) {
                isThere = true;
            }
        }
        if (!isThere) {
            if (e == null) {
                ar.add(0, e);
            } else {
                int size = ar.size();
                for (int i = 0; i < ar.size(); i++) {
                    if (ar.get(i).hashCode() > e.hashCode()) { // Checks the point to put the element 
                        ar.add(i, e);
                        break;
                    }
                }
                if (size == ar.size()) { // Adds if equals or the last element
                    ar.add(e);
                }
            }
        }
    }

    public void clear() {
        ar = new ArrayList();
//        while (!ar.isEmpty()) {
//            ar.remove(0);
//        }
    }

    public boolean contains(Object o) {
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == o) {
                return true;
            }
        }
        return false;
    }

    public void remove(Object o) {
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == o) {
                ar.remove(i);
            }
        }
    }

    public boolean isEmpty() {
        return ar.size() == 0;
    }

    public String toString() {
        return Arrays.toString(ar.toArray());
    }
}
