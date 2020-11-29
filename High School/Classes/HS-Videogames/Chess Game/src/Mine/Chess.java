package Mine;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Master Ward
 */
public class Chess {

    public static Main main;
    public static final boolean DEBUG = false;
    final static public boolean WHITE = true;
    final static public boolean BLACK = false;
    public static boolean HUMAN = WHITE;
    public static boolean PROGRAM = BLACK;
    public boolean bWhoseTurn = WHITE;
    public boolean bIterativeDeepening = true;
    public static int nodeCount = 0; // number of many alpha-beta nodes being searched
    public static int maxDepth = 5; // The Default AI Difficulty level
    public static boolean bThinking = false;
    public static Stack boardHistory = new Stack();

    private static int[] initialBoard = {
        4, 2, 3, 6, 5, 3, 2, 4, 7, 7, // white pieces
        1, 1, 1, 1, 1, 1, 1, 1, 7, 7, // white pawns
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7, // 8 blank squares, 2 off board
        -1, -1, -1, -1, -1, -1, -1, -1, 7, 7, // black pawns
        -4, -2, -3, -6, -5, -3, -2, -4, 7, 7 // black pieces
    };
    private final static int[] index = {
        0, 12, 15, 10, 1, 6, 6
    };

    public static ChessPosition pos = new ChessPosition();
    public static ChessPosition workPos = new ChessPosition();

    private final static int[] pieceMovementTable = {
        0, -1, 1, 10, -10, 0, // Rook
        -1, 1, 10, -10, -9, -11, 9, 11, 0, // Queen / Bishop / King
        8, -8, 12, -12, 19, -19, 21, -21, 0, // Knight
        10, 20, 0
    };

    private final static float[] value = {
        0.0f, 1.0f, 3.0f, 3.2f, 5.0f, 9.0f, 300.0f
    };

    private static ChessMove[] possibleCaptures = new ChessMove[256];
    private static ChessMove[] possibleMoveList = new ChessMove[256];
    private static int[] piece_moves = new int[32];
//    private final sun.applet.Main mains;

    public boolean drawnPosition(ChessPosition p) {
        return false;
    }

    public boolean wonPosition(ChessPosition p, boolean player) {
        return false;
    }

    boolean isValidMove(ChessPosition p, ChessMove move) {
        if (bThinking) {
            return false;
        }

        boolean player = (p.board[move.from] < 0) ? BLACK : WHITE;

        boolean bOK = false;

        // is it en-passant?
        if (p.enPassantSquare > 0
                && p.board[move.from] == (player ? ChessPosition.PAWN : -ChessPosition.PAWN)) {
            int offset = move.to - move.from;
            if (offset < 0) {
                offset = -offset;
            }
            if (offset == 11 || offset == 9) {
                if (p.board[move.from - 1] == (player ? -ChessPosition.PAWN : ChessPosition.PAWN)
                        || p.board[move.from + 1] == (player ? -ChessPosition.PAWN : ChessPosition.PAWN)) {
                    bOK = true;
                }
            }
        }
        int nMoves = calcPieceMoves(p, move.from);

        for (int i = 0; i < nMoves && !bOK; i++) {
            if (move.to == piece_moves[i]) {
                bOK = true;
            }
        }
        if (!bOK) {
            return false;
        }

        ChessPosition np = new ChessPosition(p);
        np.makeMove(move);

        calcPossibleMoves(np, !player);

        return !(player ? np.bWhiteChecked : np.bBlackChecked);
    }

    protected ChessMove alphaBeta(int depth, ChessPosition p, boolean player) {
        nodeCount = 0;
        reachedDepth = 0;

        // Find out if anyone is currently in check (this is kinda skipped by 0-level a-b)
        //calcPossibleMoves( p, player );
        if (maxDepth > 3 && bIterativeDeepening) {
            int prevDepth = maxDepth;
            maxDepth = 3;

            float beta = 100000.0f;

            for (int md = 3; md < prevDepth + 1; md++) {
                maxDepth = md;

                beta = alphaBetaHelper(depth, p, player, 100000.0f, -beta);
                if (!bThinking) {
                    break;
                }
            }
            maxDepth = prevDepth;
            bestMoveEval = beta;
        } else {
            bestMoveEval = alphaBetaHelper(depth, p, player, 100000.0f, -100000.0f);
        }

        return bestMove;
    }
    public static int reachedDepth = 0;
    public static ChessMove bestMove = new ChessMove(); // Used to reference the ACTUAL move
    static int localMaxima = 0;
    public static ChessMove localBestMove = null;
    public static boolean bCheck = false;
    public static ChessMove[] principalVariation = new ChessMove[16]; // there will under no circumstances be more than 16 moves in there :)

