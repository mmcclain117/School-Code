package done;
import java.io.File;
import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs//Prob01.in.txt"));
		int a = scan.nextInt();
		for(int i = 0 ; i < a;i++) {
			int b = scan.nextInt();
			for(int x = 0;x < b;x++) {
				for(int y = 0;y < b;y++) {
					System.out.print("#");				
				}
				System.out.println();
			}
		}
	}
}
