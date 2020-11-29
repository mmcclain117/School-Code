package ND;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Michael Scheetz
 *
 * <pre>
 * Problem: Artifacts in a room are label by a unique single digit alpha-numeric character.
 *          Duplicate characters indicate a large artifact that must all move as a single object.
 *          Artifacts labeled with a numeric can only move L or R.  Artifacts labeled with alpha
 *          can only move U or D.  Find the solution with the given number of moves.
 *
 *
 * Steps:
 *  1. Parse input into artifacts and a room with initial state.
 *  2. depth-first recursion of each artifact at current state:
 *   A. if exit criteria then print
 *   B. else if moves = max depth then return.
 *   C. else search for all possible moves.
 *    a. push move
 *    b. call recursive
 *    c. pop move
 * Done
 */
public class Prob16 {

    private final InputParser parser;

    /**
     * Read the input and solve the problem. Passing exceptions all the way up
     * makes the code simpler.
     *
     * @param args
     * @throws Exception For any issue.
     */
    public static void main(final String[] args) throws Exception {
        final String filename = "prob16.txt";
        final InputHandler inputHandler = new InputHandler(filename);
        final List<String> input = inputHandler.readInput();

        final Prob16 problem = new Prob16(input);
        final Solution solution = problem.solve();
        System.out.println(solution);
    }

    public Prob16(final List<String> input) {
        parser = new InputParser(input);
    }

    private Solution solve() {
        final Room room = parser.getRoom();
        final Solution initialState = new Solution(room, new Moves());
        final Solution solution = initialState.solve();
        return solution;
    }

    private static class Artifact {

        private static final Set<Direction> UPDOWN = Collections.unmodifiableSet(EnumSet
                .of(Direction.U,
                        Direction.D));
        private static final Set<Direction> SIDESIDE = Collections
                .unmodifiableSet(EnumSet
                        .of(Direction.L,
                                Direction.R));

        private final String id;
        private final Set<Direction> directions;

        public Artifact(final String artifactId) {
            id = artifactId;
            directions = factory(artifactId);
        }

        private Set<Direction> factory(final String artifactId) {
            if (id.matches("[0-9]")) {
                return SIDESIDE;
            } else if (id.matches("[a-j]")) {
                return UPDOWN;
            } else {
                throw new IllegalArgumentException(
                        "Error: Unhandled artifact Id: "
                        + id
                        + ".  Expected something in ranges [0-9] or [a-j].");
            }
        }

        public String getId() {
            return id;
        }

        public Collection<Movement> possibleMoves() {
            final Collection<Movement> moves = new ArrayList<Movement>();
            for (final Direction dir : directions) {
                final Movement move = new Movement(this, dir);
                moves.add(move);
            }
            return moves;
        }

        @Override
        public String toString() {
            return id;
        }
    }

    private static class Room {

        private static int toStringLineBreak;
        private static Tile plate;
        private static final Map<String, Artifact> artifactsById = new HashMap<String, Artifact>();
        private static final Map<String, Tile> tilesById = new HashMap<String, Tile>();

        private final Map<Tile, String> tileState = new TreeMap<Tile, String>();
        private final Map<Artifact, Collection<Tile>> artifactState = new HashMap<Artifact, Collection<Tile>>();

        public void addTile(final Tile tile, final String initialCoverId) {
            tilesById.put(tile.getId(), tile);
            tileState.put(tile, initialCoverId);
        }

        public Room move(final Movement move) {
            final Artifact artifact = move.getArtifact();
            final Collection<Tile> currentTiles = artifactState.get(artifact);
            final Collection<Tile> newTiles = determineNewTilesForArtifact(
                    currentTiles, move.getDirection());
            if (!newTiles.isEmpty() && !occupied(newTiles, artifact.getId())) {
                final Room retval = new Room();
                // Copy current state
                retval.tileState.putAll(this.tileState);
                retval.artifactState.putAll(this.artifactState);
                // Update move
                retval.artifactState.put(artifact, newTiles);
                for (final Tile tile : currentTiles) {
                    retval.tileState.put(tile, Tile.EMPTY);
                }
                for (final Tile tile : newTiles) {
                    retval.tileState.put(tile, artifact.getId());
                }
                return retval;
            }
            return null;
        }

