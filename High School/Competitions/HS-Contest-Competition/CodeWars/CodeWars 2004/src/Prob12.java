
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* There is a typo in the answers. Right now printing what is in front of the vehicle.  */
public class Prob12 {

    public static char grid[][];
    public static char mat[][];

    public static void main(String[] args) throws Exception {
//        Problem: Mars Rover
//        Points: 12
        Scanner scan = new Scanner(new File("prob12.txt"));
        int size = scan.nextInt(); // Grid Size
        scan.nextLine();
        int direct = 0; // Direction Facing
        int sx = -1; // Starting X
        int sy = -1; // Starting Y
        grid = new char[size][size];
        mat = new char[size][size]; // Grid of all the materials
        /* Scanning in the array */
        for (int i = 0; i < grid.length; i++) {
            String t = scan.nextLine().replaceAll(" ", "");
            grid[i] = t.toCharArray();
            if (t.contains("^")) {
                sy = i;
                sx = t.indexOf("^");
                direct = 0;
            } else if (t.contains(">")) {
                sy = i;
                sx = t.indexOf(">");
                direct = 1;
            } else if (t.contains("V")) {
                sy = i;
                sx = t.indexOf("V");
                direct = 2;
            } else if (t.contains("<")) {
                sy = i;
                sx = t.indexOf("<");
                direct = 3;
            }
        }
        /* Read in the mineral array */
        for (int i = 0; i < grid.length; i++) {
            String t = scan.nextLine().replaceAll(" ", "");
            mat[i] = t.toCharArray();
//            System.out.println(t.toCharArray());
        }
//        System.out.println();

        /* Go through the commands until stop */
        while (scan.hasNext()) {
            String s = scan.nextLine().trim(); // Command
            if (s.contains("MOVE")) {
                try {
                    int tmp = Integer.parseInt(s.split("[ ]+")[1]); // Distance to move
                    OUTER:
                    for (int i = 0; i <= tmp; i++) {
                        if (direct == 0) { // Up
                            switch (grid[sy - 1][sx]) {
                                case 'X': // Obstruction
                                    break OUTER;
                                case 'O': // Ran into Crater
                                    break OUTER;
                                default:
                                    break;
                            }
                            sy--;
                        } else if (direct == 1) { // Right
                            switch (grid[sy][sx + 1]) {
                                case 'X': // Obstruction
                                    break OUTER;
                                case 'O': // Ran into Crater
                                    break OUTER;
                                default:
                                    break;
                            }
                            sx++;
                        } else if (direct == 2) { // Down
                            switch (grid[sy + 1][sx]) {
                                case 'X': // Obstruction
                                    break OUTER;
                                case 'O': // Ran into Crater
                                    break OUTER;
                                default:
                                    break;
                            }
                            sy++;
                        } else if (direct == 3) { // Left
                            switch (grid[sy][sx - 1]) {
                                case 'X': // Obstruction
                                    break OUTER;
                                case 'O': // Ran into Crater
                                    break OUTER;
                                default:
                                    break;
                            }
                            sx--;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("FAILURE DUE TO OUT OF BOUNDS OF THE ARRAY");
//                    System.out.println("This is the reason we have try-catch statements");
                }
            } else if (s.equals("END")) {
                break;
            } else if (s.equals("RIGHT")) {
                direct++;
                direct %= 4;
            } else if (s.equals("LEFT")) {
                direct--;
                direct = direct < 0 ? 4 + direct : direct;
//                direct = Math.abs(direct);
            } else if (s.equals("DRILL")) {
                char material = ' '; // Material Going to be drilling
//                System.out.println(sy + " " + sx + " " + grid[sy][sx] + " " + mat[sy][sx] + " " + mat[sy - 1][sx - 1]);
                if (direct == 0) { // Up
                    material = mat[sy - 1][sx];
                } else if (direct == 1) { // Right
                    material = mat[sy][sx + 1];
                } else if (direct == 2) { // Down
                    material = mat[sy + 1][sx];
                } else if (direct == 3) { // Left
                    material = mat[sy][sx - 1];
                } else {
                    System.out.println(direct);
                }
                switch (material) {
                    case 'H':
                        System.out.println("HEMATITE");
                        break;
                    case 'Q':
                        System.out.println("QUARTZ");
                        break;
                    case 'F':
                        System.out.println("FELDSPAR");
                        break;
                    case 'A':
                        System.out.println("ANATASE");
                        break;
                }
            }
        }

//        /* Print out the array */
//        for (int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                System.out.print(grid[x][y]);
//            }
//            System.out.println();
//        }
    }
}