    protected float alphaBetaHelper(int depth, ChessPosition p, boolean player, float alpha, float beta) {

        int num = 0;

        if (player ? p.bBlackChecked : p.bWhiteChecked) {
            num = calcPossibleMoves(p, player);

            if (player ? p.bBlackChecked : p.bWhiteChecked) {
                if (depth == 2) {
                    return (maxDepth - depth + localMaxima + 1) * 2000;
                }
                return (maxDepth - depth + localMaxima + 1) * 1000; // +1 so it's never 0;
            }
        }

        if (depth > reachedDepth) {
            reachedDepth = depth;
        }

        // Have we reached our maximum depths?
        if ((depth - localMaxima >= maxDepth) || !bThinking) // Test if we have reached our maximum depth and cut-off here
        {
            return positionEvaluation(p, player);
        }

        if (num == 0) // we're hoping this isn't a stalemate :)
        {
            num = calcPossibleMoves(p, player);
        }

        float value = 0;

        ChessMove[] chessMove = new ChessMove[num];// = new ChessMove[num];

        int nMoves = num - nPossibleCaptures;
        int i;

        for (i = 0; i < nPossibleCaptures; i++) {
            chessMove[i] = new ChessMove(possibleCaptures[i]);
        }

        for (i = 0; i < nMoves; i++) {
            chessMove[nPossibleCaptures + i] = new ChessMove(possibleMoveList[i]);
        }

        int prevToVal = 0; // the previous value of the to block
        int prevFromVal = 0;
        boolean bWhiteKingMoved;// = false;
        boolean bBlackKingMoved;// = false;

        for (i = 0; i < num; i++) // Iterate through moves and recursively call self
        {
            // If we are taking a piece, make sure to search ahead so that it's not bogus!
            if (p.board[chessMove[i].to] != 0 || p.board[chessMove[i].from] == (player ? ChessPosition.PAWN : -ChessPosition.PAWN)) {
                localMaxima = 2;
            }

            bWhiteKingMoved = p.bWhiteKingMoved;
            bBlackKingMoved = p.bBlackKingMoved;

            prevFromVal = p.board[chessMove[i].from];
            prevToVal = p.board[chessMove[i].to];

            p.makeMove(chessMove[i]);

            ++nodeCount; // A diagnostic, counting the positions we have searched.

            value = -alphaBetaHelper(depth + 1, p, !player, -beta, -alpha);

            p.board[chessMove[i].from] = prevFromVal;
            p.board[chessMove[i].to] = prevToVal;
            p.bWhiteKingMoved = bWhiteKingMoved;
            p.bBlackKingMoved = bBlackKingMoved;

            if (localMaxima != 0) {
                localMaxima = 0;
            }

            if (value >= alpha) {
                return alpha;
            }

            if (value > beta) {
                beta = value;
                principalVariation[depth].from = chessMove[i].from;
                principalVariation[depth].to = chessMove[i].to;

                if (depth == 0) {
                    bestMove = chessMove[i];
                }
            }

        }

        return beta;
    }

    public static float bestMoveEval;

    public ChessPosition playGame(ChessPosition startingPosition, boolean bAsPlayer) {
        // Let's clear the principal variation
        for (int i = 0; i < 16; i++) {
            principalVariation[i].from = 0;
            principalVariation[i].to = 0;
        }

        workPos = new ChessPosition(startingPosition);

        bestMove = null;

        // First, build a vector of "good" possible positions
        // we're using iterative deepening to first a get a feel for a good move
        bestMove = alphaBeta(0, workPos, bAsPlayer);

        if (!bThinking) {
            return startingPosition;
        }

        if (bestMove == null) {
            main.alert("It's a draw", "Stalemate.");
        } else {
            main.playerMoved(Chess.PROGRAM, bestMove);
            startingPosition.makeMove(bestMove);
        }

        while (true) // a dummy to avoid silly returns
        {
            // Do some tests about the current position
            if (wonPosition(startingPosition, PROGRAM)) {
                System.out.println("Program won");
                break;
            }
            if (wonPosition(startingPosition, HUMAN)) {
                System.out.println("Human won");
                break;
            }
            if (drawnPosition(startingPosition)) {
                System.out.println("Drawn game");
                break;
            }
            break;
        }

        return startingPosition;

    }

