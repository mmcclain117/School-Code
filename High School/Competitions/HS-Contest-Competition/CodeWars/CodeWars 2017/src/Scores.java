
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Scores {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("C:\\Users\\Master Ward\\Downloads\\ss.txt"));
        FileWriter fw = new FileWriter(new File("C:\\Users\\Master Ward\\Downloads\\out.csv"));

        fw.write(scan.nextLine() + "\n");
        fw.write(scan.nextLine() + ", " + scan.nextLine() + ", " + scan.nextLine() + ", " + scan.nextLine() + "\n");
        String s = scan.nextLine();
        /* Novice */
        while (!s.contains("--")) {
            String team = s;
            String points = scan.nextLine();
            String passed = scan.nextLine();
            String failed = scan.nextLine();
            fw.write(team + ", " + points + ",  " + passed + ", " + failed + "\n");
            s = scan.nextLine();
        }
        /* Advance */
        while (scan.hasNext()) {
            String team = scan.nextLine();
            String points = scan.nextLine();
            String passed = scan.nextLine();
            String failed = scan.nextLine();
            fw.write(team + ", " + points + ",  " + passed + ", " + failed + "\n");
        }
        fw.flush();
        fw.close();
        System.out.println();
    }

}
