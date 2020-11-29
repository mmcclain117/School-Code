
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Code Warrior Intruction
//        Points: 1
        Scanner scan = new Scanner(new File("prob01.txt"));
        System.out.println("What's up " + scan.nextLine() + "?");
        System.out.println("We are Athens High School Lions: Mike Davis, Anh Nguyen, and Isok Patel");
    }
}
