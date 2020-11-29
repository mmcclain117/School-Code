import java.util.Random;

public class Rand {
	public Person[] arr;
	private int NumOfCollisions;
	private int probe;
	private Random r;
	private Random rr;
	private int s;

	@SuppressWarnings("unchecked")
	public Rand(int size) {
		arr = new Person[size];
		probe = 0;
		s = size;
		NumOfCollisions = 0;
		r = new Random(1);
		rr = new Random(1);
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
				index = (int) ((r.nextDouble() % 1) * s) % arr.length;
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
			while (index < arr.length) {
				if (arr[index] == null)
					break;
				else {
					index = (int) ((rr.nextDouble() % 1) * s) % arr.length;
					probe++;
				}
			}
		}
		return arr[index];
	}

	public int getNumOfCollisions() {
		return NumOfCollisions;
	}

	public int getProbes() {
		return probe;
	}
}
