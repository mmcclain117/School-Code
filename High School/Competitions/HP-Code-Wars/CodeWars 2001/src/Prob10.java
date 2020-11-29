
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static char grid[][];
    public static boolean visit[][];

    public static void main(String[] args) throws Exception {
//        Problem: Mars Rover
//        Points: 10
        Scanner scan = new Scanner(new File("prob10.txt"));
        int size = scan.nextInt(); // Grid Size
        String orin = scan.next(); // Orientation
        scan.nextLine();
        int direct = 0; // Direction Facing
        if (orin.equals("NORTH")) { // Up
            direct = 0;
        } else if (orin.equals("EAST")) {// Right
            direct = 1;
        } else if (orin.equals("SOUTH")) { // Down
            direct = 2;
        } else if (orin.equals("WEST")) { // Left
            direct = 3;
        }
        int sx = -1; // Starting X
        int sy = -1; // Starting Y
        grid = new char[size][size];
        visit = new boolean[size][size]; // Array of places visited
        /* Scanning in the array */
        for (int i = 0; i < grid.length; i++) {
            String t = scan.nextLine().replaceAll(" ", "");
            grid[i] = t.toCharArray();
            if (t.contains("A")) {
                sy = i;
                sx = t.indexOf("A");
            }
        }
        visit[sy][sx] = true;
        /* Go through the commands until stop */
        while (scan.hasNext()) {
            String s = scan.nextLine().trim(); // Command
            System.out.print(s + ": ");
            if (s.contains("MOVE")) {
                String messages = ""; // For outputs
                boolean moved = true;
                try {
                    int tmp = Integer.parseInt(s.split("[ ]+")[1]); // Distance to move
                    OUTER:
                    for (int i = 0; i < tmp; i++) {

                        if (direct == 0) { // Up
                            visit[sy - 1][sx] = true;
                            switch (grid[sy - 1][sx]) {
                                case 'o': // Found Ore
                                    messages += "ORE DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                case '*': // Ran into obstacle
                                    System.out.println("FAILURE DUE TO OBSTACLE AT POSITION " + (i + 1));
                                    moved = false;
                                    break OUTER;
                                case '#': // Found Crystal
                                    messages += "CRYSTAL DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                default:
                                    break;
                            }
                            sy--;
                        } else if (direct == 1) { // Right
                            visit[sy][sx + 1] = true;
                            switch (grid[sy][sx + 1]) {
                                case 'o': // Found Ore
                                    messages += "ORE DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                case '*': // Ran into obstacle
                                    System.out.println("FAILURE DUE TO OBSTACLE AT POSITION " + (i + 1));
                                    moved = false;
                                    break OUTER;
                                case '#': // Found Crystal
                                    messages += "CRYSTAL DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                default:
                                    break;
                            }
                            sx++;
                        } else if (direct == 2) { // Down
                            visit[sy + 1][sx] = true;
                            switch (grid[sy + 1][sx]) {
                                case 'o': // Found Ore
                                    messages += "ORE DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                case '*': // Ran into obstacle
                                    System.out.println("FAILURE DUE TO OBSTACLE AT POSITION " + (i + 1));
                                    moved = false;
                                    break OUTER;
                                case '#': // Found Crystal
                                    messages += "CRYSTAL DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                default:
                                    break;
                            }
                            sy++;
                        } else if (direct == 3) { // Left
                            visit[sy][sx - 1] = true;
                            switch (grid[sy][sx - 1]) {
                                case 'o': // Found Ore
                                    messages += "ORE DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                case '*': // Ran into obstacle
                                    System.out.println("FAILURE DUE TO OBSTACLE AT POSITION " + (i + 1));
                                    moved = false;
                                    break OUTER;
                                case '#': // Found Crystal
                                    messages += "CRYSTAL DISCOVERED AT POSITION " + (i + 1) + "\n";
                                    break;
                                default:
                                    break;
                            }
                            sx--;
                        }
                    }
                    if (moved) {
                        System.out.println("SUCCESS.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("FAILURE DUE TO OUT OF BOUNDS OF THE ARRAY");
//                    System.out.println("This is the reason we have try-catch statements");
                }
                System.out.print(messages);
            } else if (s.equals("STOP")) {
                System.out.println("STOPPED.");
                break;
            } else if (s.equals("RIGHT")) {
                direct++;
                direct %= 4;
                System.out.println("COMPLETE.");
            } else if (s.equals("LEFT")) {
                direct--;
                direct = Math.abs(direct);
                System.out.println("COMPLETE.");
            }
        }
        grid[sy][sx] = 'P'; // Set the ending point before printing
        /* Print out the array */
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (visit[x][y]) {
                    System.out.print(grid[x][y]);
                } else {
                    System.out.print("?");
                }
            }
            System.out.println();
        }
    }
}
