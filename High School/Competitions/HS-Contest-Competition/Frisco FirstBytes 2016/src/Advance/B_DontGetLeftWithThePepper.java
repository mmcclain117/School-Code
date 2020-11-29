package Advance;


import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_DontGetLeftWithThePepper {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("B.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int b = scan.nextInt();
            String y = scan.next();
            if (b % 2 == 0) { // Even
                if (y.equals("Joe")) {
                    out.print("Jane");
                } else {
                    out.print("Joe");
                }
            } else { // Odd
                out.print(y);
            }
            out.println(" wins");
        }
    }
}
