package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static int cost[][];
    public static String CurPath[];
    public static boolean visited[];
    public static int minCost;
    public final static int nodeCount = 11;
    public static String minPath[];
    public static int di; // Destination Int
    public static int si; // Source Int
    public static int cons; // Counter of min

    public static ArrayList<String> ar;

    public static void main(String[] args) throws Exception {
//        Problem: Data Transmission
//        Points: 10
        Scanner scan = new Scanner(new File("prob10.txt"));
        init();
        ArrayList<City> ll = new ArrayList();
//        ArrayList<Integer> cost = new ArrayList();
        String curCity[] = {"SEA", "SEA", "SEA", "LA", "CHI", "LIN", "LIN", "PHX", "PHX", "ATL", "ATL"}; // Starting City
        String destCity[] = {"LA", "CHI", "LIN", "PHX", "NYC", "NYC", "ATL", "LIN", "HOU", "HOU", "NYC"}; // Destination City
        int a = scan.nextInt(); // SEA to LA
        setCost(0, 1, a);
        int b = scan.nextInt(); // SEA to CHI
        setCost(0, 3, b);
        int c = scan.nextInt(); // SEA to LIN
        setCost(0, 4, c);
        int d = scan.nextInt(); // LA to PHX
        setCost(1, 2, d);
        int e = scan.nextInt(); // CHI to NYC
        setCost(3, 5, e);
        int f = scan.nextInt(); // LIN to NYC
        setCost(4, 5, f);
        int g = scan.nextInt(); // LIN to ATL
        setCost(4, 6, g);
        int h = scan.nextInt(); // PHX to LIN
        setCost(2, 4, h);
        int i = scan.nextInt(); // PHX to HOU
        setCost(2, 7, i);
        int j = scan.nextInt(); // ATL to HOU
        setCost(6, 7, j);
        int k = scan.nextInt(); // ATL to NYC
        setCost(6, 5, k);
//        SEA = 0; LA = 1; PHX = 2; CHI = 3; LIN = 4; NYC = 5; ATL = 6; HOU = 7;
//        int val[] = {a, b, c, d, e, f, g, h, i, j, k}; // Track Cost

        scan.nextLine();
        while (scan.hasNext()) {
            String fli[] = scan.nextLine().split("[ ]+"); // Flight
            String source = fli[0];
            String dest = fli[1];
            System.out.println("For " + source + " to " + dest + ": ");
            /* Gets the number of destination */
            for (int q = 0; q < CurPath.length; q++) {
                if (CurPath[q].equals(dest)) {
                    di = q;
                }
                if (CurPath[q].equals(source)) {
                    si = q;
                }
            }
            System.out.println("THE destination is: " + di);
//            for (int io = 0; io < 11; io++) {
            findCost(si, si, 1);
//            }
            if (minCost < Integer.MAX_VALUE) { // WE DID SHIT
                System.out.println("Cost of the Minimum Cost Path Through Everything: " + minCost);
                System.out.print("Path in Order from First -> Last: ");
                for (int io = 0; io < minPath.length; io++) {
                    if (minPath[io] != null) {
                        System.out.print(minPath[io] + ", ");
                    }
                }
                System.out.println();
                System.out.println(Arrays.toString(ar.toArray()));
                System.out.println();
            } else {
                System.out.println("SOME DIDN\'T DO SHIT.");
                System.out.println("IT DOESN\'T WORK IDIOT");
            }
//            print();
        }
    }

    private static void init() {
        cost = new int[11][11];
        CurPath = new String[]{"SEA", "LA", "PHX", "CHI", "LIN", "NYC", "ATL", "HOU"};
        visited = new boolean[11];
        minCost = Integer.MAX_VALUE; // Minimum Cost
        minPath = new String[11];
        ar = new ArrayList<>();
    }

//    Current node, Cost, Depth
    private static void findCost(int curNode, int curCost, int curDep) {
        int i;
        int tempCost;
        boolean over = false;
        visited[curNode] = true;
        for (i = 0; i < 11; i++) {
            int tmp = curNode + i;
            if (tmp < 11) {
                if (!visited[tmp] && (cost[curNode][tmp] > 0)) {
                    tempCost = curCost + cost[curNode][tmp];
                    if (tempCost < minCost) {
                        ar.add(CurPath[tmp]);
                        minPath[tmp] = CurPath[tmp];
                        findCost(tmp, tempCost, curDep);
                    }
                }
            } else if (over) {
                System.out.println("WE WENT OVER");
                break;
            } else {
                tmp %= 11;
                over = true;
            }
        }
        for (i = 0; visited[i] && i < 11; i++) {
        }
//        if (i == 11) {
        if (visited[di]) {
            minCost = curCost;
//            minPath = Arrays.copyOf(CurPath, CurPath.length);
        }
        visited[curNode] = false;
    }

    /* Adds to the Array x and y values (and inverse) to value n */
    private static void setCost(int x, int y, int n) {
        cost[x][y] = n;
        cost[y][x] = n;
    }

    private static void print() {
        for (int x = 0; x < cost.length; x++) {
            for (int y = 0; y < cost.length; y++) {
                System.out.print(cost[x][y] + " ");
            }
            System.out.println();
        }
    }

    static class City {

        String name;
        int value;
        String nextCity;
        String prevCity;

        City(String a, int v, String b) {
            name = a;
            value = v;
            nextCity = b;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public String getNext() {
            return nextCity;
        }
    }
}
