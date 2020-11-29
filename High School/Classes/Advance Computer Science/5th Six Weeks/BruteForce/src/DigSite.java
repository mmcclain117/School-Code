import java.io.File;
import java.util.Scanner;

public class DigSite {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("digsite.in"));
		int y = scan.nextInt();
		int x = scan.nextInt();
		char ch[][] = new char[y][x];
		for (int i = 0; i < y; i++) {
			ch[i] = scan.nextLine().toCharArray();
		}
		
	}
}
