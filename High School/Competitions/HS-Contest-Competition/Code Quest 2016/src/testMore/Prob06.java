package testMore;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob06.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int p = 0; p < a; p++) {
			String s = scan.nextLine(); // School
			int b = scan.nextInt(); // Nubmer of Students
			scan.nextLine();
			ArrayList<Student> all = new ArrayList<>();
			for (int i = 0; i < b; i++) {
				String st = scan.nextLine();
				String name = st.substring(0, st.indexOf(":"));
				Student te = new Student(name);
				st = st.substring(st.indexOf(":") + 1);
				String sets[] = st.replaceAll(",", " ").split("\\s+");
				for (String temp : sets) {
					te.increase(temp);
				}
				all.add(te);
//				System.out.println(te.getName() + " "+ te.GPA() + " "+ te.Hour());
			}
			Student win = all.get(0);
			for (int i = 1; i < all.size(); i++) {
				Student hx = all.get(i);
				if (hx.GPA() == win.GPA()) {
					if (hx.Hour() > win.Hour()) {
						win = hx;
					}
				} else if (hx.GPA() > win.GPA()) {
					win = hx;
				}
			}
			System.out.println(s + " = " + win.getName());
		}
	}
}

class Student {
	private String name;
	private int totHour; // Total Hours
	private int grPo; /// Grade Point

	public Student(String n) {
		name = n;
		totHour = 0;
		grPo = 0;
	}

	public void increase(String a) {
		char c = a.charAt(0);
		int b = Integer.parseInt(a.substring(1));
		totHour += b;
		if (c == 'A') {
			grPo += 4 * b;
		} else if (c == 'B') {
			grPo += 3 * b;
		} else if (c == 'C') {
			grPo += 2 * b;
		} else if (c == 'D') {
			grPo += b;
		}
	}

	public double GPA() {
		return (double)grPo / totHour;
	}

	public int Hour() {
		return totHour;
	}

	public String getName() {
		return name;
	}

}
