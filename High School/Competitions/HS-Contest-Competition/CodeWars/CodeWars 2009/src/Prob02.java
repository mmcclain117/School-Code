
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Polite numbers
//        Difficulty: Very easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob02.txt"));
        int a = scan.nextInt();
        double numb = 2;
        while (a > (int) numb) {
            numb *= 2;
        }
        if ((int) numb == a) {
            System.out.println(a + " is impolite");
        } else {
            System.out.println(a + " is polite");
        }
    }

}
