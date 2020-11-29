
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class CommandLineMain {

    public static void main(String[] args) throws Exception {
        out.println("User or File");
        String UF = "File"; // User or File answer
        if (UF.equalsIgnoreCase("File")) {
            String fp = ""; // File Path
            Scanner scan = new Scanner(new File(fp));
            Start(scan);
        } else if (UF.equalsIgnoreCase("User")) {
            Scanner scan = new Scanner(System.in);
            Start(scan);
        } else {
            out.println("That Doesn't Work");
        }
    }

    private static void Start(Scanner scan) throws Exception {
        out.println("Program: Compare");
        String opt = scan.nextLine();
        if (opt.equalsIgnoreCase("Compare")) {
            out.println("Compare: Files");
            String e = scan.nextLine();
            if (e.equalsIgnoreCase("Files")) {
                out.println("Compare||Files: Enter the file paths and break to stop");
                String s = scan.nextLine();
                ArrayList<String> t = new ArrayList<>(); // Files to compare
                while (!s.equalsIgnoreCase("break")) {
                    t.add(s);
                    s = scan.nextLine();
                }
                out.println("Compare||Files: Name, Size, bits");
                String NSB = scan.nextLine(); // Name Size or bit
                CompareOpt(NSB, t);
            }
        } else {
            out.println("That is not made yet");
        }
    }

    private static void CompareOpt(String NSB, ArrayList<String> t) throws Exception {
        if (NSB.equalsIgnoreCase("Name")) {
            FileWriter fw = new FileWriter(new File("SameFile.txt"));
            for (int i = 0; i < t.size(); i++) {
                for (int j = i + 1; j < t.size(); j++) {

                }
            }
        } else if (NSB.equalsIgnoreCase("Size")) {

        } else if (NSB.equalsIgnoreCase("bits")) {

        } else {
            out.println("That is not an option");
        }
    }
}
