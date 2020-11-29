
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Fruits {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("fruits.txt"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            String b = scan.nextLine();
            String c[] = b.split("\\s+");
            Arrays.sort(c);

        }
    }

}
