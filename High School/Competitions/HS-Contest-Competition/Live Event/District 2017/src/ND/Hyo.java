package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Hyo {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("Hyo.dat"));
		int test = scan.nextInt(); // Number of cases
		for (int i = 0; i < test; i++) {
			int a = scan.nextInt(); // Number of People
			ArrayList<Node> nodes = new ArrayList();
			for (int ii = 0; ii < a; ii++) {
				String b[] = scan.nextLine().replaceAll(":", " ").split("[ ]+");
				nodes.add(new Node(b[0], Arrays.copyOfRange(b, 1, b.length - 1)));
			}
			String d[] = scan.nextLine().split("[ ]+");
			String start = d[0];
			String end = d[1];
			int s = 0;
			for (int ix = 0; ix < nodes.size(); ix++) {
				if (nodes.get(ix).getName() == start) {
					s = ix;
					break;
				}
			}
			ArrayList<Node> dead = new ArrayList();
			ArrayList<Node> stChild = new ArrayList(); // Starting children
			boolean found = false;
			stChild.add(nodes.get(s)); // Starting Node
			while(found && !stChild.isEmpty()) {
				Node temp1 = stChild.get(stChild.size() - 1);
				if(dead.contains(temp1)) {
					
				}
			}
		}
	}

}

class Node {
	public String name;
	private ArrayList<String> child;

	public Node(String a, String b[]) {
		name = a;
		child = new ArrayList();
		for (String v : b) {
			child.add(v);
		}
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getChild() {
		return child;
	}
	public boolean hasFriend() {
		return !child.isEmpty();
	}
}