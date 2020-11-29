
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Slash the Budget
//        Points: 2
        Scanner scan = new Scanner(new File("prob01.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println("Estimated budget shortfall in 2012:  " + (a - b) + " billion");
    }

}
