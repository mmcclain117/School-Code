
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Bee Math
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob01.txt"));
        int t = scan.nextInt();
        while (t != 0) {
            System.out.println(t + " " + (int) Math.ceil(100 * Math.sqrt(t) + 201 / (t + 1) + 1));
            t = scan.nextInt();
        }
    }
}
