
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Parasitoid / Host Interactive Models
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob02.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(a * b);
    }
}
