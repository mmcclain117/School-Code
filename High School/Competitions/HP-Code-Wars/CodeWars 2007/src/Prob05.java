
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Overhanging Cards
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        double b = scan.nextDouble();
        double sum = 0;
        int con = 1;
        while (sum < b + 1) {
            sum += 1.0 / con;
            con++;
//            System.out.println(sum + " " + con);
        }
        System.out.println((con - 2) + " card(s)");
    }

}
