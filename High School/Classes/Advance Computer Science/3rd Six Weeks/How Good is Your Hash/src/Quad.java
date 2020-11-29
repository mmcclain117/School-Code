
public class Quad {

    private static Person arr[];
    private static int collision;
    private static int probe;

    public Quad() {
        arr = new Person[101];
    }

    public Quad(int a) {
        probe = 0;
        collision = 0;
        arr = new Person[a];
    }

    public void put(Object key, Person p) {
        p.setKey(key);
//        int index = Math.abs(key.hashCode() % arr.length);
        int index = Math.abs(p.key.hashCode() % arr.length);
        int con = 1;
        while (index < arr.length) {
            if (arr[index] == null) {
                arr[index] = p;
                break;
            } else {
                collision++;
                index += Math.pow(2, con);
                con++;
            }

        }
    }

    public Person get(Object key) {
        int index = Math.abs(key.hashCode()) % arr.length;
        int con = 1;
        if (arr[index] == null) {
            return null;
        } else {
            while (index < arr.length) {
                if (arr[index] == null) {
                    break;
                } else {
                    probe++;
                    index += Math.pow(2, con);
                    con++;
                }
            }
            if ((index - Math.pow(2, con)) <= 0) {
                return arr[index];
            } else {
                return arr[(index -= Math.pow(2, con))];
            }
        }
    }

    public int getC() {
        return collision;
    }

    public int getP() {
        return probe;
    }

    public String getName(int index) {
        return arr[index].name;
    }
}
