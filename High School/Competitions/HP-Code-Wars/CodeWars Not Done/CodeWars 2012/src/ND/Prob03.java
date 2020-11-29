package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Reversi Moves
//        Points: 4
        Scanner scan = new Scanner(new File("prob03.txt"));
        /* Setup */
        char grid[][] = new char[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                grid[x][y] = '.';
            }
        }
        grid[3][3] = 'W';
        grid[4][3] = 'B';
        grid[3][4] = 'B';
        grid[4][4] = 'W';
        /* Start the Game */
        boolean white = true; // Turn
        String a = scan.nextLine();
        while (!a.equals("END")) {
            int x = a.charAt(1) - '1';
            int y = a.charAt(0) - 'a';
            System.out.println(x + " " + y);
            if (white) {
                grid[x][y] = 'W';
            } else {
                grid[x][y] = 'B';
            }
            /**
             * Need to add the check statements here
             */
            int con = x;

            white = !white; // Switches turn
            a = scan.nextLine();
        }

        /* Prints out the array */
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }

}