    int sideChecked = 0; // if 0, no side, if 1, white, if -1, black

    public float positionEvaluation(ChessPosition p, boolean player) {
        ChessPosition pos = p;
        int[] b = pos.board;
        float ret = 0.0f;
        int pieceType = 0;
        float val = 0;
        int i;

        float control = 0;

        // adjust for material:
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                i = y * 10 + x;
                if (b[i] == 0) {
                    continue;
                }

                // Calculate Positional Advantage
                control += humanControl[i];
                control -= computerControl[i];

                if (b[i] < 0) {
                    if (humanControl[i] > computerControl[i]) {
                        control += value[-b[i]];
                    }
                } else if (humanControl[i] < computerControl[i]) {
                    control -= value[b[i]];
                }

                // Calculate Material Advantage
                pieceType = b[i];
                if (pieceType < 0) {
                    pieceType = -pieceType;
                }

                val = value[pieceType];
                val *= 5; // quadruple material value
                if (b[i] < 0) {
                    val = -val;
                }

                ret += val;
            }
        }

        // Count center squares extra:
        control += humanControl[33] - computerControl[33];
        control += humanControl[34] - computerControl[34];
        control += humanControl[43] - computerControl[43];
        control += humanControl[44] - computerControl[44];

        control *= 0.333;///= 30;//20;
        ret += control;

        // adjust if computer side to move:
        if (!player) {
            ret = -ret;
        }

        return ret;
    }

    private int calcPieceMoves(ChessPosition pos, int square_index) {
        int[] b = pos.board;
        int piece = b[square_index];
        int piece_type = piece;
        if (piece_type < 0) {
            piece_type = -piece_type;
        }
        int count = 0, side_index, move_offset, temp, next_square;
        int piece_index = index[piece_type];
        int move_index = pieceMovementTable[piece_index];
        int target = 0;

        if (piece < 0) {
            side_index = -1;
        } else {
            side_index = 1;
        }

        int[] control = (piece < 0) ? computerControl : humanControl;

        switch (piece_type) {
            case 0:
            case 7:
                break;

            case ChessPosition.PAWN: {
                // Check if pawn can take left
                move_offset = square_index + (side_index * 10) + 1;
                if (move_offset >= 0 && move_offset < 80) {
                    target = b[move_offset];

                    if ((piece > 0 && target < 0 && target != 7)
                            || (piece < 0 && target > 0 && target != 7)) {
                        piece_moves[count++] = move_offset;
                        control[move_offset] += 12;

                        if (target == ChessPosition.KING) {
                            pos.bWhiteChecked = true;
                        } else if (target == -ChessPosition.KING) {
                            pos.bBlackChecked = true;
                        }
                    }
                }

                move_offset = square_index + (side_index * 10) - 1;
                if (move_offset >= 0 && move_offset < 80) {
                    target = b[move_offset];

                    if ((piece > 0 && target < 0 && target != 7)
                            || (piece < 0 && target > 0 && target != 7)) {
                        piece_moves[count++] = move_offset;
                        control[move_offset] += 12;

                        if (target == ChessPosition.KING) {
                            pos.bWhiteChecked = true;
                        } else if (target == -ChessPosition.KING) {
                            pos.bBlackChecked = true;
                        }
                    }
                }

                move_offset = square_index + (side_index * 20);

                if (move_offset >= 0 && move_offset < 80) {
                    temp = (piece > 0) ? 1 : 6;

                    if (b[move_offset] == 0
                            && (square_index / 10) == temp
                            && ((piece < 0 && b[square_index - 10] == 0)
                            || (piece > 0 && b[square_index + 10] == 0))) {
                        piece_moves[count++] = move_offset;
                    }
                }

                move_offset = square_index + side_index * 10;

                if (move_offset >= 0 && move_offset < 80) {
                    if (b[move_offset] == 0) {
                        piece_moves[count++] = move_offset;
                    }
                }

            }
            break;

            default: {
                move_index = piece;
                if (move_index < 0) {
                    move_index = -move_index;
                }
                move_index = index[move_index];

                next_square = square_index + pieceMovementTable[move_index];

                outer:

                while (true) {
                    inner:

                    while (true) {
                        if (next_square >= 80
                                || next_square < 0
                                || b[next_square] == 7) // can't I just % 10 ?
                        {
                            break inner;
                        }

                        target = b[next_square];

                        // check for piece on the same side:
                        if ((side_index < 0 && target < 0)
                                || (side_index > 0 && target > 0)) {
                            break inner;
                        }

                        control[next_square] += 1;

                        piece_moves[count++] = next_square;

                        if (target == pos.KING) {
                            pos.bWhiteChecked = true;
                        } else if (target == -pos.KING) {
                            pos.bBlackChecked = true;
                        }

                        if (target != 0) {
                            break inner;
                        }

                        if (piece_type == ChessPosition.KNIGHT
                                || piece_type == ChessPosition.KING) {
                            break inner;
                        }

                        next_square += pieceMovementTable[move_index];
                    }

                    ++move_index;

                    if (pieceMovementTable[move_index] == 0) {
                        break outer;
                    }

                    next_square = square_index + pieceMovementTable[move_index];
                }
            }
        }
        return count;
    }

    void Takeback() {
        if (!boardHistory.empty()) {
            pos = new ChessPosition((ChessPosition) boardHistory.pop());
        }
    }

    public static int nPossibleCaptures = 0;

    public int calcPossibleMoves(ChessPosition pos, boolean player) {
        // Clear our control data, so it can be cleanly manipulated by the calcPiece function
        Arrays.fill(humanControl, 0);
        Arrays.fill(computerControl, 0);

        int[] b = pos.board;

        pos.bWhiteChecked = false; // we will shortly determine this
        pos.bBlackChecked = false; // we will shortly determine this

        int count = 0;
        nPossibleCaptures = 0;
        int i = 0;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                i = y * 10 + x;

                if (b[i] == 0) {
                    continue;
                }

                int board_val = b[i];

                int num = calcPieceMoves(pos, i);
                if (board_val < 0 && !player || board_val > 0 && player) {

                    for (int j = 0; j < num; j++) {
                        // if it's a capture add it to the capture list, to be evaluated first.
                        if (b[piece_moves[j]] != 0
                                || b[i] == (player ? ChessPosition.PAWN : -ChessPosition.PAWN)
                                || piece_moves[j] == 33 || piece_moves[j] == 34
                                || piece_moves[j] == 43 || piece_moves[j] == 44) {
                            possibleCaptures[nPossibleCaptures].from = i;
                            possibleCaptures[nPossibleCaptures].to = piece_moves[j];
                            ++nPossibleCaptures;
                        } else //	if ( b[ piece_moves[j] ] == 0 && (b[i] != PAWN && b[i] != -PAWN) )
                        {
                            possibleMoveList[count].from = i;
                            possibleMoveList[count].to = piece_moves[j];
                            ++count;
                        }
                    }
                }

            }
        }
        return count + nPossibleCaptures;
    }

    public void NewGame() {
        boardHistory.clear();
        pos = new ChessPosition();
        System.arraycopy(initialBoard, 0, pos.board, 0, 80);
        System.arraycopy(initialBoard, 0, pos.board, 0, 80);
        workPos = new ChessPosition();
        System.arraycopy(initialBoard, 0, workPos.board, 0, 80);
    }

    /**
     *
     * @param mains
     */