        /**
         * We have to make sure to allow an artifact to move into a position
         * that it already occupies.
         *
         * @param tiles
         * @param exceptedId
         * @return
         */
        private boolean occupied(final Collection<Tile> tiles,
                final String exceptedId) {
            for (final Tile tile : tiles) {
                final String state = tileState.get(tile);
                if (!state.equals(Tile.EMPTY) && !state.equals(Tile.PLATE)
                        && !state.equals(exceptedId)) {
                    return true;
                }
            }
            return false;
        }

        private Collection<Tile> determineNewTilesForArtifact(
                final Collection<Tile> currentTiles, final Direction direction) {
            final Collection<Tile> retval = new ArrayList<Tile>();

            for (final Tile tile : currentTiles) {
                final String newTileId = tile.generateTileId(direction);
                final Tile newTile = tilesById.get(newTileId);
                if (newTile == null) {
                    // If any tile does not exist then the artifact is already
                    // on the edge of the room.
                    return new ArrayList<Tile>();
                }
                retval.add(newTile);
            }

            return retval;
        }

        public Collection<Movement> determineArtifactMoves() {
            final Collection<Movement> moves = new ArrayList<Movement>();
            for (final Artifact artifact : artifactsById.values()) {
                final Collection<Movement> singleArtMoves = artifact
                        .possibleMoves();
                moves.addAll(singleArtMoves);
            }

            return moves;
        }

        public void initializeArtifactToTile(final String artifactId,
                final Tile tile) {
            Artifact artifact = null;
            if (artifactsById.containsKey(artifactId)) {
                artifact = artifactsById.get(artifactId);
                final Collection<Tile> tiles = artifactState.get(artifact);
                tiles.add(tile);
            } else {
                artifact = new Artifact(artifactId);
                artifactsById.put(artifactId, artifact);
                final ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(tile);
                artifactState.put(artifact, tiles);
            }
        }

        public static void setPlate(final Tile tile) {
            plate = tile;
        }

        public static void setToStringLineBreak(final int expectedColumns) {
            toStringLineBreak = expectedColumns;
        }

        @Override
        public String toString() {
            final StringBuilder retval = new StringBuilder();
            final StringBuilder line = new StringBuilder();
            for (final String id : tileState.values()) {
                line.append(id);
                if (line.length() % toStringLineBreak == 0) {
                    retval.append(line.toString());
                    retval.append("\n");
                    line.setLength(0);
                }
            }
            return retval.toString();
        }

        public boolean isPlateCovered() {
            final String status = tileState.get(plate);
            return (!status.equals(Tile.EMPTY) && !status.equals(Tile.PLATE));
        }
    }

    private static class Tile implements Comparable<Tile> {

        public static final String PLATE = "X";
        public static final String EMPTY = ".";

        private final int rowId;
        private final int columnId;

        public Tile(final int _rowId, final int _columnId) {
            rowId = _rowId;
            columnId = _columnId;
        }

        public String generateTileId(final Direction direction) {
            final int[] point = direction.move(rowId, columnId);
            return generateId(point[0], point[1]);
        }

        private static String generateId(final int row, final int column) {
            return row + "." + column;
        }

        public String getId() {
            return generateId(rowId, columnId);
        }

        @Override
        public String toString() {
            return getId();
        }

        @Override
        public int compareTo(final Tile that) {
            if (this.rowId != that.rowId) {
                return Integer.compare(this.rowId,
                        that.rowId);
            }
            return Integer.compare(this.columnId, that.columnId);
        }
    }

    private static class Solution {

        private static int searchDepth;
        private final Stack<Room> rooms = new Stack<Room>();
        private final Moves moves;

        public Solution(final Room initialRoom, final Moves initialMoves) {
            rooms.push(initialRoom);
            moves = initialMoves;
        }

