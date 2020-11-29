
import java.util.Random;

/**
 *
 * @author Master
 */
public class Rand {

    private static Person arr[];
    private static Random r;
    private static Random rr;
    private static int s;
    private static int probe;
    private static int collision;

    public Rand() {
        r = new Random(1);
        rr = new Random(1);
        s = 101;
        arr = new Person[s];
    }

    public Rand(int a) {
        collision = 0;
        probe = 0;
        r = new Random(1);
        rr = new Random(1);
        s = a;
        arr = new Person[a];
    }

    public void put(Object key, Person p) {
        p.setKey(key);
        int index = Math.abs(p.key.hashCode() % arr.length);
//        int index = Math.abs(key.hashCode() % arr.length);
        if (arr[index] == null) {
            arr[index] = p;
        } else {
            collision++;
            index = (int) ((r.nextDouble() % 1) * s) % arr.length;
        }
    }

    public Person get(Object key) {
        int index = Math.abs(key.hashCode()) % arr.length;
        if (arr[index] == null) {
            return null;
        } else {
            probe++;
            index = (int) ((rr.nextDouble() % 1) * s) % arr.length;
        }
        return arr[index];
    }

    public int getC() {
        return collision;
    }

    public int getP() {
        return probe;
    }
}
