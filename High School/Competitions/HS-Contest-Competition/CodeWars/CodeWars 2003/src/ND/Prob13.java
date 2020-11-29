package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    public static void main(String[] args) throws Exception {
//        Problem: Magic Square
//        Points: 13
        Scanner scan = new Scanner(new File("prob13.txt"));
        String grid[][] = new String[4][4];
        /* Scans in the square */
        for (int i = 0; i < 4; i++) {
            grid[i] = scan.nextLine().split("[ ]+");
        }

    }
}