        /**
         * <pre>
         *   A. if exit criteria then print
         *   B. else if moves = max depth then return.
         *   C. else search for all possible moves.
         *    a. push move
         *    b. call recursive
         *    c. pop move
         * Done
         */
        public Solution solve() {
            final Room room = rooms.peek();
            final Collection<Movement> potentialMoves = room
                    .determineArtifactMoves();
            for (final Movement move : potentialMoves) {
                final Room shiftedRoom = room.move(move);
                if (shiftedRoom != null) {
                    push(shiftedRoom, move);
                    if (moves.size() < searchDepth) {
                        solve();
                    }
                    if (exitCriteriaMet()) {
                        return this;
                    }
                    pop();
                }
            }

            return this;
        }

        private boolean exitCriteriaMet() {
            return moves.size() == searchDepth && rooms.peek().isPlateCovered();
        }

        private void pop() {
            moves.pop();
            rooms.pop();
        }

        private void push(final Room shiftedRoom, final Movement move) {
            rooms.push(shiftedRoom);
            moves.push(move);
        }

        @Override
        public String toString() {
            final StringBuilder retval = new StringBuilder();
            retval.append(moves);
            retval.append("\n");
            retval.append(rooms.peek());

            return retval.toString();
        }

        public static void setExactDepth(final int exactDepth) {
            searchDepth = exactDepth;
        }
    }

    private class Moves {

        private final Stack<Movement> currentMoves = new Stack<Movement>();

        @Override
        public String toString() {
            final StringBuilder retval = new StringBuilder();
            for (final Movement move : currentMoves) {
                retval.append(move);
                retval.append(" ");
            }
            retval.append("\n");
            return retval.toString();
        }

        public void pop() {
            currentMoves.pop();
        }

        public void push(final Movement move) {
            currentMoves.push(move);
        }

        public int size() {
            return currentMoves.size();
        }
    }

    private static class Movement {

        private final Direction direction;
        private final Artifact artifact;

        public Movement(final Artifact art, final Direction dir) {
            artifact = art;
            direction = dir;
        }

        public Artifact getArtifact() {
            return artifact;
        }

        public Direction getDirection() {
            return direction;
        }

        @Override
        public String toString() {
            final StringBuilder retval = new StringBuilder();
            retval.append(artifact.getId());
            retval.append(direction);
            return retval.toString();
        }
    }

    private enum Direction {
        U {
            @Override
            public int[] move(final int row, final int column) {
                return new int[]{row - 1, column};
            }
        },
        D {
            @Override
            public int[] move(final int row, final int column) {
                return new int[]{row + 1, column};
            }
        },
        L {
            @Override
            public int[] move(final int row, final int column) {
                return new int[]{row, column - 1};
            }
        },
        R {
            @Override
            public int[] move(final int row, final int column) {
                return new int[]{row, column + 1};
            }
        };

        public abstract int[] move(final int row, int column);
    }

    /**
     * Parse an array of strings into components specific to this problem.
     *
     */
    private class InputParser {

        private final int exactDepth;
        private final int expectedRows;
        private final int expectedColumns;
        private final Room room;

        /**
         * Calculate indexes for each of the sections.
         *
         * @param input An array of strings from the input.
         */
        public InputParser(final List<String> input) {
            final int roomDimensionIndex = 0;
            final int roomStartIndex = 1;

            final String[] dimElements = parseRoomDimensions(input
                    .get(roomDimensionIndex));
            expectedRows = Integer.parseInt(dimElements[0]);
            expectedColumns = Integer.parseInt(dimElements[1]);
            exactDepth = Integer.parseInt(dimElements[2]);

            if ((input.size() - roomStartIndex) != expectedRows) {
                throw new IllegalStateException(
                        "Error: Input data rows does not match room dimenstions.  Expected "
                        + expectedRows + " but found "
                        + (input.size() - roomStartIndex)
                        + " rows in the input.");
            }

            final int roomEndIndex = roomStartIndex + expectedRows;
            final List<String> roomData = input.subList(roomStartIndex,
                    roomEndIndex);
            room = parseRoomData(roomData);
        }

