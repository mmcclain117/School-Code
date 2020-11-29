package PhoneText;

import java.io.File;
import java.util.Scanner;

public class Main1 {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("x.txt"));
		String a = scan.nextLine();
		String b = a.substring(3);
		char ch[] = b.toCharArray();
		for (int i = 0; i < ch.length - 1; i++) { // Where it starts on number
			for (int o = i; o < ch.length; o++) { // converter loop
				for (int k = 0; k < 3; k++) { // All the letter combination of a letter
//					print(a);
					System.out.print(a.substring(0, i) + " ");
					System.out.println(a.substring(o));
				}
			}
		}	
	}

	private static void print(String a) {
		System.out.print(a.substring(0, 3));
//		System.out.println();
	}
	private static String trans(String a) {
		char ch[] = a.toCharArray();
		String b = "";
		for(int i =0;i < ch.length;i++) {
			if(ch[i] < 47) {
				b += 'a';
			}
		}
		return b;
	}
}
