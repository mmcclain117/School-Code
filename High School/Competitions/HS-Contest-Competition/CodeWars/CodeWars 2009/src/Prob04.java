
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Dirt Simple Calculator
//        Difficulty: Easy
//        Subject: Brute Force, Calculator
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.nextLine();
        while (!a.equals("0 =")) {
            Scanner in = new Scanner(a);
            double sum = in.nextInt();
            while (in.hasNext()) {
                String s = in.next();
                if ("-".equals(s)) {
                    sum -= in.nextInt();
                } else if ("+".equals(s)) {
                    sum += in.nextInt();
                } else if ("*".equals(s)) {
                    sum *= in.nextInt();
                } else if ("/".equals(s)) {
                    sum /= in.nextInt();
                }
            }
            System.out.println((int) sum);
            a = scan.nextLine();
        }
    }

}
