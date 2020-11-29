
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Master Ward and Sebastian Schagerer
 */
public class Prob19 {

    private int numShips[] = new int[5];
    private int gridSize;
    private char[][] shipGrid;
    private List<Ship> ships;

    public static void main(String[] args) throws Exception {
//        Problem: Battleship
//        Points: 15
        new Prob19();
    }

    public Prob19() throws Exception {
        Scanner scan = new Scanner(new File("prob19a.txt"));
        gridSize = scan.nextInt();
        scan.nextLine();
        shipGrid = new char[gridSize][gridSize];
        for (int row = 0; row < gridSize; row++) {
            String line = scan.nextLine();
            shipGrid[row] = line.toCharArray();
        }
        //printShipGrid();
        ships = new ArrayList<>();
        findShips();
//        printShipGrid();
        removeSubsumedShips();
        verifyShipNumbers();

        int numTouching = noTouching();
        System.out.println(numTouching + " Ships are touching.");
    }

    /* Looks for the top left corner of a ship in each location */
    private void findShips() {
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                if (shipGrid[r][c] == 'X' && !isPartOfShip(new Point(c, r))) {
                    Point topOfShip = new Point(c, r);
                    checkAllShipTypes(topOfShip);
                }
            }
        }
    }

    /* Return if a point is part of a ship */
    private boolean isPartOfShip(Point location) {
        for (Ship s : ships) {
            if (s.partOfShip(location)) {
                return true;
            }
        }
        return false;
    }

    private void checkAllShipTypes(Point topOfShip) {
        // Iterate over all ship types
        for (int type = 0; type < 5; type++) {
            // Iterate over all orientations of this type
            List<List<Point>> offsets = getShipOffsets(type);
            for (List<Point> offset : offsets) {
                if (isShip(topOfShip, offset)) {
                    Ship aShip = new Ship(type, topOfShip, offset);
                    ships.add(aShip);
                    break;
                }
            }
        }
    }

    private void removeSubsumedShips() {
        List<Ship> allShips = new ArrayList<>();
        allShips.addAll(ships);
        for (Ship aShip : allShips) {
            for (Ship bShip : allShips) {
                if (aShip.type != bShip.type && true == aShip.contains(bShip)) {
                    ships.remove(bShip);
                }
            }
        }
    }

    private void verifyShipNumbers() {
        for (int shipType = 0; shipType < 5; shipType++) {
            numShips[shipType] = 0;
            for (Ship aShip : ships) {
                if (aShip.type == shipType) {
                    numShips[shipType]++;
                }
            }
        }
        for (int s = 0; s < 5; s++) {
            System.out.println(numShips[s] + " " + Ship.typeToString(s));
        }
    }

    /* Return number of ships not touching */
    private int noTouching() {
        int shipsTouching = 0;
        for (Ship aShip : ships) {
            if (isShipTouching(aShip)) {
                shipsTouching++;
            }
        }
        return shipsTouching;
    }

    /* Check if a ship a is touching another ship */
    private boolean isShipTouching(Ship aShip) {
        Point topOfShip = aShip.topCoordinate;
        List<Point> offsets = aShip.offsets;
        if (isShipPieceTouching(aShip, topOfShip)) {
            return true;
        }
        for (Point offset : offsets) {
            Point current = new Point(topOfShip);
            current.x += offset.x;
            current.y += offset.y;
            if (isShipPieceTouching(aShip, current)) {
                return true;
            }

        }
        return false;
    }

    /* Test if ship a is touching a location */
    private boolean isShipPieceTouching(Ship aShip, Point location) {
        List<Point> pieceOffsets = Ship.pieceOffset();
        for (Point pOffset : pieceOffsets) {
            Point current = new Point(location);
            current.x += pOffset.x;
            current.y += pOffset.y;
            if (isInBounds(current) && shipGrid[current.y][current.x] != '-' && !aShip.partOfShip(current)) {
                return true;
            }
        }
        return false;
    }

    /* Marks on grid a ship is hit */
    private void markShip(Ship aShip) {
        Point topOfShip = aShip.topCoordinate;
        int type = aShip.type;
        List<Point> offsets = aShip.offsets;
        // Mark top left of ship
        shipGrid[topOfShip.y][topOfShip.x] = Ship.typeToChar(type);
        // Mark rest of the ship
        for (Point offset : offsets) {
            Point current = new Point(topOfShip);
            current.x += offset.x;
            current.y += offset.y;
            shipGrid[current.y][current.x] = Ship.typeToChar(type);
        }
    }

    private boolean isShip(Point topOfShip, List<Point> offsets) {
        boolean isShip = true;
        for (Point offset : offsets) {
            Point current = new Point(topOfShip);
            current.x += offset.x;
            current.y += offset.y;
            isShip = (isShip && isShipPiece(current));
        }
        return isShip;

    }

    private List<List<Point>> getShipOffsets(int type) {
        List<List<Point>> offsets = new ArrayList<>();
        if (type == Ship.DESTROYER) {
            offsets.add(Ship.dOffset());
            offsets.add(Ship.d1Offset());
            offsets.add(Ship.d2Offset());
            offsets.add(Ship.d3Offset());
        } else if (type == Ship.FRIGATE) {
            offsets.add(Ship.fOffset());
            offsets.add(Ship.f1Offset());
        } else if (type == Ship.CARRIER) {
            offsets.add(Ship.cOffset());
            offsets.add(Ship.c1Offset());
        } else if (type == Ship.GUNBOAT) {
            offsets.add(Ship.gOffset());
            offsets.add(Ship.g1Offset());
        } else if (type == Ship.BATTLESIHP) {
            offsets.add(Ship.t1Offset());
            offsets.add(Ship.tOffset());
        }
        return offsets;
    }

    private boolean isShipPiece(Point aPoint) {
        if (isInBounds(aPoint)) {
            return 'X' == shipGrid[aPoint.y][aPoint.x];
        }
        return false;
    }

    /* Checks if point is in the grid */
    private boolean isInBounds(Point aPoint) {
        return (aPoint.x >= 0 && aPoint.x < gridSize && aPoint.y >= 0 && aPoint.y < gridSize);
    }

    /* Prints the grid */
    private void printShipGrid() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                System.out.print(shipGrid[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

class Ship {

    public static final int BATTLESIHP = 0;
    public static final int CARRIER = 1;
    public static final int DESTROYER = 2;
    public static final int FRIGATE = 3;
    public static final int GUNBOAT = 4;

    public int type = 0;
    public Point topCoordinate = null;
    public List<Point> offsets = null;

    private static List<Point> dOffset;
    private static List<Point> d1Offset;
    private static List<Point> d2Offset;
    private static List<Point> d3Offset;
    private static List<Point> fOffset;
    private static List<Point> f1Offset;
    private static List<Point> cOffset;
    private static List<Point> c1Offset;
    private static List<Point> gOffset;
    private static List<Point> g1Offset;
    private static List<Point> tOffset;
    private static List<Point> t1Offset;
    private static List<Point> pieceOffset;
    private static List<List<Point>> shipOffsets;

    public Ship(int type, Point topCoordinate, List<Point> offsets) {
        this.type = type;
        this.topCoordinate = new Point(topCoordinate);
        this.offsets = offsets;
    }

    @Override
    public String toString() {
        return "[" + typeToString(type) + "," + topCoordinate.toString() + "]";
    }

    public boolean partOfShip(Point location) {
        boolean isPart = false;
        for (Point offset : offsets) {
            Point current = new Point(topCoordinate);
            current.x += offset.x;
            current.y += offset.y;
            if (location.equals(current)) {
                isPart = true;
                break;
            }
        }
        if (topCoordinate.equals(location)) {
            isPart = true;
        }

        // System.out.println("is " + location.toString() + " part of " +
        // this.topCoordinate.toString() + ":" + isPart);
        return isPart;
    }

    public static List<List<Point>> getShipOffsets() {
        if (shipOffsets == null) {
            shipOffsets = new ArrayList<>();
            shipOffsets.add(cOffset);
            shipOffsets.add(dOffset);
            shipOffsets.add(fOffset);
            shipOffsets.add(gOffset);
            shipOffsets.add(g1Offset);
            shipOffsets.add(tOffset);
        }
        return shipOffsets;
    }

    private List<Point> getShipOffsets(int type) {
        switch (type) {
            case DESTROYER:
                return Ship.dOffset();
            case FRIGATE:
                return Ship.fOffset();
            case CARRIER:
                return Ship.cOffset();
            case GUNBOAT:
                return Ship.gOffset();
            case BATTLESIHP:
                return Ship.tOffset();
            default:
                return null;
        }
    }

    public boolean contains(Ship otherShip) {
        List<Point> otherShipOffsets = otherShip.offsets;
        Point otherShipTop = otherShip.topCoordinate;
        for (Point otherShipOffset : otherShipOffsets) {
            Point current = new Point(otherShipTop);
            current.x += otherShipOffset.x;
            current.y += otherShipOffset.y;
            if (!partOfShip(current)) {
                return false;
            }
        }
        return true;
    }

    public static char typeToChar(int type) {
        switch (type) {
            case DESTROYER:
                return 'D';
            case FRIGATE:
                return 'F';
            case CARRIER:
                return 'C';
            case GUNBOAT:
                return 'G';
            case BATTLESIHP:
                return 'B';
            default:
                return 'O';
        }
    }

    public static String typeToString(int type) {
        switch (type) {
            case DESTROYER:
                return "Destroyer";
            case FRIGATE:
                return "Frigate";
            case CARRIER:
                return "Carrier";
            case GUNBOAT:
                return "Gunner";
            case BATTLESIHP:
                return "Battleship";
            default:
                return null;
        }
    }

    public static List<Point> dOffset() {
        if (dOffset == null) {
            dOffset = new ArrayList<>();
            dOffset.add(new Point(0, 1));
            dOffset.add(new Point(0, 2));
            dOffset.add(new Point(0, 3));
            dOffset.add(new Point(-1, 2));
            dOffset.add(new Point(-1, 3));
            dOffset.add(new Point(1, 2));
            dOffset.add(new Point(1, 3));
        }
        return dOffset;
    }

    public static List<Point> d1Offset() {
        if (d1Offset == null) {
            d1Offset = new ArrayList<>();
            d1Offset.add(new Point(1, 0));
            d1Offset.add(new Point(0, 1));
            d1Offset.add(new Point(1, 1));
            d1Offset.add(new Point(2, 1));
            d1Offset.add(new Point(3, 1));
            d1Offset.add(new Point(0, 2));
            d1Offset.add(new Point(1, 2));
        }
        return d1Offset;
    }

    public static List<Point> d2Offset() {
        if (d2Offset == null) {
            d2Offset = new ArrayList<>();
            d2Offset.add(new Point(1, 0));
            d2Offset.add(new Point(2, 0));
            d2Offset.add(new Point(0, 1));
            d2Offset.add(new Point(1, 1));
            d2Offset.add(new Point(2, 1));
            d2Offset.add(new Point(1, 2));
            d2Offset.add(new Point(1, 3));
        }
        return d2Offset;
    }

    public static List<Point> d3Offset() {
        if (d3Offset == null) {
            d3Offset = new ArrayList<>();
            d3Offset.add(new Point(1, 0));
            d3Offset.add(new Point(-2, 1));
            d3Offset.add(new Point(-1, 1));
            d3Offset.add(new Point(0, 1));
            d3Offset.add(new Point(1, 1));
            d3Offset.add(new Point(0, 2));
            d3Offset.add(new Point(1, 2));
        }
        return d3Offset;
    }

    public static List<Point> fOffset() {
        if (fOffset == null) {
            fOffset = new ArrayList<>();
            fOffset.add(new Point(0, 1));
            fOffset.add(new Point(0, 2));
            fOffset.add(new Point(0, 3));
            fOffset.add(new Point(-1, 1));
            fOffset.add(new Point(-1, 2));
            fOffset.add(new Point(1, 1));
            fOffset.add(new Point(1, 2));
        }
        return fOffset;
    }

    public static List<Point> f1Offset() {
        if (f1Offset == null) {
            f1Offset = new ArrayList<>();
            f1Offset.add(new Point(1, 0));
            f1Offset.add(new Point(-1, 1));
            f1Offset.add(new Point(0, 1));
            f1Offset.add(new Point(1, 1));
            f1Offset.add(new Point(2, 1));
            f1Offset.add(new Point(0, 2));
            f1Offset.add(new Point(1, 2));
        }
        return f1Offset;
    }

    public static List<Point> cOffset() {
        if (cOffset == null) {
            cOffset = new ArrayList<>();
            cOffset.add(new Point(0, 1));
            cOffset.add(new Point(-1, 1));
            cOffset.add(new Point(-1, 2));
            cOffset.add(new Point(-2, 2));
            cOffset.add(new Point(-2, 3));
        }
        return cOffset;
    }

    public static List<Point> c1Offset() {
        if (c1Offset == null) {
            c1Offset = new ArrayList<>();
            c1Offset.add(new Point(1, 0));
            c1Offset.add(new Point(1, 1));
            c1Offset.add(new Point(2, 1));
            c1Offset.add(new Point(2, 2));
            c1Offset.add(new Point(3, 2));
        }
        return c1Offset;
    }

    public static List<Point> gOffset() {
        if (gOffset == null) {
            gOffset = new ArrayList<>();
            gOffset.add(new Point(1, 0));
            gOffset.add(new Point(0, 1));
            gOffset.add(new Point(1, 1));
            gOffset.add(new Point(0, 2));
            gOffset.add(new Point(1, 2));
            gOffset.add(new Point(0, 3));
            gOffset.add(new Point(1, 3));
        }
        return gOffset;
    }

    public static List<Point> g1Offset() {
        if (g1Offset == null) {
            g1Offset = new ArrayList<>();
            g1Offset.add(new Point(1, 0));
            g1Offset.add(new Point(2, 0));
            g1Offset.add(new Point(3, 0));
            g1Offset.add(new Point(0, 1));
            g1Offset.add(new Point(1, 1));
            g1Offset.add(new Point(2, 1));
            g1Offset.add(new Point(3, 1));
        }
        return g1Offset;
    }

    public static List<Point> tOffset() {
        if (tOffset == null) {
            tOffset = new ArrayList<>();
            tOffset.add(new Point(0, 1));
            tOffset.add(new Point(0, 2));
            tOffset.add(new Point(0, 3));
        }
        return tOffset;
    }

    public static List<Point> t1Offset() {
        if (t1Offset == null) {
            t1Offset = new ArrayList<>();
            t1Offset.add(new Point(1, 0));
            t1Offset.add(new Point(2, 0));
            t1Offset.add(new Point(3, 0));
        }
        return t1Offset;
    }

    public static List<Point> pieceOffset() {
        if (pieceOffset == null) {
            pieceOffset = new ArrayList<>();
            pieceOffset.add(new Point(-1, -1));
            pieceOffset.add(new Point(0, -1));
            pieceOffset.add(new Point(1, -1));
            pieceOffset.add(new Point(-1, 0));
            pieceOffset.add(new Point(1, 0));
            pieceOffset.add(new Point(-1, 1));
            pieceOffset.add(new Point(0, 1));
            pieceOffset.add(new Point(1, 1));
        }

        return pieceOffset;
    }
}
