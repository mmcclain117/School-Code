import java.util.*;
import java.io.*;

/* Add a character count */
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("BibleNIV.txt"));
		FileWriter wordFreqOut = new FileWriter(new File("Word Frequency.txt"));
		FileWriter charFreqOut = new FileWriter(new File("Character Frequency.txt"));
		FileWriter statFreqOut = new FileWriter(new File("Stats.txt"));
		TreeMap<String, Integer> wordFreq = new TreeMap<String, Integer>();
		TreeMap<Character, Integer> charFreq = new TreeMap<Character, Integer>();
		String a = "";
		String ts[];
		char ch[];
		long numbWord = 0;
		long numbChar = 0;
		while (scan.hasNextLine()) {
			a = scan.nextLine();
			ts = a.split("\\s+");
			numbWord += ts.length;
			ch = a.toCharArray();
			numbChar += ch.length;
			
			/* Insert String Frequency into WordFreq */
			for (String q : ts) {
				q = q.replaceAll("[^a-zA-Z]+", ""); // Get Rid of symbols
				Integer val = wordFreq.get(q);
				if (val != null) { // Currently in the TreeMap
					wordFreq.put(q, new Integer(val + 1));
				} else {
					wordFreq.put(q, 1);
				}
			}
			
			/* Insert Character Frequency into CharFreq */
			for (char q : ch) {
				Integer val = charFreq.get(q);
				if (val != null) { // Currently in the TreeMap
					charFreq.put(q, new Integer(val + 1));
				} else {
					charFreq.put(q, 1);
				}
			}
		}
		scan.close();
		
		/* Writes the Frequency to a file */
		Object keys[] = wordFreq.keySet().toArray();
		Object vals[] = wordFreq.values().toArray();

		Arrays.sort(vals); // Values to look for	
		/* Right here uses somewhat of a selection sort method */
		// for (int i = 0; i < vals.length; i++) { // Min to max
		for (int i = vals.length - 1; i >= 0; i--) { // Max to min
			for (String name : wordFreq.keySet()) {
				if (wordFreq.get(name) == Integer.parseInt(vals[i].toString())) { 
					wordFreqOut.write(name.toString() + " " + vals[i].toString() + "\r\n");
					wordFreq.remove(name);
					break;
				}
			}
		}
		
		keys = charFreq.keySet().toArray();
		vals = charFreq.values().toArray();

		Arrays.sort(vals);
		/* Right here uses somewhat of a selection sort method */
		// for (int i = 0; i < vals.length; i++) { // Min to max
		for (int i = vals.length - 1; i >= 0; i--) { // Max to min
			for (Character name : charFreq.keySet()) {
				if (charFreq.get(name) == Integer.parseInt(vals[i].toString())) {
					charFreqOut.write(name.toString() + " " + vals[i].toString() + "\r\n");
					charFreq.remove(name);
					break;
				}
			}
		}

		statFreqOut.write("Total number of Words: " + numbWord + "\r\n");
		statFreqOut.write("Total number of Characters: " + numbChar + "\r\n");
		/* Can add more stats here if I want */
		
		wordFreqOut.flush();
		wordFreqOut.close();
		charFreqOut.flush();
		charFreqOut.close();
		statFreqOut.flush();
		statFreqOut.close();
	}
}