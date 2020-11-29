
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Diamonds are Forever
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        char c = scan.nextLine().charAt(0);
        int b = scan.nextInt();
        for (int i = 1; i < b + 1; i++) { // Top Half
            for (int p = b - i; p > 0; p--) {
                System.out.print(" ");
            }
            System.out.print(c + "");
            for (int o = 0; o < i * 2 - b + (b / 2); o++) {
                System.out.print(" ");
            }
            if (i != 1) {
                System.out.println(c + "");
            } else {
                System.out.println();
            }
        }
        for (int i = 1; i < b; i++) { // Bottom Half
            for (int o = 0; o < i; o++) {
                System.out.print(" ");
            }
            System.out.print(c + "");
            for (int p = (b - i) * 2 - 3; p > 0; p--) {
                System.out.print(" ");
            }
            if (i != b - 1) {
                System.out.println(c + "");
            } else {
                System.out.println();
            }
        }
    }
}
