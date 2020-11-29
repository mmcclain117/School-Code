
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03a.txt"));
        Scanner in = new Scanner(new File("prob03b.txt"));
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
            System.out.println(in.nextLine());
        }
        scan.close();
        in.close();
    }
}
