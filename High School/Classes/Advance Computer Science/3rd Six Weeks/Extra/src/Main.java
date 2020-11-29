
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author Master
 */
public class Main {

    public static void main(String[] args) {
        LinkedHashSet lhh = new LinkedHashSet();
        HashSet hs = new HashSet();
        HashMap<String, Integer> hm = new HashMap();
        hm.put("as", 10);
        hm.put("a", 11);
        out.println(Arrays.toString(hm.keySet().toArray()));
        TreeSet ts = new TreeSet();

        Vector<Integer> v = new Vector();
        v.add(10);
        LinkedList ll = new LinkedList();
        PriorityQueue pq = new PriorityQueue();
        TreeMap tm = new TreeMap();
        lhh.add("This");
        lhh.add("a");
//        lhh.add("a");
        lhh.add("Pain in the ass");
        out.println(lhh.size() + " " + Arrays.toString(lhh.toArray()));
    }
}
