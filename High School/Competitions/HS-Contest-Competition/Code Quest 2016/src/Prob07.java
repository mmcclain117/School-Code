import java.io.File;
import java.util.Scanner;

public class Prob07 {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob07.in.txt"));
		int a = scan.nextInt(); // Number of test
		scan.nextLine();
		for(int i = 0;i < a;i++) {
			int b = scan.nextInt(); // Number of lines
			String l [] = new String[b];
			for(int o = 0;o < b;o++) {
				l[o] = scan.nextLine();
			}
		}
	}

}
