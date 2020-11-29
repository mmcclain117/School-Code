
import java.io.*;
import java.util.*;

public class BottleMemo {
	public static int[] memo;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("bottles.dat"));
		int cases = scan.nextInt();
		scan.nextLine();
		for (int ix = 0; ix < cases; ix++) {
			int num = scan.nextInt();
			int[] bottles = new int[num];
			for (int i = 0; i < num; i++) {
				bottles[i] = scan.nextInt();
			}
			memo = new int[num];
			for (int i = 0; i < num; i++) {
				memo[i] = -1;
			}
			int ans = bott(bottles);
			System.out.println(ans);
		}
		scan.close();
	}

	public static int bottles(int[] bottles) {
		if (bottles.length == 1) {
			return bottles[0];
		} else if (bottles.length == 2) {
			return Math.max(bottles[0], bottles[1]);
		} else {
			if (memo[bottles.length - 2] == -1) {
				memo[bottles.length - 2] = bottles(remove(1, bottles));
			}
			if (memo[bottles.length - 3] == -1) {
				memo[bottles.length - 3] = bottles(remove(2, bottles));
			}
			return Math.max(memo[bottles.length - 2], memo[bottles.length - 3] + bottles[bottles.length - 1]);
		}
	}

	public static int bott(int[] bottles) {
		memo[0] = bottles[0];
		memo[1] = Math.max(bottles[0], bottles[1]);
		for (int i = 2; i < bottles.length; i++) {
			memo[i] = Math.max(memo[i - 1], memo[i - 2] + bottles[i]);
		}
		return memo[memo.length - 1];
	}

	static int[] remove(int num, int[] arr) {
		int[] ret = new int[arr.length - num];
		System.arraycopy(arr, 0, ret, 0, arr.length - num);
		return ret;
	}
}