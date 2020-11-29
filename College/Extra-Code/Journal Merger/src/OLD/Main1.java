package OLD;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* PROBLEMS
 * It found the date 2107 10 26
 * Other than that works completely fine
 * */

/* Things to add
 * Separating up to this point file
 * Separating when referring to different days in a file
* Selective words being fixes
* Learning new words from Docx
* Learning names
* Print out stats of it
* Analysis different patterns (How many times a name is mentioned,
* When people are first mentioned
* (Create a timeline of what has happened) - Bonus would be visualizing it
*/

public class Main1 {
	public static ArrayList<File> ar;
	public static String month[] = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	public static Calendar dates[];

	public int main(String filename) {
		try {
			File directory = new File(filename);
			File list[] = directory.listFiles();
			ar = new ArrayList<>();
			traversing(list);
			sort();
			// System.out.println(ar.size());
			writeFile(filename);
			return ar.size();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	/* Writes the merged Journal File */
	private void writeFile(String filename) throws Exception {
		FileWriter fw = new FileWriter(new File(filename + "\\Journal.txt"));
		for (int i = 0; i < ar.size(); i++) {
			String dayName = ar.get(i).getName().replace(".txt", "");
			String words = scanIn(ar.get(i));
			fw.write(dayName + "\r\n" + words);
		}
		fw.flush();
		fw.close();
	}

	/* String to copy from one file to another */
	public String scanIn(File f) throws Exception {
		Scanner scan = new Scanner(f);
		String temp = ""; // File to String
		while (scan.hasNext()) {
			temp += scan.nextLine() + "\r\n";
		}
		scan.close();
		return temp;
	}

	/* Goes through and gets all the files (In this case txt) in a folder */
	public static void traversing(File list[]) {
		add(list);
		int con = 0;

		/* Checks it is a txt file */
		while (con < ar.size()) {
			if (ar.get(con).isDirectory()) {
				add(ar.remove(con).listFiles());
			} else if (!ar.get(con).getName().contains(".txt")) {
				ar.remove(con);
			} else {
				con++;
			}
		}
	}

	/* Adds files from directory to Master ArrayList */
	private static void add(File list[]) {
		for (File q : list) {
			ar.add(q);
		}
	}

	/* IF THEY HAVE THE SAME NAME THINKING ABOUT MERGING BEFOREHAND */
	public static void sort() {
		dates = new Calendar[ar.size()];
		/* Populates the dates with numbers */
		for (int i = 0; i < dates.length; i++) {
			String cur = ar.get(i).getName().replaceAll("[^A-Za-z0-9]+", " ");
			// System.out.println(cur);
			// String cur = ar.get(i).getName().replaceAll(",", "");
			String temp[] = cur.split("[ ]+");
			// System.out.println(temp.length);
			if (temp.length == 4 && temp != null) { // Check if valid format
				// System.out.println(Arrays.toString(temp));
				if (cur.contains("(")) {
					System.out.println(cur);
				}
				/* Value to the month */
				for (int o = 0; o < month.length; o++) {
					if (month[o].equals(temp[0])) {
						int dd = Integer.parseInt(temp[1]); // Day
						int mm = o; // Month
						// int yy = Integer.parseInt(temp[2].replace(".txt", ""));// Year
						int yy = Integer.parseInt(temp[2]);// Year
						dates[i] = new GregorianCalendar(yy, mm, dd);
						// System.out.println(dd + " "+ mm + " " + yy);
						// dates[i].set(yy, mm, dd);
					}
				}
			}
			// System.out.println(Arrays.toString(temp));
		}
		// System.out.println("MADE IT HERE");

		resize();
		// System.out.println("MADE");
		
		/* Sorts the ArrayList ar && Dates Array */
		for (int a = 0; a < dates.length - 1; a++) {
			int minIndex = a;
			for (int b = a + 1; b < dates.length; b++) {
				if (dates[b].before(dates[minIndex])) {
					minIndex = b;
				}
			}

			/* Swap minIndex and a */
			File temp = ar.get(minIndex);
			ar.set(minIndex, ar.get(a));
			ar.set(a, temp);
			Calendar tempx = dates[minIndex];
			dates[minIndex] = dates[a];
			dates[a] = tempx;
		}
		// System.out.println("COULD SORT");
		printAr();
	}

	/* Modifies the array not to have empty dates */
	public static void resize() {
		// System.out.println("Original Size: " + dates.length);
		// System.out.println("THEN Resize");
		ArrayList<Calendar> temp = new ArrayList<>();
		int con = 0; // Dates counter
		int aCon = 0; // ar counter
		// System.out.println("But not here");
		// System.out.println(ar.size() + " " + dates.length);
		while (aCon < ar.size() && con < dates.length) {
			if (dates[con] == null) {
				ar.remove(aCon);
			} else {
				temp.add(dates[con]);
				aCon++;
			}
			con++;
		}
		dates = new GregorianCalendar[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			dates[i] = temp.get(i);
		}
		// System.out.println("New Size: " + dates.length);
	}

	/* Testing the Java Calendar Functions */
	public static void testCal() {
		Calendar calendar = Calendar.getInstance();
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(dayOfYear);
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 10);
		System.out.println("APRIL 10th " + cal.get(Calendar.DAY_OF_YEAR));
	}

	/* Selction sort for array of Ints */
	public static void SelectionSort(int dates[]) {
		for (int a = 0; a < dates.length - 1; a++) {
			int minIndex = a;
			for (int b = a + 1; b < dates.length; b++) {
				if (dates[b] < dates[minIndex]) {
					minIndex = b;
				}
			}
			int temp = dates[minIndex];
			dates[minIndex] = dates[a];
			dates[a] = temp;
		}

		/* Prints the Array */
		for (int i = 0; i < dates.length; i++) {
			System.out.print(dates[i] + " ");
		}
		System.out.println();
	}

	/* Prints the Dates (For right now) Array */
	public static void printAr() {
		for (int i = 0; i < dates.length; i++) {
			System.out.print(dates[i].get(Calendar.YEAR) + " ");
			System.out.print(dates[i].get(Calendar.MONTH) + " ");
			System.out.println(dates[i].get(Calendar.DATE) + " ");
		}
		System.out.println("------");
	}
}
