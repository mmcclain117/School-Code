
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: NetOS App
//        Difficulty: Very Easy
//        Subject: Math
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.nextLine();
        while (!"0 0".equals(a)) {
            String te[] = a.split("\\s+");
            int s = Integer.parseInt(te[0]);
            int e = Integer.parseInt(te[1]);
            System.out.println(s * e);
            a = scan.nextLine();
        }
    }
}
