
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    public static char grid[][];

    public static void main(String[] args) throws Exception {
//        Problem: Maze Surfing
//        Points: 14
        Scanner scan = new Scanner(new File("prob13.txt"));
        int x = scan.nextInt();
        scan.nextLine();
        int sx = 0; // Starting X
        int sy = 0; // Starting Y
        grid = new char[x][x];
        for (int i = 0; i < grid.length; i++) {
            String t = scan.nextLine().replaceAll(" ", "");
            grid[i] = t.toCharArray();
            if (t.contains("M")) {
                sy = i;
                sx = t.indexOf("M");
            }
        }

        ArrayList<LinkedList<Node>> path = new ArrayList<>(); // Queue of paths
        LinkedList<Node> cur = new LinkedList(); // current path
        cur.add(new Node(sx, sy)); // Adds starting point
        path.add(cur); // Adds starting path
        LinkedList<Node> visited = new LinkedList();
        while (!path.isEmpty()) { // If empty there is no path
            LinkedList<Node> te = path.remove(0);
            Node temp = te.getLast();
            if (grid[temp.y][temp.x] == 'C') {
                path.add(te);
                break;
            }
            if (temp.up()) {
                LinkedList<Node> um = makeLink(te); // Up Move
                Node n = new Node(temp.x, temp.y - 1); // For reason of checking
                if (Con(visited, n)) {
                    um.addLast(n);
                    path.add(um);
                    visited.add(n);
                }
            }
            if (temp.down()) {
                LinkedList<Node> dm = makeLink(te); // Down Move
                Node n = new Node(temp.x, temp.y + 1);
                if (Con(visited, n)) {
                    dm.addLast(n);
                    path.add(dm);
                    visited.add(n);
                }
            }
            if (temp.right()) {
                LinkedList<Node> rm = makeLink(te); // Right Move
                Node n = new Node(temp.x + 1, temp.y);
                if (Con(visited, n)) {
                    rm.addLast(n);
                    path.add(rm);
                    visited.add(n);
                }
            }
            if (temp.left()) {
                LinkedList<Node> lm = makeLink(te); // Left Move
                Node n = new Node(temp.x - 1, temp.y);
                if (Con(visited, n)) {
                    lm.addLast(n);
                    path.add(lm);
                    visited.add(n);
                }
            }
        }
        LinkedList<Node> ll = path.get(path.size() - 1); // The completed path
        for (int ii = 1; ii < ll.size() - 1; ii++) {
            Node temper = ll.get(ii);
            grid[temper.y][temper.x] = '+';
        }

        /* Print out the grid */
        for (int yy = 0; yy < x; yy++) {
            for (int xx = 0; xx < x; xx++) {
                System.out.print(grid[yy][xx] + " ");
            }
            System.out.println();
        }
    }

    private static boolean Con(LinkedList<Node> l, Node n) { // Contains
        for (int i = 0; i < l.size(); i++) {
            Node temp = l.get(i);
            if (temp.x == n.x && temp.y == n.y) {
                return false;
            }
        }
        return true;
    }

    private static LinkedList<Node> makeLink(LinkedList<Node> te) {
        LinkedList<Node> ll = new LinkedList();
        for (int i = 0; i < te.size(); i++) {
            ll.addLast(te.get(i));
        }
        return ll;

    }
}

class Node extends Prob13 {

    int x;
    int y;
    int maxY = grid.length;
    int maxX = grid[0].length;

    public Node(int a, int b) {
        x = a;
        y = b;
    }

    public boolean up() {
        if (y - 1 > 0) {
            return grid[y - 1][x] == '.' || grid[y - 1][x] == 'C';
        }
        return false;
    }

    public boolean down() {
        if (y + 1 < maxY) {
            return grid[y + 1][x] == '.' || grid[y + 1][x] == 'C';
        }
        return false;
    }

    public boolean right() {
        if (x + 1 < maxX) {
            return grid[y][x + 1] == '.' || grid[y][x + 1] == 'C';
        }
        return false;
    }

    public boolean left() {
        if (x - 1 > 0) {
            return grid[y][x - 1] == '.' || grid[y][x - 1] == 'C';
        }
        return false;
    }
}
