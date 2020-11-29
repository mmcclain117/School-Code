import java.util.LinkedList;

//OPEN          CHAINING
public class HashTable {

	public LinkedList<Person> arr[];
	private int NumOfCollisions;
	private int probes;

	public HashTable(int size) {
		arr = new LinkedList[size];
		probes = 0;
		NumOfCollisions = 0;
	}

	public HashTable() {
		arr = new LinkedList[101];
		probes = 0;
		NumOfCollisions = 0;
	}

	public void put(Object key, Person p) {
		p.setKey(key);
		int index = Math.abs(key.hashCode() % arr.length);
		if (arr[index] == null) {
			arr[index] = new LinkedList<Person>();
		} else {
			NumOfCollisions++;
		}
		arr[index].add(p);

	}

	public Person get(Object key) {
		probes = 0;
		int index = Math.abs(key.hashCode()) % arr.length;
		if (arr[index] == null) {
			return null;
		}
		for (int i = 0; i < arr[index].size(); i++) {
			if (arr[index].get(i).getKey().equals(key))
				return arr[index].get(i);
			probes++;
		}
		return null;
	}

	public int getNumOfCollisions() {
		return NumOfCollisions;
	}

	public int getProbes() {
		return probes;
	}

}
