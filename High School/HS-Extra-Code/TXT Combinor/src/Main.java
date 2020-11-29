
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Main {

//    Combines two text documents first to a string and then to a file
    public static void main(String[] args) throws Exception {
        File f = new File("G:\\___OTHER\\Phone Backup\\Call History\\iExplorer - Exported Call History.txt");
        Scanner scan = new Scanner(f);
        File f1 = new File("G:\\___OTHER\\Iphone Backup PT 2\\Call HIstory\\iExplorer - Exported Call History.csv");
        Scanner scan1 = new Scanner(f1);
        String fs = "";
        int con = 0;
        while (scan.hasNext()) {
            fs += scan.next();
            con++;
        }
        while (scan1.hasNext()) {
            fs += scan1.next();
            con++;
        }
        out.println(fs);
        FileWriter fw = new FileWriter(new File("combined.txt"));
        fw.write(fs);
        fw.flush();
        fw.close();
    }
}
