
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Secure the Perimeter
//        Points: 2
        Scanner scan = new Scanner(new File("prob01.txt"));
        int height = scan.nextInt();
        int width = scan.nextInt();
        System.out.println(2 * (height + width));
    }
}
