
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Return of Spell binder
//        Subject: Replacing
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.next();
        String b = scan.next();
        String c = scan.next();
        System.out.println(a.replaceAll(b, c));
    }

}
