package Extra;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class PrimsAlgorithm {

	// Number of vertices
	private int vertices;

	// Constructor
	public PrimsAlgorithm(int vertices) {
		this.vertices = vertices;
	}

	// A utility function to find the vertex with minimum key value,
	// from the set of vertices not yet included in MST
	public int minKey(int[] key, boolean[] mstSet) {

		// Initialize min value
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int v = 0; v < vertices; v++) {
			if (!mstSet[v] && key[v] <= min) {
				min = key[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	// A utility function to print the constructed MST stored in parent[]
	public void printMST(int parent[], int n, int[][] graph) {
		System.out.println("Edge   Weight");
		for (int i = 1; i < vertices; i++) {
			System.out.println(parent[i] + " - " + i + "  " + graph[i][parent[i]]);
		}
		for(int i =0;i < n;i++) {
			for(int y = 0;y < n;y++) {
				System.out.print(graph[y][i]+ " ");
			}
			System.out.println();
		}
	}

	// Function to construct and print MST for a graph represented
	// using adjacency matrix representation
	public void primMST(int[][] graph) {

		// Array to store constructed MST
		int parent[] = new int[vertices];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[vertices];

		// To represent set of vertices not yet included in MST
		boolean mstSet[] = new boolean[vertices];

		// Initialize all keys as INFINITE
		for (int i = 0; i < vertices; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		// Make key 0 so that this vertex is picked as first vertex
		key[0] = 0;

		// First node is always root of MST
		parent[0] = -1;

		// The MST will have vertices-1 edges
		for (int count = 0; count < vertices - 1; count++) {

			// Pick the minimum key vertex from the set of vertices not yet
			// included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < vertices; v++) {

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
			System.out.println(Arrays.toString(key));
		}
			System.out.println(Arrays.toString(parent));
		

		// Print the constructed MST
//		printMST(parent, vertices, graph);
	}


		public static void main(String args[]) throws Exception {
			Scanner scan = new Scanner(new File("paver.dat"));
			int t = scan.nextInt(); // Number of test Cases
			int p = scan.nextInt(); // Price for 1 unit
			int n = scan.nextInt(); // Number of Buildings
			int m = scan.nextInt(); // Number of Streets
			int grid[][] = new int[n][n];
//			for(int i =0;i < n;i++) {
//				for(int y = 0;y < n;y++) {
//					grid[y][i] = Integer.MAX_VALUE;
//				}
//			}
			for (int ii = 0; ii < m; ii++) {
				int a = scan.nextInt(); // Building a
				int b = scan.nextInt(); // Building b
				int c = scan.nextInt(); // Units apart
				grid[a - 1][b - 1] = c; // Putting into the grid
				System.out.println(a + " " + b + " " +c);
			}
		PrimsAlgorithm pa = new PrimsAlgorithm(5);

		pa.primMST(grid);
	}

}