

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Ryan Talbot
 */
public class DryRun {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String l = scan.nextLine();
            out.println("I like " + l + ".");
        }
    }
}
