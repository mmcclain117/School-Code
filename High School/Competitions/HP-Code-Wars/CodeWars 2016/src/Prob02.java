
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Running Out Of Water
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            System.out.println(a + " gallons per week will last " + (10000 / a) + " weeks");
            a = scan.nextInt();
        }
    }
}