        /**
         * Parse the input strings section for the room dimensions and solution
         * size.
         *
         * @param dimString A space separated string consisting of 2 dimensions
         * followed by the number of moves in the solution
         */
        private String[] parseRoomDimensions(final String dimString) {
            final int ELEMENTCOUNT = 3;
            final String[] dimElements = dimString.split("[ ]+");
            if (dimElements.length != ELEMENTCOUNT) {
                throw new IllegalStateException(
                        "Error: Unexpected number of elements: Expected "
                        + ELEMENTCOUNT + " but found " + dimString.length()
                        + " in " + dimString + ".");
            }
            return dimElements;
        }

        private Room parseRoomData(final List<String> roomData) {
            Room.setToStringLineBreak(expectedColumns);
            Solution.setExactDepth(exactDepth);

            final Room room = new Room();

            for (int rowCount = 0; rowCount < roomData.size(); rowCount++) {
                final String row = roomData.get(rowCount);
                if (row.length() != expectedColumns) {
                    throw new IllegalStateException(
                            "Error: Expected " + expectedColumns
                            + " columns but found " + row.length()
                            + " while parsing row #" + rowCount + " :"
                            + row + ".");
                }
                for (int columnCount = 0; columnCount < expectedColumns; columnCount++) {
                    final String artifactId = Character.toString(row
                            .charAt(columnCount));
                    final Tile newTile = new Tile(rowCount, columnCount);
                    room.addTile(newTile, artifactId);

                    if (!artifactId.equals(Tile.PLATE)
                            && !artifactId.equals(Tile.EMPTY)) {
                        room.initializeArtifactToTile(artifactId, newTile);
                    } else if (artifactId.equals(Tile.PLATE)) {
                        Room.setPlate(newTile);
                    }
                }
            }
            return room;
        }

        public Room getRoom() {
            return room;
        }
    }

    /**
     * Parse input from file or stdin into an array of strings.
     *
     * I use this class to handle input for most of my CodeWar problems.
     */
    private static class InputHandler {

        /**
         * Include a helper method for a common task often needed by users of
         * this class.
         *
         * @param args
         * @return The string following the input option (-i).
         */
        public static String extractFilenameByOption(final String args[]) {
            final String fileOption = "-f";
            String retval = "";
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase(fileOption)) {
                    if (args.length >= 2) {
                        // This handles directories with spaces.
                        for (int i = 1; i < args.length; i++) {
                            retval += args[i] + " ";
                        }
                        retval.trim();
                    }
                }
            }

            return retval;
        }

        /**
         * A file can be used for input if it is set.
         */
        File myInputFile = null;

        /**
         * Construct an InputHandler using stdin.
         */
        public InputHandler() {
            // Use the defaults.
        }

        /**
         * Construct an InputHandler using the given filename.
         *
         * @param filename
         */
        public InputHandler(final String filename) {
            setInputFile(filename);
        }

        /**
         * Read the input into memory.
         *
         * @return An unmodifiable <code>List</code> of input lines.
         * @throws Exception For any issue.
         */
        public List<String> readInput() throws Exception {
            final List<String> retval = new ArrayList<String>();

            final InputStream inputStream = getInputStream();
            final BufferedReader in = new BufferedReader(new InputStreamReader(
                    inputStream));
            if (in != null) {
                if (in.ready()) {
                    for (String line = in.readLine(); line != null; line = in
                            .readLine()) {
                        retval.add(line);
                    }
                }
                in.close();
            } else {
                throw new IllegalStateException("Error: no reader");
            }

            return Collections.unmodifiableList(retval);
        }

        /**
         * Use a file for input instead of stdin.
         *
         * @param filename
         * @throws FileNotFoundException
         */
        private void setInputFile(final String filename) {
            if ((filename != null) && (filename.length() > 0)) {
                final File inputFile = new File(filename);
                if (inputFile.exists()) {
                    myInputFile = inputFile;
                }
            }
        }

        /**
         * Create an input stream. If we have a filename then use it, otherwise
         * use stdin.
         *
         * @return
         * @throws FileNotFoundException
         */
        private InputStream getInputStream() throws FileNotFoundException {
            InputStream inputStream = System.in;

            if (myInputFile != null) {
                inputStream = new FileInputStream(myInputFile);
            }

            return inputStream;
        }
    }
}
