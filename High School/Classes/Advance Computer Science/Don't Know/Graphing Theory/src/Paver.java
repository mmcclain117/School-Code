import java.io.File;
import java.util.Scanner;

public class Paver {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("paver.dat"));
		int t = scan.nextInt(); // Number of test Cases
		int p = scan.nextInt(); // Price for 1 unit
		int n = scan.nextInt(); // Number of Buildings
		int m = scan.nextInt(); // Number of Streets
		int grid[][] = new int[n][n];
		for (int ii = 0; ii < m; ii++) {
			int a = scan.nextInt(); // Building a
			int b = scan.nextInt(); // Building b
			int c = scan.nextInt(); // Units apart
			grid[a - 1][b - 1] = c; // Putting into the grid
		}
		int parent[] = new int[n]; // Parents
		int key[] = new int[n]; // Values
		boolean mstSet[] = new boolean[n]; // Visited/ Included
		for (int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0; // Starting Node set 0
		parent[0] = 0; // Root Node set null
		for (int count = 0; count < n - 1; count++) { // Go through the edges
			int u = minKey(key, mstSet, n);
			mstSet[u] = true; // Add to visited
			for (int v = 0; v < n; v++) { // Update
				if (grid[u][v] != 0 && !mstSet[v] && grid[u][v] < key[v]) {
					parent[v] = u;
					key[v] = grid[u][v];
				}
			}
		}
		int sum = 0;
		for (int tx : parent) {
			sum += tx;
		}
		System.out.println(sum * p);
	}

	// Minimum not chosen yet
	public static int minKey(int[] key, boolean[] mstSet, int n) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < n; v++) {
			if (!mstSet[v] && key[v] <= min) {
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
}
