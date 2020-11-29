
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Houston Skyline
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt")); // Used to save some time
        int start = scan.nextInt();
        int[] skyline = new int[50 + 1 + 1];// 50 char width, with padding of 1
        while (start != 0) {
            int w = scan.nextInt(); // Width
            int h = scan.nextInt(); // Height
            // define the silhouette of each building
            for (int x = start; x < (start + w + 2); x++) {
                if (skyline[x] < h + 1) {
                    skyline[x] = h + 1;
                }
            }
            start = scan.nextInt();
        }
        // print out the silhouette using the building's max height as a guide
        for (int y = 20; y >= 0; y--) {
            for (int x = 1; x <= 50; x++) {
                if (skyline[x] < y) {
                    System.out.print(' ');  // sky
                }

                if (skyline[x] == y) {
                    // check for outside corners
                    if ((skyline[x - 1] < y) || (skyline[x + 1] < y)) {
                        System.out.print('+');
                    } else {
                        System.out.print('-');	// roofline
                    }
                }

                if (skyline[x] > y) {
                    if (((skyline[x - 1] < y) && (skyline[x + 1] > y))
                            || ((skyline[x - 1] > y) && (skyline[x + 1] < y))) {
                        System.out.print('|');	// wall
                    } else if ((skyline[x - 1] == y) || (skyline[x + 1] == y)) {
                        System.out.print('+');  // inside corner
                    } else {
                        System.out.print(' '); // interior
                    }
                }
            }
            System.out.print('\n');
        }
        // horizontal index
        for (int i = 1; i <= 50; i++) {
            System.out.print(Integer.toString(i % 10).charAt(0));
        }
        System.out.println();
    }
}
