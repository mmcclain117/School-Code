package done;
import java.io.File;
import java.util.Scanner;

public class Prob11 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob11.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int p = 0; p < a; p++) {
			String b = scan.nextLine();
			String key = scan.nextLine();
			int c = scan.nextInt();
			scan.nextLine();
			if (b.equals("ENCRYPT")) {
				for (int i = 0; i < c; i++) {
					String set = scan.nextLine().trim();
					char ch[] = set.toCharArray();
					for (char cx : ch) {
						// System.out.println(cx + " "+ (cx > 'a'));
						if (!Character.isAlphabetic(cx)) {
							System.out.print(cx);
						} else if (cx > 'a') {
							System.out.print(key.charAt((cx - 'a')));
						} else {
							System.out.print(Character.toUpperCase(key.charAt((cx - 'A'))));
						}
					}
					System.out.println();
				}
			} else {
				for (int i = 0; i < c; i++) {
					String set = scan.nextLine().trim();
					char ch[] = set.toCharArray();
					for (char cx : ch) {
						if (!Character.isAlphabetic(cx)) {
							System.out.print(cx);
						} else if (cx > 'a') {
							System.out.print((char)('a' +key.indexOf((cx) + ""))+ "");
							// System.out.print(key.charAt((cx - 'a')));
						} else {
							System.out.print((char)Character.toUpperCase('a' +key.indexOf(Character.toLowerCase(cx))));
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

}
