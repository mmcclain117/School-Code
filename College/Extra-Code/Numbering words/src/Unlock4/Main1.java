package Unlock4;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
	/*
	 * Custom object to store possible
	 */
	static class cusObj {

		boolean empty;
		// String name; // Name of it
		LinkedList<String> ar;

		// cusObj(String b) {
		cusObj() {
			// name = b;
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

		boolean good() {
			return ar.size() == 1;
		}
	}

	public static void main(String[] args) throws Exception {
		ArrayList<String> ar = new ArrayList<>();
		File f = new File("dictionaries/Dictionary.txt");
		Scanner scan = new Scanner(f);
		while (scan.hasNext()) {
			String temp = scan.nextLine().replaceAll("[^A-Za-z]+", "");
			if (temp.length() == 4) {
				ar.add(temp);
			} else if (temp.length() == 3) {
				// Maybe add here a permutation to make length 4
				ar.add(temp + "1");
				ar.add(temp + "0");
			}
		}
		scan.close();
		// ArrayList<LinkedList<cusObj>> arr = new ArrayList();
		cusObj co[] = new cusObj[10000];
		for (String s : ar) {
			int temp = Integer.parseInt(transfer(s));
			System.out.println(temp);
			if (co[temp] == null) {
				co[temp] = new cusObj();
			}
			co[temp].add(s);
		}
		/**
		 * Count how many duplicate, empty, and good
		 */
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
		/**
		 * Get the good words
		 */

		
		/**
		 * Uses the hashing algorithem to put in faster
		 */
		HashTable hs = new HashTable(9999);
		for (String s : ar) {
			hs.put(s, new Person(transfer(s), s));
		}
		// Check for duplicate and choosing more popular words
		ArrayList<String> com = new ArrayList<>();
		Scanner comon = new Scanner(new File("dictionaries/CommonEnglishWords.txt"));
		while (comon.hasNextLine()) {
			com.add(comon.nextLine());
		}
		HashMap<String, Integer> hm = new HashMap(); // Used to store final words
		for (String s : com) {
			int siz = hs.getSize(s);
			if (siz == 1) { // If only one element
//				hm.put(hs.get(s), s); // Need to edit the adding
			} else if (siz > 1) { // Check for common words

			}
		}

		// System.out.println(ar.get(0));
		// System.out.println(ar.size());
	}

	/*
	 * Translates words to number
	 */
	private static String transfer(String a) {
		char ch[] = a.toCharArray();
		String fin = "";
		for (char c : ch) {
			if (c == '1') {
				fin += 1;
			} else if (c == 'a' || c == 'b' || c == 'c') {
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
				// } else if (c == '0') {
				// fin += 0;
			}

		}
		return fin;
	}
}
