
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class DryRun {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("dryrun.dat"));

        int values = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < values; i++) {
            out.println("I like " + scan.nextLine() + ".");
        }
    }

}
