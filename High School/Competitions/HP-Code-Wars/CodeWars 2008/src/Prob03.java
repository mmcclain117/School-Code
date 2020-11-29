
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Checkerboard
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            boolean flip = false;
            for (int i = 1; i < (8 * a + 1); i++) { // Number of rows
                for (int ii = 0; ii < 4; ii++) { // Number of columns
                    if (flip) {
                        for (int x = 0; x < a; x++) {
                            System.out.print(".");
                        }
                        for (int y = 0; y < a; y++) {
                            System.out.print("#");
                        }
                    } else {
                        for (int x = 0; x < a; x++) {
                            System.out.print("#");
                        }
                        for (int y = 0; y < a; y++) {
                            System.out.print(".");
                        }
                    }
                }
//                    System.out.println();
//                    flip = !flip;
                flip = i % a + 1 == 1 ? !flip : flip;
//                }
                System.out.println();
            }
            System.out.println();
            a = scan.nextInt();
        }
    }
}
