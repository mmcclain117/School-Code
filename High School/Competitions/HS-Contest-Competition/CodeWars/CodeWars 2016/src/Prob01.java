
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Greetings
//        Difficulty: Very Easy
//        Subject: Printing
        Scanner scan = new Scanner(new File("prob01.txt"));
        String a = scan.nextLine();
        System.out.println("Greetings, O Honorable " + a + " the Magnificent! May I kiss your signet ring?");
    }

}
