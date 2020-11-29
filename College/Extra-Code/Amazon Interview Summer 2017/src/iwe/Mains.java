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
        
        while(!queue.isEmpty()) { // Still a possible path
            Node current = queue.remove(0); // Current node
            if(layout[current.x][current.y] == 9) {
            	return 1; // Found the 9 Node
            }
            layout[current.x][current.y] = 0; // Marks Visited
            queue.addAll(getNeighbors(layout, current));
            }
        return 0;
    }
    /*
     * Getting the Nodes all around the current Node
     */
    public static List<Node> getNeighbors(int[][] layout, Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        int x = node.getX(); // Current X Value
        int y = node.getY(); // Current Y Value
        if(isValid(layout, x - 1, y)) {
            neighbors.add(new Node(x - 1, y));
        }
        if(isValid(layout, x + 1, y)) {
            neighbors.add(new Node(x + 1, y));
        }
        if(isValid(layout, x, y - 1)) {
            neighbors.add(new Node(x, y - 1));
        }
        if(isValid(layout, x, y + 1)) {
            neighbors.add(new Node(x, y + 1));
        }
        return neighbors;
    }
    
    /* 
     * Checks to see if in the 2d Array
     */
    public static boolean isValid(int[][] layout, int x, int y) {
        return !(x < 0 || x >= layout.length || y < 0 || y >= layout.length) && (layout[x][y] != 0);
    }
}