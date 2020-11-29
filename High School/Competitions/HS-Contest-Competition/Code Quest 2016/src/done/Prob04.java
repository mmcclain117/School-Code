package done;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Prob04 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob04.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			String b = scan.nextLine();
			System.out.print(b + " = ");
			String c[] = b.replace("|" , " ").split("\\s+");
			String w1 = c[0]; // Word 1
			String w2 = c[1]; // Word 2
//			System.out.println(w1 + " "+ w2);
			if (w1.equals(w2) || w1.length() != w2.length()) {
				System.out.println("NOT AN ANAGRAM");
			} else {
				System.out.println((work(w1, w2) ? "ANAGRAM":"NOT AN ANAGRAM"));
			}
		}
	}

	private static boolean work(String a, String b) {
		char ch1[] = new char[a.length()];
		char ch2[] = new char[b.length()];
		for (int x = 0; x < a.length(); x++) {
			ch1[x] = a.charAt(x);
			ch2[x] = b.charAt(x);
		}
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}
}
