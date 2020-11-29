
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward and Cody Chang
 */
public class Abdul {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("abdul.dat"));
        while (scan.hasNext()) {
            int x = scan.nextInt();
            int end = 2 * x;
            int sum = 0;
            for (int i = 1; i < end; i = i + 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

}
