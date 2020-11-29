
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Complete brute force that takes forever and doesn't check the columns */
public class Prob12a {

    public static void main(String[] args) throws Exception {
//        Problem: Magic Square
//        Points: 7
        Scanner scan = new Scanner(new File("prob12a.txt"));
        int grid[][] = new int[4][4]; // 4x4 grid
        int totals[] = new int[9]; // Sums
        int tmpTot[] = new int[9]; // Modified sums
        ArrayList<ArrayList<Integer>> posAr = new ArrayList(16); // Possibilities for each spot
        for (int i = 0; i < 4; i++) {
            String line[] = scan.nextLine().trim().split("[ ]+"); // Values
//            System.out.println(Arrays.toString(line));
            totals[i] = Integer.parseInt(line[line.length - 1]); // Adds total
            tmpTot[i] = totals[i];

            /* Populate the grid */
            for (int o = 0; o < line.length - 1; o++) {
                if (line[o].equals("XX")) {
                    grid[i][o] = -1;
                    posAr.add(new ArrayList<>());
                } else {
                    grid[i][o] = Integer.parseInt(line[o]);
                    tmpTot[i] -= grid[i][o];
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(grid[i][o]);
                    posAr.add(t);
                }
            }

            /* Populates a temperary posbilities array */
            ArrayList<Integer> tmpMax = new ArrayList<>();
            for (int o = 1; o < tmpTot[i]; o++) {
                tmpMax.add(o);
            }
            for (int o = 0; o < 4; o++) {
                if (posAr.get(i * 4 + o).isEmpty()) {
                    posAr.get(i * 4 + o).addAll(tmpMax);
                }
            }
        }

        /* Populate column totals into totals */
        String ll[] = scan.nextLine().trim().split("[ ]+"); // Last line
        for (int i = 0; i < ll.length; i++) {
            totals[4 + i] = Integer.parseInt(ll[i]);
            tmpTot[4 + i] = totals[4 + i];
        }

        /* Trim the columns */
        for (int i = 0; i < 16; i++) {
            int row = i % 4; // Number row it is in
            int col = i / 5 + 4; // Number column it is in
//            System.out.println("Row " + row + " column " + col);
            Object array[] = posAr.get(i).toArray();
            posAr.get(i).clear();
            posAr.get(i).addAll(trim(array, tmpTot[row], tmpTot[col]));
        }
        /* Trim the diagonal */
 /* This Doesnt work since It broke whne a value was in the diagonal */
        for (int i = 0; i < 4; i++) {
            Object array[] = posAr.get(i * i).toArray();
            posAr.get(i * i).clear();
            posAr.get(i * i).addAll(trim(array, tmpTot[8], tmpTot[8]));
        }
        System.out.println(totals[0]);
        System.out.println(posAr.get(0).size() + " " + posAr.get(1).size() + " " + posAr.get(2).size() + " " + posAr.get(3).size());
        ArrayList<Integer> ar = new ArrayList();
        int con = 0; // Number of combinations
        int tt;
        /* Try some first row combinations */
 /* Try all combinations */
        for (int i1 = 0; i1 < posAr.get(0).size(); i1++) {
            for (int i2 = 0; i2 < posAr.get(1).size(); i2++) {
                for (int i3 = 0; i3 < posAr.get(2).size(); i3++) {
                    for (int i4 = 0; i4 < posAr.get(3).size(); i4++) {
                        tt = posAr.get(0).get(i1) + posAr.get(1).get(i2);
                        tt += posAr.get(2).get(i3) + posAr.get(3).get(i4);
                        if (tt > totals[0]) { // Cut down on time
                            break;
                        } else if (tt == totals[0]) { // First Row (1 Sec)
//                            con++;
                            for (int i5 = 0; i5 < posAr.get(4).size(); i5++) {
                                for (int i6 = 0; i6 < posAr.get(5).size(); i6++) {
                                    for (int i7 = 0; i7 < posAr.get(6).size(); i7++) {
                                        for (int i8 = 0; i8 < posAr.get(7).size(); i8++) {
                                            tt = posAr.get(4).get(i5) + posAr.get(5).get(i6);
                                            tt += posAr.get(6).get(i7) + posAr.get(7).get(i8);
                                            if (tt > totals[1]) { // Cut down on time
                                                break;
                                            } else if (tt == totals[1]) { // Second Row (10 Sec)
                                                for (int i9 = 0; i9 < posAr.get(8).size(); i9++) {
                                                    for (int i10 = 0; i10 < posAr.get(9).size(); i10++) {
                                                        for (int i11 = 0; i11 < posAr.get(10).size(); i11++) {
                                                            for (int i12 = 0; i12 < posAr.get(11).size(); i12++) {
                                                                tt = posAr.get(8).get(i9) + posAr.get(9).get(i10);
                                                                tt += posAr.get(10).get(i11) + posAr.get(11).get(i12);
                                                                if (tt > totals[2]) { // Cut Down on time
                                                                    break;
                                                                } else if (tt == totals[2]) { // Third Row (1 Min 30 Sec)
                                                                    for (int i13 = 0; i13 < posAr.get(12).size(); i13++) {
                                                                        for (int i14 = 0; i14 < posAr.get(13).size(); i14++) {
                                                                            for (int i15 = 0; i15 < posAr.get(14).size(); i15++) {
                                                                                for (int i16 = 0; i16 < posAr.get(15).size(); i16++) {
                                                                                    tt = posAr.get(12).get(i13) + posAr.get(13).get(i14);
                                                                                    tt += posAr.get(14).get(i15) + posAr.get(15).get(i16);
                                                                                    if (tt > totals[3]) { // Cut Down on time
                                                                                        break;
                                                                                    } else if (tt == totals[3]) { // Forth Row
                                                                                        con++;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    con++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
//                                                System.out.println("Made it here");
//                                                con++;
                                            }
                                        }
                                    }
                                }
                            }
//                            System.out.println(posAr.get(0).get(i1) + " " + posAr.get(1).get(i2) + " " + posAr.get(2).get(i3) + " " + posAr.get(3).get(i4));
                        }
                    }
                }
            }
        }

        System.out.println("Number of counts: " + con); // Testing speed
        int speed = 1;

        for (int i = 0; i < posAr.size(); i++) {
            speed *= posAr.get(i).size();
        }

        System.out.println("Number of combinations: " + speed);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.print(grid[x][y] + " ");
                System.out.println(Arrays.toString(posAr.get(x * 4 + y).toArray()));
            }
            System.out.println(tmpTot[x]);
            System.out.println();
        }
    }

    /* Returns ArrayList with numbers under row (r) and Column (c) */
    private static ArrayList<Integer> trim(Object[] array, int r, int c) {
        ArrayList<Integer> ar = new ArrayList();
        int min = Math.min(r, c); // Minimum number
        for (int i = 0; i < array.length; i++) {
            if (Integer.parseInt(array[i].toString()) < min) {
                ar.add(Integer.parseInt(array[i].toString()));
            } else {
                break;
            }
        }
        return ar;
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
                return false;
            }
        }
        /* Check columns */
        for (int i = 0; i < grid.length; i++) {
            int tot = 0; // Total for line
            for (int o = 0; o < grid[i].length; o++) {
                tot += grid[o][i];
            }
            if (tot != totals[i * 4]) {
                return false;
            }
        }
        /* Check Diagonal */
        int tot = 0; // Total for diagonal
        for (int i = 0; i < grid.length; i++) {
            tot += grid[i][i];
        }
        if (tot == totals[totals.length]) {
            return true;
        } else {
            return false;
        }
    }
}
