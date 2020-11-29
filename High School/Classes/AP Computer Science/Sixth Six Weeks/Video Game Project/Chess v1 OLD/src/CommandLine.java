
import static java.lang.System.out;
import java.util.Scanner;

public class CommandLine {

    final static public int BLANK = 0;
    final static public int PAWN = 1;
    final static public int KNIGHT = 2;
    final static public int BISHOP = 3;
    final static public int ROOK = 4;
    final static public int QUEEN = 5;
    final static public int KING = 6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println("Welcome to chess");
        String fin[][] = new String[8][8];
        int board[][] = setUp();
        int turn = 1;
        while (turn != 0) {
            String whoTurn = turn == 1 ? "Whites Turn" : "Black Turn";
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    out.print(board[y][x] + " ");
                }
                out.println();
            }
            out.println(whoTurn);
            boolean valid = false;
            while (!valid) {
                out.println("Enter Piece Spot");
                int x = scan.nextInt();
                int y = scan.nextInt();
                out.println("Enter the Move Spot");
                int x1 = scan.nextInt();
                int y1 = scan.nextInt();
                valid = board[y1][x1] == 0;
                if (valid && (!(board[y][x] == 0))) {
                    board[y1][x1] = board[y][x];
                    board[y][x] = 0;
                } else {
                    valid = false;
                }
            }
            turn = turn == 1 ? 2 : 1;
        }
    }

    private static int[][] setUp() {
        int a[][] = new int[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                a[y][x] = 0;
            }
        }
        // Puts the Pawns on the board
        for (int i = 0; i < 8; i++) {
            a[1][i] = 1;
            a[6][i] = -1;
        }
        // Put the rooks on the board
        a[0][0] = 4;
        a[0][7] = 4;
        a[7][0] = -4;
        a[7][7] = -4;
        // Creates the Knight
        a[0][1] = 2;
        a[0][6] = 2;
        a[7][1] = -2;
        a[7][6] = -2;
        // Creates the Bisshops
        a[0][2] = 3;
        a[0][5] = 3;
        a[7][2] = -3;
        a[7][5] = -3;
        // Creates the Queen
        a[0][3] = 5;
        a[7][4] = -5;
        // Creates the King
        a[0][3] = 6;
        a[7][4] = -6;
        /*
        4, 2, 3, 6, 5, 3, 2, 4, 7, 7, // white pieces
        1, 1, 1, 1, 1, 1, 1, 1, 7, 7, // white pawns
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        -1, -1, -1, -1, -1, -1, -1, -1, 7, 7, // black pawns
        -4, -2, -3, -6, -5, -3, -2, -4, 7, 7
        
         */
        return a;
    }
}
