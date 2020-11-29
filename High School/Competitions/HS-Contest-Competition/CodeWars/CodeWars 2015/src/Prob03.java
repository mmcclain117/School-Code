
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: No Disassemble
//        Difficulty: Very Easy
//        Subject: Array Index
        Scanner scan = new Scanner(new File("prob03.txt"));
        String b[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        int a = scan.nextInt();
        System.out.println("Number " + b[a] + " is alive!");
    }
}
