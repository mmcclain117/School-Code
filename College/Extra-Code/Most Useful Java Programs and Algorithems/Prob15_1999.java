
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob15 {

    public static int grid[][];

    public static void main(String[] args) throws Exception {
//        Problem: Matrix Amazement
//        Points: 13
        Scanner scan = new Scanner(new File("prob15.txt"));
        while (scan.hasNext()) {
            String s = scan.nextLine();
            System.out.print(s + ": ");
            int sx = 0; // Starting X
            int sy = 0; // Starting Y
            grid = new int[4][4];

            /* Populate Grid */
            for (int i = 0; i < 4; i++) {
                String line[] = scan.nextLine().trim().split("[ ]+");
                for (int o = 0; o < line.length; o++) {
                    grid[i][o] = Integer.parseInt(line[o]);
                }
            }

            ArrayList<LinkedList<Node>> path = new ArrayList<>(); // Queue of paths
            LinkedList<Node> cur = new LinkedList(); // current path
            cur.add(new Node(sx, sy, grid[0][0])); // Adds starting point
            path.add(cur); // Adds starting path
            while (!path.isEmpty()) { // If empty there is no path
                LinkedList<Node> te = path.remove(0);
                Node temp = te.getLast();
                if (temp.x == 3 && temp.y == 3) {
                    int sums = addEm(te);
                    if (sums == grid[3][3]) {
                        for (int i = 1; i < te.size(); i++) {
                            System.out.print(te.get(i).value + " ");
                        }
                        System.out.println(sums);
                        path.add(te);
                        break;
                    }
                }
                if (addEm(te) < grid[3][3]) {
                    if (temp.up()) {
                        LinkedList<Node> um = makeLink(te); // Up Move
                        Node n = new Node(temp.x, temp.y - 1, grid[temp.x][temp.y]); // For reason of checking
                        if (Con(n)) {
                            n.vx.add(temp.x);
                            n.vy.add(temp.y);
                            um.addLast(n);
                            path.add(um);
                        }
                    }
                    if (temp.down()) {
                        LinkedList<Node> dm = makeLink(te); // Down Move
                        Node n = new Node(temp.x, temp.y + 1, grid[temp.x][temp.y]);
                        if (Con(n)) {
                            n.vx.add(temp.x);
                            n.vy.add(temp.y);
                            dm.addLast(n);
                            path.add(dm);
                        }
                    }
                    if (temp.right()) {
                        LinkedList<Node> rm = makeLink(te); // Right Move
                        Node n = new Node(temp.x + 1, temp.y, grid[temp.x][temp.y]);
                        if (Con(n)) {
                            n.vx.add(temp.x);
                            n.vy.add(temp.y);
                            rm.addLast(n);
                            path.add(rm);
                        }
                    }
                    if (temp.left()) {
                        LinkedList<Node> lm = makeLink(te); // Left Move
                        Node n = new Node(temp.x - 1, temp.y, grid[temp.x][temp.y]);
                        if (Con(n)) {
                            n.vx.add(temp.x);
                            n.vy.add(temp.y);
                            lm.addLast(n);
                            path.add(lm);
                        }
                    }
                }
            }
            printGrid();
        }
    }

    /* Checks if it has already been visited */
    private static boolean Con(Node n) { // Contains
        ArrayList visitX = n.vx;
        ArrayList<Integer> visitY = n.vy;
        for (int i = 0; i < visitX.size(); i++) {
            if (n.x == (int) visitX.get(i) && n.y == visitY.get(i)) {
                return false;
            }
        }
        return true;
    }

    /* Adds link to current LinkedList */
    private static LinkedList<Node> makeLink(LinkedList<Node> te) {
        LinkedList<Node> ll = new LinkedList();
        for (int i = 0; i < te.size(); i++) {
            ll.addLast(te.get(i));
        }
        return ll;

    }

    private static int addEm(LinkedList<Node> path) {
        int sum = 0;
        for (int i = 1; i < path.size(); i++) {
            sum += path.get(i).value;
        }
        return sum;
    }

    /* Prints out the grid */
    private static void printGrid() {
        for (int yy = 0; yy < 4; yy++) {
            for (int xx = 0; xx < 4; xx++) {
                System.out.print(grid[yy][xx] + " ");
            }
            System.out.println();
        }
    }

}

class Node extends Prob15 {

    int x;
    int y;
    int maxY = grid.length;
    int maxX = grid[0].length;
    int value;
    ArrayList<Integer> vx;
    ArrayList<Integer> vy;

    public Node(int a, int b, int v) {
        x = a;
        y = b;
        value = v;
        vx = new ArrayList<>(); // Visited X
        vy = new ArrayList<>(); // Visited Y

    }

    public boolean up() {
        return y - 1 > 0;
    }

    public boolean down() {
        return y + 1 < maxY;
    }

    public boolean right() {
        return x + 1 < maxX;
    }

    public boolean left() {
        return x - 1 > 0;
    }
}
