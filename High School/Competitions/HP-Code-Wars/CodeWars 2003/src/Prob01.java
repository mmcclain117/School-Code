
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Introduction
//        Points: 1
        Scanner scan = new Scanner(new File("prob01.txt"));
        System.out.println("Hey, " + scan.nextLine() + "!");
        System.out.println("What is up?");
    }
}
