
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));
        int a = scan.nextInt();
        for (int i = 0; i <= a; i++) {
            System.out.println("2^" + i + " = " + (int) (Math.pow(2, i)));
        }
    }

}
