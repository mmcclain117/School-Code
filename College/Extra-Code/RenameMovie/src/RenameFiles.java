import java.io.File;
import java.io.FileWriter;

/**
 * 
 * @author Master Ward
 *
 */
/*
 * A program that is able to rename movie files from Flixtor.to to a normal
 * format. Also takes into consideration series names that are in subfolders
 */
public class RenameFiles {

	// Names of paths that using. otherPath is for creating duplicate file names
	// once running the program.
	public static String workspace = "C:\\Users\\Master Ward\\Desktop\\Other Stuff\\"; // The basic workspace Absolute
																						// path
	public static String otherPath = "C:\\Users\\Master Ward\\Documents\\GitHub\\Extra-Code\\RenameMovie\\src\\output\\";

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter(new File("changes.txt"));
		File fold = new File(workspace);
		String ff[] = fold.list(); // First line of folders
		// Determine if Series, Movie, or Neither
		for (int i = 0; i < ff.length; i++) {
			String output = "";
			File temp = new File(workspace + ff[i]);
			if (temp.isDirectory()) { // It is a series
				output = Series(temp);
				fw.write(output + "\r\n");
			} else if (temp.isFile()) {
				String fname = temp.getName();
				if (fname.contains(".mp4") || fname.contains(".mkv")) { // It is a movie
					output = Movie(temp);
					fw.append(output + "\r\n");
					writes(otherPath + temp.getName());
				} else {
					System.out.println("I am unable to process the file because it is neither a movie nor a series.");
					System.out.println("The path " + workspace + ff[i] + " will be ignored");
				}
			} else {
				System.out.println("I am unable to process the file because it is neither a movie nor a series.");
				System.out.println("The path " + workspace + ff[i] + " will be ignored");
			}
		}
		fw.flush();
		fw.close();
	}

	/* Renames that One movie */
	private static String Movie(File temp) {
		String ext[] = temp.getName().split("[.]");
		String name = "";
		int i = 0;
		for (i = 0; i < ext.length - 2; i++) { // Replacing the dots with spaces
			name += ext[i] + " ";
		}
		name += "(" + ext[i] + ")." + ext[i + 1]; // Put the year in parenthesis
//		System.out.println(temp.getName() + " -> " + name);
		renameFile(temp, new File(workspace + name));
		return temp.getName() + " -> " + name;
	}

	/* Renames the series */
	private static String Series(File temp) {
		String output = "";
		File episodes[] = temp.listFiles(); // All episode files
		String seriesName = "";
		if (temp.getName().toLowerCase().contains("blindspot")) {
			seriesName = "Blindspot";
		} else if (temp.getName().toLowerCase().contains("robot")) {
			seriesName = "Mr. Robot";
		} else if (temp.getName().toLowerCase().contains("nikita")) {
			seriesName = "Nikita";
		} else {
			System.out.println("I have no clue what series this is.");
		}
		String fold = temp.getPath() + "\\";
		for (int i = 0; i < episodes.length; i++) { // Parsing the fileName
			String a[] = episodes[i].getName().split("[.]");
			String extension = a[a.length - 1];
			String year = "";
			String episodeName = "";
			String episodeNumber = "";
			int o;
			for (o = 0; o < a.length - 2; o++) { // Separate each part into the corresponding string
				if (year == "") {
					if (isYear(a[o])) {
						year = a[o];
						o++;
						episodeNumber = a[o];
					}
				} else {
					if (a[o].contains("eps")) { // Mr. Robot Exception with Episodes
						episodeName += a[o] + "." + a[o + 1].substring(0, 1) + "_"; // Actually has a _ folowing episode
																					// name
					} else if (a[o - 1].contains("eps")) {
						episodeName += a[o].substring(1);
					} else {
						episodeName += a[o] + " ";
					}
				}
			}
			if (episodes[i].getName().contains("eps")) { // Has the file name
				episodeName += ".";
			}
			episodeName += a[o];
			String newName = episodeNumber + " " + seriesName + " " + episodeName + "." + extension;
			output += episodes[i].getName() + " -> " + newName + "\r\n";
//			System.out.println(otherPath + episodes[i]);
			try {
				writes(otherPath + episodes[i].getName());
				renameFile(episodes[i], new File(fold + newName));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
//			System.out.println(fold + episodes[i] + " -> " + fold + newName);
		}
		return output;
	}

	public static boolean isYear(String a) {
		a = a.trim();
		for (int i = 1950; i < 2020; i++) {
			if (a.equals((i + ""))) {
				return true;
			}
		}
		return false;
	}

	public static boolean renameFile(File oldFileName, File newFileName) {
		return oldFileName.renameTo(newFileName);
	}

	public static void writes(String f) {
		try {
			File n = new File(f);
			File q = new File(otherPath);
			if (!q.exists()) {
				q.mkdir();
			}
//			if(!q.exists() && q.isDirectory()) {
//				q.mkdir();
//			}
			n.createNewFile();
			FileWriter fw = new FileWriter(n);
			fw.append(f + "\r\n");
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
