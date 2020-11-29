
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class LabRats {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("rats.dat"));
		int test = scan.nextInt(); // Number of test
		for (int ip = 0; ip < test; ip++) {
			scan.nextLine();
			int n = scan.nextInt(); // Number of cells
			int e = scan.nextInt(); // Number of exit cells
			int t = scan.nextInt(); // Count down timer
			int m = scan.nextInt(); // Number of connections
			ArrayList<Graph.Edge> graph = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int c = scan.nextInt();
				graph.add(new Graph.Edge(a, b, c));
			}
			int sum = 0;
			Graph g = new Graph(graph);
			for (int i = 1; i <= n; i++) {
				g.dijkstra(i);
				// System.out.print(i + " ");
				sum += g.printPath(e, t);
			}
			System.out.println(sum);
		}
	}
}

class Graph {
	private final Map<Integer, Vertex> graph;

	public static class Edge {
		public final int v1, v2, dist;

		public Edge(int vx, int vy, int d) {
			v1 = vx;
			v2 = vy;
			dist = d;
		}
	}

	public static class Vertex implements Comparable<Vertex> {
		public final int name;
		public int dist = Integer.MAX_VALUE;
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();

		public Vertex(int n) {
			name = n;
		}

		private int printPath(int path) {
			if (this == this.previous) {
				return path;
			} else if (this.previous == null) {
				return Integer.MAX_VALUE;
			} else {
				return this.previous.printPath(path) + this.dist;
			}
		}

		public int compareTo(Vertex other) {
			if (dist == other.dist)
				return name == other.name ? 0 : -1;
			return Integer.compare(dist, other.dist);
		}

	}

	public Graph(ArrayList<Graph.Edge> edges) { // Build the graph
		graph = new HashMap<>(edges.size());
		for (Edge e : edges) {
			if (!graph.containsKey(e.v1))
				graph.put(e.v1, new Vertex(e.v1));
			if (!graph.containsKey(e.v2))
				graph.put(e.v2, new Vertex(e.v2));
		}
		for (Edge e : edges) {
			graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
			// graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); //
			// Undirestional Graphs
		}
	}

	public void dijkstra(int startName) {
		final Vertex source = graph.get(startName);
		NavigableSet<Vertex> q = new TreeSet<>();
		for (Vertex v : graph.values()) { // Set up
			v.previous = v == source ? source : null;
			v.dist = v == source ? 0 : Integer.MAX_VALUE;
			q.add(v);
		}
		dijkstra(q);
	}

	private void dijkstra(final NavigableSet<Vertex> q) {
		Vertex u, v;
		while (!q.isEmpty()) {
			u = q.pollFirst();
			if (u.dist == Integer.MAX_VALUE)
				break;
			for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
				v = a.getKey(); // the neighbour in this iteration
				final int alternateDist = u.dist + a.getValue();
				if (alternateDist < v.dist) { // shorter path to neighbour found
					q.remove(v);
					v.dist = alternateDist;
					v.previous = u;
					q.add(v);
				}
			}
		}
	}

	public int printPath(int endName, int t) {
		int p = graph.get(endName).printPath(0);
		// System.out.println(p);
		return p <= t ? 1 : 0;
	}
}