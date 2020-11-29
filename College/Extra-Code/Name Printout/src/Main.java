
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\maste\\Downloads\\HS-Contest-Competition-master\\HS-Contest-Competition-master");
		File x[] = f.listFiles(); // List original Files
		ArrayList<File> ar = new ArrayList();
		ar.addAll(Arrays.asList(x)); 
		FileWriter fw = new FileWriter(new File("xs.txt"));
		int i = 0; // Iterator counter
		while (i < ar.size()) { // Iterates through List
			// for (int i = 0; i < x.length; i++) {
			// String yy = x[i].getName();
			// if (yy.contains(".mp4")) {
			// yy = yy.replace(".mp4", "");
			// fw.write(yy + "\r\n");
			// }
			if (ar.get(i).isDirectory()) { // If directory
				String yy = ar.get(i).getName();
				if (yy.equals("nbproject") || yy.equals("src") || yy.equals("private") || yy.equals("classes")
						|| yy.equalsIgnoreCase("Build") || yy.equalsIgnoreCase("dist") || yy.equalsIgnoreCase("conf")) {
					// Dont want these names
				} else { // If is a files
					fw.write(yy + "\r\n"); // Write the name
				}
				File q[] = ar.get(i).listFiles(); // add all the files in current directory 
				ar.addAll(Arrays.asList(q));
			}
			i++;
		}
		fw.flush();
		fw.close();
	}

}
