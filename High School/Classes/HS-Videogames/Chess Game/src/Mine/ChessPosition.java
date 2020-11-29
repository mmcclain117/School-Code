package Mine;

/**
 *
 * @author Master Ward
 */
public class ChessPosition {

    final static public int BLANK = 0;
    final static public int PAWN = 1;
    final static public int KNIGHT = 2;
    final static public int BISHOP = 3;
    final static public int ROOK = 4;
    final static public int QUEEN = 5;
    final static public int KING = 6;
    public int[] board = new int[80];
    boolean bWhiteKingMoved = false;
    boolean bBlackKingMoved = false;
    boolean bWhiteChecked = false;
    boolean bBlackChecked = false;
    int enPassantSquare = 0;

    public void makeMove(ChessMove move) {
        board[move.to] = board[move.from];
        board[move.from] = 0;

        if (move.to >= 70) {
            if (board[move.to] == PAWN) {
                board[move.to] = QUEEN;
            }
        } else if (move.to < 8) {
            if (board[move.to] == -PAWN) {
                board[move.to] = -QUEEN;
            }
        } else if (board[move.to] == KING && !bWhiteKingMoved) {
            bWhiteKingMoved = true;
        } else if (board[move.to] == -KING && !bBlackKingMoved) {
            bBlackKingMoved = true;
        }// else
    }

    public ChessPosition(ChessPosition p) {
        System.arraycopy(p.board, 0, board, 0, 80);
        //eval = p.eval;
        bWhiteKingMoved = p.bWhiteKingMoved;
        bBlackKingMoved = p.bBlackKingMoved;

        bWhiteChecked = p.bWhiteChecked;
        bBlackChecked = p.bBlackChecked;

    }

    /**
     * Constructs an empty chess board.
     */
    public ChessPosition() {
    }
}
