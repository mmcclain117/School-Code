import java.io.File;
import java.util.Scanner;

public class Decryption {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("decryption.in"));
		int a = scan.nextInt();
		scan.nextLine();
		for(int p =0; p < a;p++) {
			int b = scan.nextInt();
			scan.nextLine();
			String s = scan.nextLine();
			char ch[] = s.toCharArray();
			int con =0;
			String fin ="";
			while(con < ch.length) {
				StringBuffer sb = new StringBuffer();
				for(int ii =0;ii < b;ii++) {
					if(con + ii > ch.length - 1) {
						break;
					}
					sb.append(ch[con+ii]);
				}
				sb.reverse();
				fin += sb;
				con += b;
			}
			System.out.println(fin);
		}
	}

}
