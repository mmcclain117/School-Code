package done;
import java.io.File;
import java.util.Scanner;

public class Prob12 {
	static final boolean[] P3 = new boolean[] { true, false, true, true };

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob12.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			String b = scan.nextLine();
			System.out.println(isCorrupt(b) ? "corrupt" : "ok");
		}
	}

	private static boolean isCorrupt(String line) {
		boolean[] remainder = toBooleanArray(line);
		// convert to booleans
		boolean[] inArray = toBooleanArray(line);
		int dataIdx = 0;
		boolean atTheEnd = false;
		while (!atTheEnd && dataIdx <= inArray.length - 4) {
			int p = 0;
			while (p < 4) {
				// go through each character
				boolean b = remainder[dataIdx];
				remainder[dataIdx] = b ^ P3[p];
				dataIdx++;
				p++;
			}
			if ((p) == inArray.length) {
				atTheEnd = true;
			} else {
				// copy the rest of the remainder down
				for (int i = dataIdx; i < inArray.length; i++) {
					remainder[i] = inArray[i];
				}
				// shift index over to the next 1 in the lineArray
				dataIdx = findNextOne(remainder);
			}
		}
		// Return Remainder
		for (int i = 0; i < remainder.length; i++) {
			if (remainder[i]) {
				return true;
			}
		}
		return false;
	}

	private static int findNextOne(boolean[] remainder) {
		for (int i = 0; i < remainder.length; i++) {
			if (remainder[i])
				return i;
		}
		return remainder.length;
	}

	private static boolean[] toBooleanArray(String line) {
		boolean[] retVal = new boolean[line.length()];
		for (int i = 0; i < line.length(); i++) {
			retVal[i] = line.charAt(i) == '1';
		}
		return retVal;
	}
}
