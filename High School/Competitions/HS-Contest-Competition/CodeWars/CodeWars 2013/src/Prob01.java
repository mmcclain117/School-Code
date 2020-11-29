
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Selling Shirts
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob01.txt"));
        int a = scan.nextInt();
        System.out.println(8 * a - 95);
    }

}
