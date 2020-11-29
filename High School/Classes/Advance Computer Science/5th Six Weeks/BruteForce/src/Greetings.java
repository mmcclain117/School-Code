import java.io.File;
import java.util.Scanner;

public class Greetings {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("greetings.in"));
		int val = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < val; i++) {
			String name = scan.nextLine();
			System.out.println("Hello " + name + "!");
		}
	}
}
