import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		File f = new File("s.txt");
		FileWriter fw = new FileWriter(new File("src//out.txt"));
		Scanner scan = new Scanner(f);
		String x = "";
		String temp = "";
		while (scan.hasNext()) {
			temp = scan.nextLine();
			if (temp.contains("</a")) {
				int qr = temp.indexOf("</a>");
				if (qr > 0) {
					if (temp.length() < 100) { // Prints as is
						x += temp + "\n";
					} else if(qr > 50){ // Cuts off parts of the line
						temp = temp.substring(40, qr + 5) + "\n\t\r";
						x += temp;
					} else {
						x += temp + "\n\t\r";
					}
				}
			}
			System.out.println(temp.length());
		}
		x = x.replaceAll("</span", "");
		x = x.replaceAll("<BR", "");
		x = x.replaceAll("</td>", "");
		x = x.replaceAll("</th>", "");
		
//		String qx = "";
//		Pattern p = Pattern.compile("<\\S+>(\\S+)<\\S+>");
//		Matcher m = p.matcher(x);
//		while(!m.hitEnd()) {
//			String codegroup = m.group();
//			qx += codegroup + "\t\t";
//			System.out.println("This is good");
//		}

		System.out.println(x);
		fw.write(x);
		fw.flush();
		fw.close();
		scan.close();

	}
}
