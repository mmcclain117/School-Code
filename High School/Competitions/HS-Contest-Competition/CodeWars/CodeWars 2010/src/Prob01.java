
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Secure the Perimeter
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob01.txt"));
        int h = scan.nextInt();
        int w = scan.nextInt();
        System.out.println(2 * (h + w));
    }
}
