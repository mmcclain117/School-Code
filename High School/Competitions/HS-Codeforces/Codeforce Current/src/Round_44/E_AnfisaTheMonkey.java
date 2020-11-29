package Round_44;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;

public class E_AnfisaTheMonkey {

    /**
     * Tags: Dynamic Programming (Dp)
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); // Lines
        int a = scan.nextInt(); // Min number
        int b = scan.nextInt(); // Max number
        String n = scan.nextLine();
        if ((a * k) < n.length() && n.length() < (b * k)) {

        } else {
            out.println("No solution");
        }
    }
}
