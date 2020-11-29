import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Unlock4 {
	/*
	 * Custom object to store possible
	 */
	static class cusObj {

		boolean empty;
		LinkedList<String> ar;

		cusObj() {
			empty = true;
			ar = new LinkedList<>();
		}

		void add(String q) {
			if (ar.isEmpty()) {
				ar = new LinkedList<>();
				empty = false;
			}
			ar.add(q);
		}

		boolean check(String q) {
			return ar.contains(q);
		}

		boolean good() {
			return ar.size() == 1;
		}

		void reset(String g) {
			ar.clear();
			ar.add(g);
		}

		@Override
		public String toString() {
			String fin = "";
			for (String a : ar) {
				fin += a + " ";
			}
			return fin;
		}

		String getOne() {
			return ar.getFirst();
		}
	}

	public static void main(String[] args) throws Exception {
		ArrayList<String> ar = new ArrayList<>();
		File f = new File("DictionaryR.txt");
		Scanner scan = new Scanner(f);
		while (scan.hasNext()) {
			String temp = scan.nextLine().replaceAll("[^A-Za-z]+", "");
			if (temp.length() == 4) {
				ar.add(temp);
			}
		}
		scan.close();
		cusObj co[] = new cusObj[10000];
		for (String s : ar) {
			int temp = Integer.parseInt(transfer(s));
			if (temp == 1111 || temp == 2222 || temp == 3333 || temp == 4444 || temp == 5555 || temp == 6666
					|| temp == 7777 || temp == 8888 || temp == 9999) {
				// Ignores that it is a possiblilty
			} else {
				if (co[temp] == null) {
					co[temp] = new cusObj();
				}
				co[temp].add(s);
			}
		}
		printStat(co);
		/**
		 * Get the good words
		 */
		Scanner comon = new Scanner(new File("commonwords.txt"));
		while (comon.hasNextLine()) {
			String com = comon.nextLine();
			if (com.length() == 4) {
				int qs = Integer.parseInt(transfer(com));
				try {
					if (co[qs].check(com)) {
						co[qs].reset(com);
					}
				} catch (NullPointerException e) {
					System.out.println("This is empty part");
					co[qs] = new cusObj();
					co[qs].add(com);
				}
			}
		}
		comon.close();
		FileWriter go = new FileWriter(new File("output4.txt"));
		List<cusObj> temps = Arrays.asList(co);
		Collections.shuffle(temps);
		Object sco[] = temps.toArray();
		co = (cusObj[]) sco;
		String x = "";
		for (cusObj s : co) {
			if (s == null) {
//				Fix if it is empty
			} else if (s.good()) {
				x += s.getOne() + " = " + transfer(s.getOne()) + "\r\n";
			}
		}
		go.write(x);
		go.flush();
		go.close();
		printStat(co);
	}

	/*
	 * Translates words to number
	 */
	private static String transfer(String a) {
		char ch[] = a.toCharArray();
		String fin = "";
		for (char c : ch) {
			if (c == 'a' || c == 'b' || c == 'c') {
				fin += 2;
			} else if (c == 'd' || c == 'e' || c == 'f') {
				fin += 3;
			} else if (c == 'g' || c == 'h' || c == 'i') {
				fin += 4;
			} else if (c == 'j' || c == 'k' || c == 'l') {
				fin += 5;
			} else if (c == 'm' || c == 'n' || c == 'o') {
				fin += 6;
			} else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
				fin += 7;
			} else if (c == 't' || c == 'u' || c == 'v') {
				fin += 8;
			} else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
				fin += 9;
			}

		}
		return fin;
	}

	/**
	 * Count how many duplicate, empty, and good
	 */
	private static void printStat(cusObj co[]) {
		int dup = 0;
		int emp = 0;
		int go = 0;
		int dupc = 0;
		for (cusObj s : co) {
			if (s == null) {
				emp++;
			} else if (s.empty) {
				System.out.println("We have a problem");
			} else if (s.good()) {
				go++;
			} else {
				dup++;
				dupc += s.ar.size();
			}
		}
		System.out.println("Duplicate: " + dup + "\nDuplicant word Count: " + dupc);
		System.out.println("Empty: " + emp + "\nGood: " + go);
	}
}
