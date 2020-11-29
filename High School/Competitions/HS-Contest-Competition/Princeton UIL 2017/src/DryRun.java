
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Kyle Fromm
 */
public class DryRun {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int values = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < values; i++) {
            System.out.println("I like " + scan.nextLine() + ".");
        }
    }
}
