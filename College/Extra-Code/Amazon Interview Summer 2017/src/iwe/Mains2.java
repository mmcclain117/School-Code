package iwe;
import java.util.ArrayList;
import java.util.List;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

	public static int pathExists(int[][] layout) {
		List<Node> queue = new ArrayList<Node>();
		queue.add(new Node(0, 0));
		int x, y;
		while (!queue.isEmpty()) { // Still a possible path
			Node current = queue.remove(0); // Current node
			x = current.getX();
			y = current.getY();
			if (layout[x][y] == 9) {
				return 1; // Found the 9 Node
			}
			layout[x][y] = 0; // Marks Visited
			/*
			 * Getting the Nodes all around the current Node
			 */
			if (isValid(layout, x - 1, y)) {
				queue.add(new Node(x - 1, y));
			}
			if (isValid(layout, x + 1, y)) {
				queue.add(new Node(x + 1, y));
			}
			if (isValid(layout, x, y - 1)) {
				queue.add(new Node(x, y - 1));
			}
			if (isValid(layout, x, y + 1)) {
				queue.add(new Node(x, y + 1));
			}
		}
		return 0;
	}

	/*
	 * Checks to see if point is in the 2d Array
	 */
	public static boolean isValid(int[][] layout, int x, int y) {
		return !(x < 0 || x >= layout.length || y < 0 || y >= layout.length) && (layout[x][y] != 0);
	}
}