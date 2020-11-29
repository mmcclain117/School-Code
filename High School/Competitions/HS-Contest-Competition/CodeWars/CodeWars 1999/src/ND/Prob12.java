package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

//    public static ArrayList<int[]> ar;
    public static void main(String[] args) throws Exception {
//        Problem: Magic Square
//        Points: 7
        /* Integer Partition Testing Part */
//        ar = new ArrayList<>();
//        printAllUniqueParts(40, 4);
//        cut(4);

        Scanner scan = new Scanner(new File("prob12a.txt"));
        int grid[][] = new int[4][4]; // 4x4 grid
        int tmpGrid[][] = new int[4][4];
        int totals[] = new int[9]; // Sums
        int tmpTot[] = new int[9]; // Modified sums
        int tmpLef[] = new int[9]; // Amount left in that row
        ArrayList<ArrayList<int[]>> pos = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            String line[] = scan.nextLine().trim().split("[ ]+"); // Values
//            System.out.println(Arrays.toString(line));
            totals[i] = Integer.parseInt(line[line.length - 1]); // Adds total
            tmpTot[i] = totals[i];

            /* Populate the grid */
            for (int o = 0; o < line.length - 1; o++) {
                if (line[o].equals("XX")) {
                    grid[i][o] = -1;
                    tmpLef[i]++;
                } else {
                    grid[i][o] = Integer.parseInt(line[o]);
                    tmpTot[i] -= grid[i][o];
//                    tmpLef[i]++;
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(grid[i][o]);
                }
            }
        }
        /* Populate column totals into totals */
        String ll[] = scan.nextLine().trim().split("[ ]+"); // Last line
        for (int i = 0; i < ll.length; i++) {
            totals[4 + i] = Integer.parseInt(ll[i]);
            tmpTot[4 + i] = totals[4 + i];
        }

        for (int i = 0; i < 4; i++) {
            ArrayList<int[]> tmpAr = new ArrayList<>();
            tmpAr = printAllUniqueParts(tmpTot[i], tmpLef[i]);
            cut(tmpAr, tmpLef[i]);
            pos.add(tmpAr);
//            ar.clear();
/* Clears AR */
        }
        int debug = 0; // Stop after x amount
        while (!check(tmpGrid, totals) && debug < 1000) {
//            if (debug > 120000) {
//                System.out.println("it seems to not be working that well");
//                break;
//            }
            /* Doing the first row */
            for (int i1 = 0; i1 < pos.get(0).size(); i1++) {
                int con = 0;
//                System.out.println(Arrays.toString(pos.get(0).get(0)));
                for (int i2 = 0; i2 < 4; i2++) {
//                    System.out.println(i2 + " " + con);
                    if (grid[0][i2] == -1) {
                        tmpGrid[0][i2] = pos.get(0).get(i1)[con];
                        con++;
                    } else {
                        tmpGrid[0][i2] = grid[0][i2];
                    }
                }
                /* Doing the second row */
                for (int i3 = 0; i3 < pos.get(1).size(); i3++) {
                    con = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        if (grid[1][i2] == -1) {
                            tmpGrid[1][i2] = pos.get(1).get(i3)[con];
                            con++;
                        } else {
                            tmpGrid[1][i2] = grid[1][i2];
                        }
                    }
                    /* Doing the third row */
                    for (int i4 = 0; i4 < pos.get(2).size(); i4++) {
                        con = 0;
                        for (int i2 = 0; i2 < 4; i2++) {
                            if (grid[2][i2] == -1) {
                                tmpGrid[2][i2] = pos.get(2).get(i4)[con];
                                con++;
                            } else {
                                tmpGrid[2][i2] = grid[2][i2];
                            }
                        }
                        /* Doing the fourth row */
                        for (int i5 = 0; i5 < pos.get(3).size(); i5++) {
                            con = 0;
                            for (int i2 = 0; i2 < 4; i2++) {
                                if (grid[3][i2] == -1) {
                                    tmpGrid[3][i2] = pos.get(3).get(i5)[con];
                                    con++;
                                } else {
                                    tmpGrid[3][i2] = grid[3][i2];
                                }
                            }
                        }
                        if (check(tmpGrid, totals)) {
                            break;
                        }
                    }
                }
//                for (int x = 0; x < 4; x++) {
//                    for (int y = 0; y < 4; y++) {
//                        System.out.print(tmpGrid[x][y] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }
            /*
            for (int o = 0; o < pos.get(0).size() - 1; o++) {
                int con = 0; // State of array
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        if (grid[x][y] == -1 && con <= 2) {
                            tmpGrid[x][y] = pos.get(0).get(o)[con];
                            con++;
                        } else {
                            tmpGrid[x][y] = grid[x][y];
                        }
                    }
                }
            }*/
            debug++;
        }

        System.out.println(check(tmpGrid, totals));
        /* Print out the tmperary grid */
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(tmpGrid[x][y] + " ");
            }
            System.out.println();
        }

        // Testing speed
        int speed = 1;
        System.out.println("Number of combinations: " + speed);
        System.out.println("Temperary Grid");
        /* Prints out the temperary grid */
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(tmpGrid[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println(check(tmpGrid, totals));

        /* Prints grid */
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println(totals[x] + " " + pos.get(x).size());
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(totals[4 + i] + " ");
        }
        System.out.println();
    }

    /* Validify that it is a valid magic square */
    private static boolean check(int grid[][], int totals[]) {
        /* Check rows */
        for (int i = 0; i < grid.length; i++) {
            int tot = 0; // Total for line
            for (int o = 0; o < grid[i].length; o++) {
                tot += grid[i][o];
            }
            if (tot != totals[i]) {
//                System.out.println("Didn't work on row " + i);
                return false;
            }
        }
//        if (true) {
//            return true;
//        }
        /* Check columns */
        for (int i = 0; i < grid.length; i++) {
            int tot = 0; // Total for line
            for (int o = 0; o < grid[i].length; o++) {
                tot += grid[o][i];
            }
//            System.out.println(totals[i + 4] + " " + tot);
            if (tot != totals[i + 4]) {
//                System.out.println("Didn't work on column " + i);
                return false;
            }
        }

        /* Check Diagonal */
        int tot = 0; // Total for diagonal
        for (int i = 0; i < grid.length; i++) {
            tot += grid[i][i];
        }
        return tot == totals[totals.length - 1];
    }

