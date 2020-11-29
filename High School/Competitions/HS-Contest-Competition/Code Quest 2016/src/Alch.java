import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alch {
	public static ArrayList<String> output;
	private static int[] numb;
	private static boolean[] used;
	private static int findSum;

	public static void main(String[] args) throws Exception {
		// Scanner scan = new Scanner(new File("Alch.in"));
		Scanner scan = new Scanner(new File("algosrhythm.in"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int ii = 0; ii < a; ii++) {
			output = new ArrayList();
			int b = scan.nextInt();
			findSum = b;
			numb = new int[b + (b / 2) + 1 + (b / 3)];
			// System.out.println(b);
			for (int ip = 0; ip < b; ip++) {
				numb[ip] = 1;
				// numb[ip + (b * 2)] = 4;
			}
			for (int ip = 0; ip < (b / 2) + 1; ip++) {
				numb[b + ip] = 2;
			}
			for (int ip = 0; ip < (b / 3); ip++) {
				numb[(b + b / 2) + 1 + ip] = 4;
			}
			// System.out.println(Arrays.toString(numb));
			// fill used array to false before we start
			used = new boolean[numb.length];
			Arrays.fill(used, false);
			findSums(0, "");
			System.out.println(output.size());
			/*
			 * for(String s : output){ System.out.println(s); }
			 */
			output.clear();
		}
	}

	private static void findSums(int runningSum, String outStr) { // Recursively
																	// Find Sum
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
							temp = outStr + "" + numb[i];
						}
						findSums(runningSum + numb[i], temp);
						used[i] = false;
					} else { // Found it
						i = numb.length;
						keepGoing = false;
						// break;
					}
				}
			}
		}
	}
}
