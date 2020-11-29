
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class N_plutonium {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("N.txt"));
        int a = scan.nextInt();
        System.out.println("Prep this much: " + (a + 15));
    }
}
