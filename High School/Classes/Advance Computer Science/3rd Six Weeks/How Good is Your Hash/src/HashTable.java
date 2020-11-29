
import java.util.LinkedList;

public class HashTable {

    public LinkedList<Person> arr[];
    public int collision;

    public HashTable() {
        arr = new LinkedList[101];
    }

    public HashTable(int a) {
        collision = 0;
        arr = new LinkedList[a];
    }

    public void put(Object key, Person p) {
        p.setKey(key);
//        int index = Math.abs(key.hashCode() % arr.length);
        int index = Math.abs(p.key.hashCode() % arr.length);
        if (arr[index] == null) {
            arr[index] = new LinkedList<>();
            arr[index].add(p);
        } else {
            collision++;
            arr[index].add(p);
        }
    }

    public Person get(Object key) {
        int index = Math.abs(key.hashCode()) % arr.length;
        for (int i = 0; i < arr[index].size(); i++) {
            if (arr[index].get(i).getKey().equals(key)) {
                return arr[index].get(i);
            }
        }
        return null;
    }

    public int getC() {
        return collision;
    }
}
