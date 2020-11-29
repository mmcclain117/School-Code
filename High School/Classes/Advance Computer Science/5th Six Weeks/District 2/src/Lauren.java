import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Lauren {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("x.txt"));
		int n = scan.nextInt(); // number of Cases
		for (int i = 0; i < n; i++) {
			int t = scan.nextInt(); // Number of cities
			Node[] graph = new Node[t + 1];
			ArrayList<String> tovisit = new ArrayList();
			for (int ix = 1; ix < t + 1; ++i) {
				graph[ix] = new Node(ix);
//				tovisit.add(t);
			}
			
		}
	}
}

class Node {

	int id;
	int parent = 0;
	int weight = Integer.MAX_VALUE;

	ArrayList<Vertex> nbrs = new ArrayList<Vertex>();

	public Node(int id) {
		this.id = id;
	}

	public boolean update(int weight, int parent) {
		if (weight < this.weight) {
			this.parent = parent;
			this.weight = weight;
			return true;
		}
		return false;
	}

	public void addNeighbor(Vertex v) {
		nbrs.add(v);
	}
}

class Vertex implements Comparable {

	int n1;
	int n2;
	int weight;

	public Vertex(int n1, int n2, int weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Object o) {
		Vertex v = (Vertex) o;
		if (weight < v.weight) {
			return -1;
		} else {
			return 1;
		}
	}
}
