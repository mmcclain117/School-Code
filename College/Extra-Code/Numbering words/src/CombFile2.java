import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author Master
 *
 * Combines all Text Files in a folder
 */
public class CombFile2 {

	public static void main(String[] args) throws Exception {
		ArrayList<String> ar = new ArrayList<>();
		File f = new File("common"); // Folder
		File q[] = f.listFiles(); // files of folder
		for (int i = 0; i < q.length; i++) {
			ar.addAll(readIn(q[i]));
		}
		// Adds all getting rid of duplicates and sorting 
		Set<String> ts = new TreeSet<>(); 
		ts.addAll(ar); // Adds all words to be sorted and remove duplicates
		ar.clear(); 
		ar.addAll(ts); // Clear and add to final arrayList
//		Collections.sort(ar);
		FileWriter fw = new FileWriter(new File("common/commonwords.txt"));
		while (!ar.isEmpty()) { // Write all of the list to a file
			fw.append(ar.remove(0)+ "\r\n");
		} 
		fw.flush();
		fw.close();
	}

	public static ArrayList<String> readIn(File q) throws Exception {
		ArrayList<String> ar = new ArrayList();
		Scanner scan = new Scanner(q);
		while (scan.hasNextLine()) { // read in the files
			ar.add(scan.nextLine().toLowerCase()); // adds lowercase in list
		}
		return ar;
	}
}
