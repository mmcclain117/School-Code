import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Algo {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("algosrhythm.in"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			int co = scan.nextInt();
			run();
			// number of permutations
			if (co == 1) {
				System.out.println("1");
			} else if (co == 2) {
				System.out.println("2");
			} else if (co == 3) {
				System.out.println("3");
			} else if (co == 4) {
				System.out.println("6");
			} else {
				int fin = 1;
				int con = co - 2;
				while(con > 2) {
				fin += con;
				con -= 1;
				}
				fin += con;
//				System.out.println(con);
				System.out.println(fin);
			}
		}
/*
		for (int i = 0; i < 10; i++) {
			int dp = dp(i);
			System.out.print(i + " ");
			System.out.print(dp + " ");
			System.out.println(.5 * dp);
			System.out.println(dp (3) + " "+ dp(4));
			System.out.println(dp / (dp(3)* dp(4)));
		}*/
	}

	public static int dp(int n) {
		int sum = 1;
		for (int s = 1; s < n; s++) {
			sum *= s;
		}
		return sum;
	}

}
