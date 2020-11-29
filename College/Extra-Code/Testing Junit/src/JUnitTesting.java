
public class JUnitTesting {
	public int square(int a) {
		return a * a;
	}

	public int count(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'A') {
				count++;
			}
		}
		return count;
	}
	public static int main(String args[]) {
		return 0;
	}
	public static void mains(String args[]) {
		
	}
}
