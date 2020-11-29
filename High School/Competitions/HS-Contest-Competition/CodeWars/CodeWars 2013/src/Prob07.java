
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: A Question of time
//        Difficulty: Easy
//        Subject: Math, Time
        Scanner scan = new Scanner(new File("prob07.txt"));
        int a = scan.nextInt();
        while (a != -1) {
            if (a == 0) {
                System.out.println("12:00");
            } else if (a == 30) {
                System.out.println("6:30");
            } else if (a % 5 == 0) {
                System.out.print(12 - (int) (a / 5));
                if (a < 10) {
                    System.out.println(":0" + a);
                } else {
                    System.out.println(":" + a);
                }
            } else {
                System.out.print(12 - (int) (a / 5) - 1);
                if (a < 10) {
                    System.out.println(":0" + a);
                } else {
                    System.out.println(":" + a);
                }
            }
            a = scan.nextInt();
        }
    }
}
