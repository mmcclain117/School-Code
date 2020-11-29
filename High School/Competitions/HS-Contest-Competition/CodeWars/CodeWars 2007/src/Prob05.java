
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));
        double b = scan.nextDouble();
        double sum = 0;
//        double goal = 1 / (b + 1);
        int con = 1;
//        System.out.println(goal);
        while (sum < b + 1) {
            sum += 1.0 / con;
            con++;
//            System.out.println(sum + " " + con);
        }
        System.out.println((con - 2) + " card(s)");
    }

}
