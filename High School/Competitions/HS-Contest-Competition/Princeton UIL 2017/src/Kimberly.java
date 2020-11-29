
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Kyle Fromm
 */
public class Kimberly {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("kimberley.dat"));
        while (scan.hasNext()) {
            int aa = scan.nextInt();
            int[] birds = new int[aa];
//            scan.nextLine();
            int bb = scan.nextInt();
            for (int i = 0; i < bb; i++) {
                birds[scan.nextInt() - 1] = 1;
            }

            int pp = scan.nextInt();
            for (int y = 0; y > pp; y++) {
                if (birds[0] == 0 && birds[birds.length - 1] == 1) {
                    birds[0] = 2;
                    birds[birds.length - 1] = 0;
                }
//            }
                for (int d = 0; d < birds.length - 1; d++) {
                    if (birds[d] == 1 && birds[d + 1] == 0 && birds[d] != 2) {
                        birds[d + 1] = 2;
                        birds[d] = 0;
                    }
                }
//            System.out.println(Arrays.toString(birds));

                for (int d = 0; d < birds.length; d++) {
                    if (birds[d] == 2) {
                        birds[d] = 1;
                    }
                }
            }
//            System.out.println(Arrays.toString(birds));
            for (int f = 0; f < birds.length; f++) {
                if (birds[f] == 1) {
                    System.out.print(f + " ");
                }
            }
            System.out.print("\n");
        }
    }
}
