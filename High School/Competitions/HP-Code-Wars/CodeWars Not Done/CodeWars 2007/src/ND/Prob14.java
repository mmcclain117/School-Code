package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    private static char gr[][] = new char[8][8];

    public static void main(String[] args) throws Exception {
//        Problem: Chess Knight 
//        Points: 18
        Scanner scan = new Scanner(new File("prob14.txt"));
        String start = scan.nextLine(); // Start
        int startX = (start.charAt(0) - 'a'); // Start X
        int startY = 8 - Integer.parseInt(start.charAt(1) + ""); // Start Y
        gr[startY][startX] = 'S';
        System.out.println(startY);
        String end = scan.nextLine(); // Finish
        int endX = (end.charAt(0) - 'a'); // Finish X
        int endY = 8 - Integer.parseInt(end.charAt(1) + ""); // Finish Y
        gr[endY][endX] = 'E';
        String blocked = scan.nextLine(); // Blocked
        /* Write the Blocked Spaces */
        while (!"xx".equals(blocked)) {
            int tmpX = (blocked.charAt(0) - 'a'); // X
            int tmpY = 8 - Integer.parseInt(blocked.charAt(1) + ""); // Y
            gr[tmpY][tmpX] = 'b';
            blocked = scan.nextLine();
        }
//        print();

        ArrayList<ArrayList<String>> ar = new ArrayList();
        ArrayList<String> startingAr = new ArrayList();
        startingAr.add(((char) (startX + 'a')) + "" + startY);
        ar.add(startingAr);
        boolean found = true;
        while (!ar.isEmpty()) {
            ArrayList<String> temp = ar.remove(0);
            String cur = temp.get(temp.size() - 1);
//            System.out.println(Arrays.toString(temp.toArray()));
            int xx = (cur.charAt(0) - 'a'); // X
            int yy = 8 - Integer.parseInt(cur.charAt(1) + ""); // Y
//            System.out.println(cur + " " + yy + " " + xx);
            if (move(xx + 1, yy - 2)) { // Right 1 Up 2
                temp.add(((char) ((xx + 1) + 'a')) + "" + (yy - 2));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx + 1, yy - 2)) { // It has been found
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx + 1, yy + 2)) { // Right 1 Down 2
                temp.add(((char) ((xx + 1) + 'a')) + "" + (yy + 2));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx + 1, yy + 2)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            System.out.println(Arrays.toString(temp.toArray()));
            if (move(xx + 2, yy - 1)) { // Right 2 Up 1
                temp.add(((char) ((xx + 2) + 'a')) + "" + (yy - 1));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx + 2, yy - 1)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx + 2, yy + 1)) { // Right 2 Down 1
                temp.add(((char) ((xx + 2) + 'a')) + "" + (yy + 1));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx + 2, yy + 1)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx - 1, yy + 2)) { // Left 1 Down 2
                temp.add(((char) ((xx - 1) + 'a')) + "" + (yy + 2));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx - 1, yy + 2)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx - 1, yy - 2)) { // Left 1 Up 2
                temp.add(((char) ((xx - 1) + 'a')) + "" + (yy - 2));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx - 1, yy - 2)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx - 2, yy + 1)) { // Left 2 Down 1
//                System.out.println("Before " + Arrays.toString(temp.toArray()));
                temp.add(((char) ((xx - 2) + 'a')) + "" + (yy + 1));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
//                System.out.println("AFTER " + Arrays.toString(temp.toArray()));
//                System.out.println("AR " + Arrays.toString(ar.get(ar.size() - 1).toArray()));
                if (Check(xx - 2, yy + 1)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
            if (move(xx - 2, yy - 1)) { // Left 2 Up 1
                temp.add(((char) ((xx - 2) + 'a')) + "" + (yy - 1));
                ar.add(copy(temp));
                temp.remove(temp.size() - 1);
                if (Check(xx - 2, yy - 1)) {
                    found = false;
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i));
                    }
                    break;
                }
            }
//            print();
//            System.out.println(ar.size());
        }
//        while (!ar.isEmpty()) {
        ArrayList<String> temp = ar.get(ar.size() - 1);
//            ArrayList<String> temp = ar.remove(0);
        for (int i = 0; i < temp.size(); i++) {
            String solution = temp.get(i);
            System.out.print(solution.charAt(0));
            System.out.print((8 - Integer.parseInt(solution.charAt(1) + "")) + " ");
        }
        System.out.println(temp.size());

//        }
        print();

    }

    /* Checks if spot is in the grid */
    private static boolean move(int x, int y) {
        try {
            if (gr[y][x] == 'S' || gr[y][x] == 'b' || gr[y][x] == 'v') {
                return false;
            } else if (gr[y][x] == 'E') {
                return true;
            } else {
                gr[y][x] = 'v';
//                print();
//                System.out.println();
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /* Prints out the array */
    private static void print() {
        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[0].length; j++) {
                System.out.print((gr[i][j] > 15 ? gr[i][j] : "_") + " ");
            }
            System.out.println();
        }
    }

    /* Check to see if it is the end point */
    private static boolean Check(int x, int y) {
        try {
//            System.out.println(gr[y][x] + " " + x + " " + y);\
            return gr[y][x] == 'E';
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /* Return Copy Of ArrayList */
    private static ArrayList<String> copy(ArrayList<String> temp) {
        ArrayList<String> ar = new ArrayList();
        for (String q : temp) {
            ar.add(q);
        }
        return ar;
    }
}
