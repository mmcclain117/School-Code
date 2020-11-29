package done;
import java.io.File;
import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob02.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int ii = 0; ii < a; ii++) {
			String b = scan.nextLine(); // Amount
			System.out.println(b);
			double amo = Double.parseDouble(b.substring(1));
			int qu = 0; // Quarters
			int di = 0; // Dimes
			int ni = 0; // Nickels
			int pe = 0; // Pennies
			qu = (int) (amo / .25);
			amo %= .25;
			di = (int) (amo / .1);
			amo %= .1;
			ni = (int) (amo / .05);
			amo %= .05;
			pe = (int) (amo / .01);
			amo %= .01;
			System.out.println("Quarters=" + qu);
			System.out.println("Dimes=" + di);
			System.out.println("Nickels=" + ni);
			System.out.println("Pennies=" + pe);
		}
	}
}
