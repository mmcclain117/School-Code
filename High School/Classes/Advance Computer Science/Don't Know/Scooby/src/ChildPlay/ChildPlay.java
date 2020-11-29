package ChildPlay;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ChildPlay {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("play.dat"));
		int test = scan.nextInt();
		scan.nextLine();
		for (int io = 0; io < test; io++) {
			int n = scan.nextInt(); // Number of dominos
			LinkedList<Integer> maps[] = new LinkedList[n + 1];
			boolean visited[] = new boolean[n + 1];
			for (int i = 0; i < n + 1; i++) {
				LinkedList<Integer> ll = new LinkedList<>();
				maps[i] = ll;
			}
			int m = scan.nextInt(); // X and Y
			int z = scan.nextInt(); // Number pushed
			scan.nextLine();
			for (int i = 0; i < m; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				maps[x].add(y);
			}
			for (int ipo = 0; ipo < z; ipo++) { // Numbers poking
				int nex = scan.nextInt(); // Poking Number
				visited[nex] = true;
				Stack<Integer> s = new Stack<>();
				LinkedList<Integer> curll = maps[nex];
				while (!curll.isEmpty()) {
					Integer curNum = curll.removeFirst();
					visited[curNum] = true;
					s.add(curNum);
				}
				while (!s.isEmpty()) {
					Integer cur = s.pop();
					curll = maps[cur];
					while (!curll.isEmpty()) {
						Integer curNum = curll.removeFirst();
						visited[curNum] = true;
						s.add(curNum);
					}
				}
			}
			int con = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
//					System.out.println(i);
					con++;
				}
			}
			System.out.println(con);
			/*
			 * for (int i = 0; i < maps.length; i++) { // Prints out the paths
			 * System.out.print(i + " "); LinkedList temp = maps[i];
			 * System.out.println(Arrays.toString(temp.toArray())); }
			 */
		}
	}
}
