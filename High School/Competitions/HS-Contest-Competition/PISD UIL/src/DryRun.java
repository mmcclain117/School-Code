
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class DryRun {

    public static void main(String args[]) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("dryrun.dat"));
        int values = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < values; i++) {
            String a = scan.nextLine();
            System.out.println("I like " + a + ".");
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("dryrun.dat");
        fw.write("4\n"
                + "cabbage\n"
                + "contests\n"
                + "judges\n"
                + "everything");
        fw.flush();
        fw.close();
    }
}
