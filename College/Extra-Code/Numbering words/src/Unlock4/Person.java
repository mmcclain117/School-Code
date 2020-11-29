package Unlock4;

public class Person {

    String name;
    String id;
    Object key;

    public Person(String idnum , String Name) {
    	id= idnum;
    	name = Name;
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

//    public String getNumber() {
//        return number;
//    }

    public String toString() {
        return name + " " + " " + id;
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
