package mazerunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 143352
 */
public class MazeRunner {

    static Point[][] maze;
    static Deque deck = new ArrayDeque();
    static int visits = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("maze.txt"));
        int runs = Integer.parseInt(sc.nextLine());
        Point start = null, end = null;

        for (int i = 0; i < runs; i++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            maze = new Point[rows][columns];
            sc.nextLine();
            for (int r = 0; r < rows; r++) {
                String[] mazeR = sc.nextLine().split(" ");
                for (int c = 0; c < columns; c++) {
                    maze[r][c] = new Point(mazeR[c], r, c);
                    if (mazeR[c].equals("o")) {
                        start = maze[r][c];
                    }
                    if (mazeR[c].equals("x")) {
                        end = maze[r][c];
                    }
                    if (maze[r][c].s.equalsIgnoreCase("#")) {
                        maze[r][c].v = true;
                    }
                }
            }
            //System.out.println(maze[0].length);

            /*for(int r = 0; r < rows; r++) {
                for(int c = 0; c < columns; c++) {
                    System.out.print(maze[r][c].getString());
                }
                System.out.println();
            }*/
            System.out.println("Maze " + (i + 1) + ": DFS");
            String[] p = dfs(start);
            if (p == null) {
                System.out.println("I am sorry, sir but... No Solution Exists");
            } else {
                System.out.println("Steps: " + (p.length - 1));
                System.out.println("Visited " + visits);
                System.out.print("Path: ");
                for (String s : p) {
                    System.out.print(s);
                }
            }
            System.out.println();
            getBestPoint(start, end);
        }
    }

    public static String[] dfs(Point start) {
        Stack<Point> s = new Stack<>();
        String[] points = null;
        s.push(start);
        while (!s.isEmpty()) {
            Point p = s.peek();
            p.v = true;
            Point next = getNextPoint(p);
            if (next == null) {
                s.pop();
            } else {
                s.push(next);
                visits++;
                if (s.peek().isExit()) {
                    points = new String[s.size()];
                    for (int i = s.size() - 1; i >= 0; i--) {
                        Point po = (Point) s.pop();
                        points[i] = po.getPoint();
                    }
                    break;
                }
            }
        }
        return points;
    }

    public static Point getNextPoint(Point p) {
        int row = p.r;
        int col = p.c;

        if (row - 1 >= 0 && maze[row - 1][col].check()) {
            return maze[row - 1][col];       //UP
        } else if (row + 1 <= maze.length - 1 && maze[row + 1][col].check()) {
            return maze[row + 1][col];       //DOWN
        } else if (col - 1 >= 0 && maze[row][col - 1].check()) {
            return maze[row][col - 1];       //LEFT
        } else if (col + 1 <= maze[0].length - 1 && maze[row][col + 1].check()) {
            return maze[row][col + 1];       //RIGHT
        } else {
            return null;
        }
    }

    public static Point[] breadthFind(Point start, Point end) {

        return new Point[50];
    }

    public static int getBestPoint(Point p, Point end) {
        System.out.println("The Min Heap is ");
        Heap minHeap = new Heap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        //minHeap.minHeap();

        while (!minHeap.isEmpty()) {
            System.out.println("The Min val is " + minHeap.remove());
        }
        return 0;
    }

    public static Point[] bestFind(Point start, Point end) {

        return new Point[50];
    }

    public static class Point {

        String s;
        int r;
        int c;
        boolean v = false;

        public Point(String s, int r, int c) {
            this.r = r;
            this.c = c;
            this.s = s;
        }

        String getString() {
            return s;
        }

        String getPoint() {
            return "(" + r + ", " + c + ") ";
        }

        boolean isVisited() {
            return v;
        }

        boolean isWall() {
            return s.equals("#");
        }

        boolean check() {
            return !(isWall() || isVisited());
        }

        boolean isExit() {
            return s.equals("X");
        }
    }
}
