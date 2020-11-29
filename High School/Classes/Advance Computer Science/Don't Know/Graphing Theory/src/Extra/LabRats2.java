package Extra;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class LabRats2 {

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
			int sum =0;
			Graph g = new Graph(graph);
			for (int i = 1; i <= n; i++) {
				g.dijkstra(i);
				g.printPath(e);
			}
		}
	}
}

class Graph {
	private final Map<Integer, Vertex> graph;
	// mapping of vertex names to Vertex objects, built from a set of Edges

	/** One edge of the graph (only used by Graph constructor) */
	public static class Edge {
		public final int v1, v2;
		public final int dist;

		public Edge(int vx, int vy, int d) {
			v1 = vx;
			v2 = vy;
			dist = d;
		}
	}

	/**
	 * One vertex of the graph, complete with mappings to neighbouring vertices
	 */
	public static class Vertex implements Comparable<Vertex> {
		public final int name;
		public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();
		public Vertex(int n) {
			name = n;
		}

		private void printPath() {
			if (this == this.previous) {
				System.out.printf("%s", this.name);
			} else if (this.previous == null) {
				System.out.printf("%s(unreached)", this.name);
			} else {
				this.previous.printPath();
				System.out.printf(" -> %s(%d)", this.name, this.dist);
			}
		}

		public int compareTo(Vertex other) {
			if (dist == other.dist)
				return name == other.name ? 0: -1;
			return Integer.compare(dist, other.dist);
		}

	}

	/** Builds a graph from a set of edges */
	public Graph(ArrayList<Graph.Edge> edges) {
		graph = new HashMap<>(edges.size());

		// one pass to find all vertices
		for (Edge e : edges) {
			if (!graph.containsKey(e.v1))
				graph.put(e.v1, new Vertex(e.v1));
			if (!graph.containsKey(e.v2))
				graph.put(e.v2, new Vertex(e.v2));
		}

		// another pass to set neighbouring vertices
		for (Edge e : edges) {
			graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
			// graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also
			// do this for an undirected graph
		}
	}

	/** Runs dijkstra using a specified source vertex */
	public void dijkstra(int startName) {
		final Vertex source = graph.get(startName);
		NavigableSet<Vertex> q = new TreeSet<>();

		// set-up vertices
		for (Vertex v : graph.values()) {
			v.previous = v == source ? source : null;
			v.dist = v == source ? 0 : Integer.MAX_VALUE;
			q.add(v);
		}

		dijkstra(q);
	}

	/** Implementation of dijkstra's algorithm using a binary heap. */
	private void dijkstra(final NavigableSet<Vertex> q) {
		Vertex u, v;
		while (!q.isEmpty()) {
			u = q.pollFirst(); // vertex with shortest distance (first iteration
								// will return source)
			if (u.dist == Integer.MAX_VALUE)
				break; // we can ignore u (and any other remaining vertices)
						// since they are unreachable

			// look at distances to each neighbour
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

	/** Prints a path from the source to the specified vertex */
	public void printPath(int endName) {
		graph.get(endName).printPath();
		System.out.println();
	}

	/**
	 * Prints the path from the source to every vertex (output order is not
	 * guaranteed)
	 */
	public void printAllPaths() {
		for (Vertex v : graph.values()) {
			v.printPath();
			System.out.println();
		}
	}
}