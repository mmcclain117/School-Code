
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: No Disassemble
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        String numbers[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        int a = scan.nextInt();
        System.out.println("Number " + numbers[a] + " is alive!");
    }
}
