
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ConstantRuns {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("constantruns.txt"));
        for (int a = scan.nextInt(); a > 0; a--) {
            String b = scan.nextLine();

        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("constantruns.txt");
        fw.write("3\n"
                + "A human must turn the information into intelligence or knowledge\n"
                + "$234.56 \n"
                + "QWERTY");
        fw.flush();
        fw.close();
    }
}
