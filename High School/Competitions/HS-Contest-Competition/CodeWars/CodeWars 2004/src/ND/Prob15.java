package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob15 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob15.txt"));
        String grid[][] = setup();
//        print(grid);
        /* Play the Game */
        while (scan.hasNext()) {
            String move = scan.nextLine();
            System.out.println(move);
            char piece = move.charAt(0); // Piece Movings
            int mx = move.charAt(move.length() - 2) - 'a'; // Moving X Spot
            int my = Integer.parseInt(move.substring(move.length() - 1)); // Moving Y spot
            boolean capture = move.contains("x");// If Piece is captured
            System.out.println(piece + " " + mx + " " + my + " " + capture);

            /* Now find the Piece*/
             /* Move the piece */
        }
    }

    /* Sets up the initial board */
    private static String[][] setup() {
        String grid[][] = new String[8][8];
//        Fill with all empty spots
        for (int i = 0; i < grid.length; i++) {
            for (int o = 0; o < grid[0].length; o++) {
                grid[i][o] = "XX";
            }
        }
        /* Set the pieces */
//        Black Pieces
        grid[0][0] = "BR"; // Black Rook
        grid[0][1] = "BN"; // Black Knight
        grid[0][2] = "BB"; // Black Bishop
        grid[0][3] = "BQ"; // Black Queen
        grid[0][4] = "BK"; // Black King
        grid[0][5] = "BB"; // Black Bishop        
        grid[0][6] = "BN"; // Black Knight
        grid[0][7] = "BR"; // Black Rook
        for (int i = 0; i < 8; i++) { // Black Pawns
            grid[1][i] = "BP";
        }
//        White Pieces
        grid[7][0] = "WR"; // White Rook
        grid[7][1] = "WN"; // White Knight
        grid[7][2] = "WB"; // White Bishop
        grid[7][3] = "WQ"; // White Queen
        grid[7][4] = "WK"; // White King
        grid[7][5] = "WB"; // White Bishop        
        grid[7][6] = "WN"; // White Knight
        grid[7][7] = "WR"; // White Rook
        for (int i = 0; i < 8; i++) { // White Pawns
            grid[6][i] = "WP";
        }
        return grid;
    }

    /* Prints out the 2d Array */
    private static void print(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int o = 0; o < grid[0].length; o++) {
                System.out.print(grid[i][o] + " ");
            }
            System.out.println();
        }
    }
}