//    public Chess(sun.applet.Main mains) {
    public Chess(Main mains) {
        for (int i = 0; i < 256; i++) {
            possibleMoveList[i] = new ChessMove();
        }
        for (int i = 0; i < 256; i++) {
            possibleCaptures[i] = new ChessMove();
        }
        for (int i = 0; i < 16; i++) {
            principalVariation[i] = new ChessMove();
        }
//        Chess.main = mains;
        NewGame();
//        this.mains = mains;

    }

    private static int[] computerControl = new int[80];
    private static int[] humanControl = new int[80];

    private static void setControlData(ChessPosition pos) {
        for (int i = 0; i < 80; i++) {
            computerControl[i] = 0;
            humanControl[i] = 0;
        }
        int[] b = pos.board;
        int[] control; // set to computerControl or humanControl, as appropriate

        for (int square_index = 0; square_index < 80; square_index++) {
            int piece = b[square_index];

            if (piece == 7 || piece == 0) {
                continue;
            }
            int piece_type = piece;

            if (piece_type < 0) {
                piece_type = -piece_type;
                control = computerControl;
            } else {
                control = humanControl;
            }
            int count = 0, side_index, move_offset, temp, next_square;
            int piece_index = index[piece_type];
            int move_index = pieceMovementTable[piece_index];
            if (piece < 0) {
                side_index = -1;
            } else {
                side_index = 1;
            }
            switch (piece_type) {
                case ChessPosition.PAWN: {
                    // first check for possible pawn captures:
                    for (int delta = -1; delta <= 1; delta += 2) {
                        move_offset = square_index + side_index * 10 + delta;
                        if (move_offset > 0 && move_offset < 80) {
                            int target = b[move_offset];
                            if ((target <= -1 && target != 7 && piece > 0)
                                    || (target >= 1 && target != 7 && piece < 0)) {
                                control[square_index + side_index * delta] += 12;
                            }
                        }
                    }
                }

                case ChessPosition.KNIGHT:
                case ChessPosition.BISHOP:
                case ChessPosition.ROOK:
                case ChessPosition.KING:
                case ChessPosition.QUEEN: {
                    move_index = piece;
                    if (move_index < 0) {
                        move_index = -move_index;
                    }
                    move_index = index[move_index];

                    next_square = square_index + pieceMovementTable[move_index];
                    outer:
                    while (true) {
                        inner:
                        while (true) {
                            if (next_square > 79) {
                                break inner;
                            }
                            if (next_square < 0) {
                                break inner;
                            }
                            if (b[next_square] == 7) {
                                break inner;
                            }
                            control[next_square] += 1;

                            // the next statement should be augmented for x-ray analysis:
                            if (side_index < 0 && b[next_square] < 0) {
                                break inner;
                            }
                            if (side_index > 0 && b[next_square] > 0 && b[next_square] != 7) {
                                break inner;
                            }
                            if (piece_type == ChessPosition.PAWN
                                    && (square_index / 10 == 3)) {
                                break inner;
                            }
                            if (piece_type == ChessPosition.KNIGHT) {
                                break inner;
                            }
                            if (piece_type == ChessPosition.KING) {
                                break inner;
                            }

                            next_square += pieceMovementTable[move_index];
                        }
                        move_index += 1;
                        if (pieceMovementTable[move_index] == 0) {
                            break outer;
                        }
                        next_square = square_index + pieceMovementTable[move_index];
                    }
                }
            }
        }
    }

    final static char[] pieceChars = {
        'p', 'n', 'b', 'r', 'q', 'k'
    };

    public static char getPieceChar(int square_index) {
        if (square_index == 0) {
            return '0';
        }
        if (square_index > 0) {
            return pieceChars[square_index - 1];
        }

        square_index = -square_index;

        return Character.toUpperCase(pieceChars[square_index - 1]);
    }

    public static ChessPosition decodePosition(String s) {
        ChessPosition p = new ChessPosition();
        int index = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 10; x++) {
                index = y * 10 + x;
                if (x > 7) {
                    p.board[index] = 7;
                } else {
                    int str_index = y * 8 + x;

                    char c = s.charAt(str_index);
                    if (c == '0') {
                        p.board[index] = 0;
                        continue;
                    }
                    for (int k = 0; k < 6; k++) {
                        if (Character.toLowerCase(c) == pieceChars[k]) {
                            p.board[index] = k + 1;
                        }
                    }

                    // Adjust for black pieces
                    if (Character.isUpperCase(c)) {
                        p.board[index] = -p.board[index];
                    }

                }
            }
        }

        return p;
    }

    public static String encodePosition(ChessPosition p) {
        String str = new String();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                str += getPieceChar(p.board[y * 10 + x]);
            }
        }
        return str;
    }
}
