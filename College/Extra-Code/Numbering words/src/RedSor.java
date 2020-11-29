import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * @Author Jacob Ward
 * Reduces and sorts files content
 */
public class RedSor {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("Dictionary.txt"));
		ArrayList<String> ar= new ArrayList();
		int con =0;
		while(scan.hasNext()) {
			String te = scan.nextLine().replaceAll("[^A-Za-z]+", ""); // Removes all special characters
			if(!te.equals("")) {
				ar.add(te);
			} else {
				con++;
			}
		}
		System.out.println("Successful: "+ ar.size() + "\nUnsuccessful: " + con);
		Set<String> ts = new TreeSet<>(); 
		ts.addAll(ar); // Adds and sorts all words
		ar.clear();
		ar.addAll(ts); // adding all to the final list
		FileWriter fw = new FileWriter(new File("DictionaryR.txt"));
		while (!ar.isEmpty()) { // writting to new file
			fw.append(ar.remove(0)+ "\r\n");
		} 
		fw.flush();
		fw.close();
	}
}
