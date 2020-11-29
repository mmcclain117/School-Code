
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class C_iFeelFine {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Fine.txt"));
        int a = scan.nextInt();
        double sum = 0;
        for (int i = 0; i < a; i++) {
            sum += scan.nextInt();
        }
        System.out.println("Total vacation time missed: " + ((int) sum) + " hours");
        System.out.println("Average daily time missed: " + sum / a + " hours");
    }

}
