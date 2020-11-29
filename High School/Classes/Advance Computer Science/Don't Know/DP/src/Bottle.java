import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bottle {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("bottles.dat"));
		int test = scan.nextInt();
		for (int ii = 0; ii < test; ii++) {
			int b = scan.nextInt(); // Number of bottles
			ArrayList<Integer> val = new ArrayList<>();
			for (int i = 0; i < b; i++) {
				val.add(scan.nextInt());
			}
			ArrayList<Integer> lastbests = new ArrayList<>();
			int lastbest = 0;
			for (int q = 0; q < val.size(); ++q) {
				if (q - 1 == -1) {
					lastbest = val.get(0);
					lastbests.add(lastbest);
				} else if (q - 1 == 0) {
					if (val.get(0) > val.get(1)) {
						lastbest = val.get(0);
						lastbests.add(lastbest);
					} else if (val.get(1) > val.get(0)) {
						lastbest = val.get(1);
						lastbests.add(lastbest);
					} else if (val.get(0) == val.get(1)) {
						lastbest = val.get(0);
						lastbests.add(lastbest);
					}
					} else {
					int temp = val.get(q);
					int temp2 = lastbests.get(q - 2);
					if (temp + temp2 > lastbest) {
						lastbest = temp + temp2;
						lastbests.add(lastbest);
					} else if (temp + temp2 < lastbest) {
						lastbests.add(lastbest);
					} else if (temp + temp2 == lastbest) {
						lastbests.add(lastbest);
					}
				}
			}
			System.out.println(lastbest);
		}
	}
}
