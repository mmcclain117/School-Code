import java.io.File;
import java.util.Scanner;


public class Alchemy {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(new File("alchemy.in"));
		int a = scan.nextInt();
		String name[] = new String[a];
		double val[] = new double[a];
		for(int i =0;i < a;i++) {
			name[i] = scan.next();
			val[i] = scan.nextDouble();
		}
		int v = scan.nextInt();
		for(int i = 0;i < v;i++) {
			String n = scan.next();
			double d = scan.nextDouble();
			int p = 0;
			for(int ii =0;ii < a;ii++) {
				if(name[ii].equals(n)) {
					p =ii;
					break;
				}
			}
			System.out.printf("%s %.3f\n" , n ,(d * val[p]));
		}
	}

}
