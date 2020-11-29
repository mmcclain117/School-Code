
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Divide by 11
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        long a = scan.nextLong();
        long b = a;
        System.out.println(a);
        String numb = a + "";
        while (numb.length() > 2) {
            long sub = Long.parseLong(numb.substring(0, numb.length() - 1)) - Integer.parseInt(numb.substring(numb.length() - 1));
            System.out.println(sub);
            a = sub;
            numb = a + "";
        }
        System.out.println();
        if (a % 11 == 0) {
            System.out.println("The number " + b + " is divisible by 11.");
        } else {
            System.out.println("The number " + b + " is not divisible by 11.");
        }
    }
}
