import java.util.ArrayList;
import java.util.LinkedList;

public class Linear {
	public Person[] arr;
	private int NumOfCollisions;
	private int probe;

	@SuppressWarnings("unchecked")
	public Linear(int size) {
		arr = new Person[size];
		probe = 0;
		NumOfCollisions = 0;
	}

	// public Linear() {
	// arr = new Person[101];
	// }

	public void put(Object key, Person p) {
		p.setKey(key);
		int index = Math.abs(key.hashCode() % arr.length);
		while (index < arr.length) {
			if (arr[index] == null) {
				arr[index] = p;
				break;
			} else {
				index++;
				NumOfCollisions++;
			}
		}
	}

	public Person get(Object key) {
		probe = 0;
		int index = Math.abs(key.hashCode()) % arr.length;
		if (arr[index] == null) {
			return null;
		} else {
			while (index < arr.length - 1) {
				if (arr[index] == null)
					break;
				else {
					index++;
					probe++;
				}
			}
		}
		return arr[index--];
	}

	public int getNumOfCollisions() {
		return NumOfCollisions;
	}

	public int getProbes() {
		return probe;
	}
}
