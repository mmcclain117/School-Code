import java.io.File;
import java.util.Scanner;

public class Prob10 {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob10.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for(int i = 0;i < a;i++) {
			int b = scan.nextInt();
			int alt = 0; // Altitude
			int ele = 0; // Elevation
			for(int o = 0; o < b;o++) {
				String cur = scan.nextLine().replaceAll(",", " ");
				int calt = Integer.parseInt(cur.split("\\s+")[0]); // current Altitude
				
			}
		}
	}
}
