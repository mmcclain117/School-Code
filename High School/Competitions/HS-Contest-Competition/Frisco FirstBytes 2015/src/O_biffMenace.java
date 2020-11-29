
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class O_biffMenace {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("O.txt"));
        for (int i = 0; i < 3; i++) {
            double a = scan.nextDouble();
            if (a >= .1) {
                System.out.println("DUI");
            } else {
                System.out.println("Warning");
            }
        }
    }
}
