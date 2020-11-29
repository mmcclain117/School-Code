package ND;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob14 {

    public static char grid[][];

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob14.txt"));
        int x = scan.nextInt();
        int y = scan.nextInt();
//        scan.nextLine();
        while (x != 0 && y != 0) {
            scan.nextLine();
            char grid[][] = new char[y][x];
            for (int i = 0; i < y; i++) {
                String s = scan.nextLine();
                grid[i] = s.toCharArray();
            }

            x = scan.nextInt();
            y = scan.nextInt();
        }
    }

    private static long Fact(int a) {
        long sum = 1;
        for (int i = 1; i <= a; i++) {
            sum *= i;
        }
        return sum;
    }

    private static void Attempt1() {
        /*
            int sx = 0; // Starting X
            int sy = 0; // Starting Y
            LinkedList<Tree> paths = new LinkedList(); // Linked List of paths
            Tree t = new Tree();
            t.add(new Spot(sx, sy));
            paths.add(t);
            long sum = 0; // Number of paths
            while (!paths.isEmpty()) {
                Tree te = paths.removeFirst(); // First Tree
                Spot ss = te.getLast();
                int ssx = ss.x;
                int ssy = ss.y;
                if (ssx == x - 1 && ssy == y - 1) {
//                    System.out.println("SUM: "+ sum);
                    sum++;
                } else {
                    if (ssx - 1 > 0) { // Left
                        if (grid[ssy][ssx - 1] == '.') { // Not a wall
                            if (!te.add(new Spot(ssx - 1, ssy))) { // Good to go
                                paths.add(te);
                            }
                        }
                    }
                    if (ssy - 1 > 0) { // Up
                        if (grid[ssy - 1][ssx] == '.') {
                            if (!te.add(new Spot(ssx, ssy - 1))) {
                                paths.add(te);
                            }
                        }
                    }
                    if (ssx + 1 < x) { // Right
                        if (grid[ssy][ssx + 1] == '.') {
                            if (!te.add(new Spot(ssx + 1, ssy))) {
                                paths.add(te);
                            }
                        }
                    }
                    if (ssy + 1 < y) { // Down
                        if (grid[ssy + 1][ssx] == '.') {
                            if (!te.add(new Spot(ssx, ssy + 1))) {
                                paths.add(te);
                            }
                        }
                    }
                }
//                System.out.println(paths.size());
            }
            System.out.println("SUM: " + sum);
            System.out.println("X AND Y: " + x + " " + y);
         */
//            System.out.println(Fact(x - 1 + y - 1) / ((Fact(x - 1)) * (Fact(y - 1))));
//            System.out.println(x + " " + y);
    }
}

class Tree {

    private LinkedList<Spot> ll;

    public Tree() {
        ll = new LinkedList();
    }

    public boolean add(Spot s) {
        for (int i = 0; i < ll.size(); i++) {
            Spot temp = ll.get(i);
            if (temp.x == s.x && temp.y == s.y) {
                return true;
            }
        }
        ll.addLast(s);
        return false;
    }

    public Spot getLast() {
        return ll.getLast();
    }

    public void Rem() { // Remove Last
        ll.removeLast();
    }
}

class Spot extends Tree {

    int x;
    int y;

    public Spot(int a, int b) {
        x = a;
        y = b;
    }
}
