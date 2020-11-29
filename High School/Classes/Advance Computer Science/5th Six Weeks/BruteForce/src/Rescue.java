import java.io.File;
import java.util.Scanner;

public class Rescue {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("rescuemission.in"));
		int num = scan.nextInt();
		int num2 = scan.nextInt();
		System.out.println(num % num2);
	}
}
