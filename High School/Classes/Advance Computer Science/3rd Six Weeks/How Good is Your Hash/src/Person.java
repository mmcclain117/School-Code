
public class Person {

    String name;
    String number;
    String email;
    String id;
    Object key;

    public Person(String Name, String Number, String EMail, String IDNum) {
        name = Name;
        number = Number;
        email = EMail;
        id = IDNum;
    }

    public void setKey(Object k) {
        key = k;
    }

    public Object getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return name + " " + number + " " + email + " " + id;
    }

    public int hashCode() {
        int sum = 0;
        char ch[] = this.key.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            sum += (int) ch[i];
        }
        return sum;
    }

}
