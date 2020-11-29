import java.io.File;
import java.util.Scanner;

public class Suresh {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("Suresh.dat"));
		while (scan.hasNextLine()) {
			String[] sentences = scan.nextLine().replaceAll("[^A-Za-z\\.\\!?\\s]+", "").split("[\\.\\!?]");
			
			System.out.print(sentences.length + " ");

			boolean isFirst = true;
			for (String sent : sentences) {
				String[] words = sent.split("\\s+");

				int lngth = words.length - (isFirst ? 0 : 1);

				System.out.print(lngth + " ");

				String longest = "";
				lngth = 0;

				for (String s : words) {
					if (s.length() >= lngth) {
						lngth = s.length();
						longest = s;
					}
				}

				System.out.print(longest + " ");
				isFirst = false;
			}

			System.out.print("\n");
		}
	}
}
