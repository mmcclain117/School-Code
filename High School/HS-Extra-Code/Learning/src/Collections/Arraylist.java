package Collections;

import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Arraylist {

    private Object[] ar;

    public Arraylist() {
        ar = new Object[0];
    }

    public void add(Object o) {
        Object[] te = new Object[ar.length + 1];
        for (int i = 0; i < ar.length; i++) {
            te[i] = ar[i];
        }
        te[ar.length] = o;
        ar = te;
    }

    public void add(int n, Object o) {
        Object[] te = new Object[ar.length + 1];
        for (int i = 0; i < ar.length; i++) {
            if (i == n) {
                te[i] = o;
            } else if (i > n) {
                te[i] = ar[i - 1];
            } else if (i < n) {
                te[i] = ar[i];
            }
        }
        if (ar.length == n) {
            te[ar.length] = o;
        } else {
            te[ar.length] = ar[ar.length - 1];
        }
        ar = te;
    }

    public void remove(int i) {
        Object[] te = new Object[ar.length - 1];
        int con = 0;
        while (con < ar.length) {
            if (con == i) {
            } else if (con > i) {
                te[con - 1] = ar[con];
            } else {
                te[con] = ar[con];
            }
            con++;
        }
        ar = te;
    }

    public void remove(Object o) {
        boolean cont = false; // Contains 
        int ind = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == o) {
//                out.println(ar[i] + " " + o + " " + i);
                cont = true;
                ind = i;
                break;
            }
        }
        if (cont) {
            Object[] te = new Object[ar.length - 1];
            int con = 0;
            while (con < ar.length) {
                if (con == ind) {
                } else if (con > ind) {
                    te[con - 1] = ar[con];
                } else {
                    te[con] = ar[con];
                }
                con++;
            }
            ar = te;
        }
    }

    public void set(int i, Object o) {
        ar[i] = o;
    }

    public int size() {
        return ar.length;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = ar.length - 1; i > 0; i--) {
            if (ar[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public Object get(int i) {
        return ar[i];
    }

    public boolean contains(Object o) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == o) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        ar = new Object[0];
    }

    public String toString() {
        String fin = "[";
        if (ar.length == 0) {
            return fin + "]";
        } else {
            for (int i = 0; i < ar.length - 1; i++) {
                fin += ar[i] + ", ";
            }
            return (fin + ar[ar.length - 1] + "]");
        }
    }
}
