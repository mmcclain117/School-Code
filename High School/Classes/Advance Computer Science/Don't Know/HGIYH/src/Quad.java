import java.util.ArrayList;
import java.util.LinkedList;

public class Quad {
	public Person[] arr;
	private int NumOfCollisions;
	private int probe;
	private int c;

	@SuppressWarnings("unchecked")
	public Quad(int size) {
		arr = new Person[size];
		probe = 0;
		NumOfCollisions = 0;
	}

	// public Quad() {
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
				index += (index + c * c);
				c++;
				NumOfCollisions++;
			}
		}
	}

	public Person get(Object key) {
		probe = 0;
		int index = Math.abs(key.hashCode()) % arr.length;
		c = 1;
		if (arr[index] == null) {
			return null;
		} else {
			while (index < arr.length) {
				if (arr[index] == null)
					break;
				else {
					index += c * c;
					probe++;
					c++;
				}
			}
		}
		if (index - c * c <= 0) {
			return arr[index];
		} else {
			return arr[index -= c * c];
		}
	}

	public int getNumOfCollisions() {
		return NumOfCollisions;
	}

	public int getProbes() {
		return probe;
	}

}
