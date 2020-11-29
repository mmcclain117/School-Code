
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: N-Ultimate
//        Difficulty: Easy
//        Subject: Split index
        Scanner scan = new Scanner(new File("prob08.txt"));
        String a = scan.nextLine();
        while (!"0 $".equals(a)) {
            String b[] = a.split("\\s+");
            int c = Integer.parseInt(b[0]);
            System.out.println(b[b.length - c - 1]);
            a = scan.nextLine();
        }
    }
}
