package done;
import java.io.File;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob05.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int ii = 0; ii < a; ii++) {
			String b = scan.nextLine(); // Amount
			System.out.println("Total of the bill: "+b);
			double amo = Double.parseDouble(b.substring(1));
			System.out.print("15% = $");
			System.out.printf("%.2f\n" , (amo * .15));
			System.out.print("18% = $");
			System.out.printf("%.2f\n" , (amo * .18));
			System.out.print("20% = $");
			System.out.printf("%.2f\n" , (amo * .2));
		}
	}
}