//    N the max number
//    q Number of elements looking for
    static ArrayList<int[]> printAllUniqueParts(int n, int q) {
        ArrayList<int[]> ar = new ArrayList();
        int[] p = new int[n]; // An array to store a partition
        int k = 0;  // Index of last element in a partition
        p[k] = n;  // Initialize first partition as number itself
        // This loop first prints current partition, then generates next
        // partition. The loop stops when the current partition has all 1s
        while (true) {
            ar.add(Arrays.copyOf(p, k + 1));
            // Generate next partition
            // Find the rightmost non-one value in p[]. Also, update the
            // rem_val so that we know how much value can be accommodated
            int rem_val = 0;
            while (k >= 0 && p[k] == 1) {
                rem_val += p[k];
                k--;
            }

            // if k < 0, all the values are 1 so there are no more partitions
            if (k < 0) {
                return ar;
            }

            // Decrease the p[k] found above and adjust the rem_val
            p[k]--;
            rem_val++;

            // If rem_val is more, then the sorted order is violeted.  Divide
            // rem_val in differnt values of size p[k] and copy these values at
            // different positions after p[k]
            while (rem_val > p[k]) {
                p[k + 1] = p[k];
                rem_val = rem_val - p[k];
                k++;
            }

            // Copy rem_val to next position and increment position
            p[k + 1] = rem_val;
            k++;
        }
    }

    private static void cut(ArrayList<int[]> ar, int q) {
        int con = 0; // counter
        System.out.println("Before ar size is: " + ar.size());
        /* Cuts out if bigger than Q size */
        while (ar.size() > con) {
            if (ar.get(con).length != q) {
                ar.remove(con);
            } else {
                con++;
            }
        }
        System.out.println("After ar size is: " + ar.size());
    }
}
