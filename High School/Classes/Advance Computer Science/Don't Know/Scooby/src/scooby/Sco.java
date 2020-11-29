package scooby;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Sco {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("play3.dat"));
		int test = scan.nextInt();
		scan.nextLine();
		for (int io = 0; io < test; io++) {
			String a = scan.nextLine();// Paths
			String go = scan.nextLine(); // Goal
			String paths[] = a.split("//s+");
			ArrayList<Node> maps = new ArrayList();
			
			
			
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
					System.out.println(i);
					con++;
				}
			}
			System.out.println(con);
			for (int i = 0; i < maps.length; i++) { // Prints out the paths
				System.out.print(i + " ");
				LinkedList temp = maps[i];
				System.out.println(Arrays.toString(temp.toArray()));
			}
		}
	}
}

class Node {
	public String id;
	public ArrayList<String> ls;

	public Node(String a) {
		id = a.charAt(0) + "";
		ls = new ArrayList();
		ls.add(a.charAt(1) + "");
	}
}