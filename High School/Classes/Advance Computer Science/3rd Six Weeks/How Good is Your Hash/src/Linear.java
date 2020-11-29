
public class Linear {

    private static Person arr[];
    private static int collision;
    private static int probe;

//    public Linear() {
//        arr = new Person[101];
//    }
    public Linear(int a) {
        probe = 0;
        collision = 0;
        arr = new Person[a];
    }

    public void put(Object key, Person p) {
        p.setKey(key);
        int index = Math.abs(p.key.hashCode() % arr.length);
//        int index = Math.abs(key.hashCode() % arr.length);
        while (index < arr.length) {
            if (arr[index] == null) {
                arr[index] = p;
                break;
            } else {
                collision++;
                index++;
            }
        }
    }

    public Person get(Object key) {
//        int index = Math.abs(key.hashCode()) % arr.length;
        int index = Math.abs(key.hashCode()) % arr.length;
        if (arr[index] == null) {
            return null;
        } else {
            while (index < arr.length - 1) {
                if (arr[index] == null) {
                    break;
                } else {
                    probe++;
                    index++;
                }
            }
            return arr[index--];
        }
    }

    public int getC() {
        return collision;
    }

    public int getP() {
        return probe;
    }
}
