
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class J {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("J.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            int b = a - 5;
            System.out.println((int) Math.ceil(Math.sqrt(b)));
            a = scan.nextInt();
        }
    }
}
