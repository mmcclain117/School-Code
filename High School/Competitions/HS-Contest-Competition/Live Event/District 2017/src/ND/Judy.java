package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Judy {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("Judy.dat"));
		String x = scan.nextLine();
		String y[] = x.split("[ ]+");
//		Node n1 = new Node(y[0]);
		ArrayList<Node> nod = new ArrayList<>();
//		Tree t = new Tree(n1); // Starting Tree
		ArrayList<Tree> ta = new ArrayList<>(); // ArrayList of Trees
		for(String p:y) {
			Node n = new Node(p);
			nod.add(n);
			Tree t = new Tree(n);
			ta.add(t);
		}
		while(!ta.isEmpty()) {
			Tree t =ta.remove(0);
			
		}
	}

}

class Node {
	public char left;
	public char right;
	public char id;

	public Node(String a) {
		id = a.charAt(0);
		left = a.charAt(1);
		right = a.charAt(2);
	}

	public Node(char a, char b, char c) {
		id = a;
		left = b;
		right = c;
	}
}

class Tree {
	public Node id;
	public Node right;
	public Node left;

	public Tree(Node a) {
		id = a;
		right = null;
		left = null;
	}

	public Tree(Node a, Node b, Node c) {
		id = a;
		left = b;
		right = c;
	}
}
