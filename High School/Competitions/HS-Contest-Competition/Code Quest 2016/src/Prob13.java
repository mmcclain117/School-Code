import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prob13 {
	public static ArrayList<String> output;
	private static int[] numb;
	private static boolean[] used;
	private static int findSum;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob13.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int ii = 0; ii < a; ii++) {
			output = new ArrayList<>();
			String b = scan.nextLine();
			b = b.substring(b.indexOf("=") + 1);
			// System.out.println(b.indexOf("="));
			int fins = Integer.parseInt(b); // Goal Sum
			findSum = fins;
			String numbers[] = scan.nextLine().split(",");
//			System.out.println(Arrays.toString(numbers));
			numb = new int[numbers.length];
			for (int ip = 0; ip < numbers.length; ip++) {
				numb[ip] = Integer.parseInt(numbers[ip]);
			}
			Arrays.sort(numb);
			// fill used array to false before we start
			used = new boolean[numb.length];
			Arrays.fill(used, false);
			findSums(0, "");
            for(String s : output){
                 System.out.println(s);
            }
            output.clear();
		}
	}

	private static void findSums(int runningSum, String outStr) { // Recursively Find Sum
		if (runningSum == findSum) { // Found Sum
			// check that we haven't already add it to out output
			if (!output.contains(outStr)) {
				output.add(outStr);
			}
		} else {
			boolean keepGoing = true;
			for (int i = 0; i < numb.length; i++) { // Try next Number
				// check that this number hasn't already been used using same
				// index
				if (!used[i] && keepGoing) {
					// are we still less than the findSum
					if (runningSum + numb[i] <= findSum) {
						// we can use this one
						// set same index as used
						used[i] = true;
						// add it to the string to pass in again
						String temp = "";
						if (outStr.equals("")) {
							// don't add a plus because its the first one
							temp = outStr + numb[i];
						} else {
							// add +
							temp = outStr + "+" + numb[i];
						}
						findSums(runningSum + numb[i], temp);
						used[i] = false;
					} else { // Found it
						i = numb.length;
						keepGoing = false;
					}
				}
			}
		}
	}
}
