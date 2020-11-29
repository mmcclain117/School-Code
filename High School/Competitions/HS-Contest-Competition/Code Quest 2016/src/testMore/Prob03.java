package testMore;
import java.io.File;
import java.util.Scanner;

public class Prob03 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob03.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			String b = scan.nextLine().replaceAll(", ", " ");
			String s[] = b.split("\\s+"); // Set of data
			int se[] = new int[s.length];
			for (int ix = 0; ix < s.length; ix++) {
				se[ix] = Integer.parseInt(s[ix]);
			}
			if (se[0] == se[1] && se[1] == se[2]) { // Equalateral
				System.out.println("Equilateral");
			} else if (se[0] == se[1] || se[1] == se[2] || se[0] == se[2]) { // Isosceles
				System.out.println("Isosceles");
			} else {
				if(Math.pow(se[0] , 2) + Math.pow(se[1] , 2) > Math.pow(se[2], 2)) {
					System.out.println("Scalene");
				} else {
					System.out.println("Not a Triangle");
				}
			}
		}
	}

}
