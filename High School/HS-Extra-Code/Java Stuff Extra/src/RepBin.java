
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class RepBin {

    public static void main(String[] args) throws Exception {
//        Reads and removes non ascii from the file
        BufferedReader br = new BufferedReader(new FileReader(new File("vbrun300.dll")));
//        Scanner scan = new Scanner(new File("vbrun300.dll"));
        FileWriter fw = new FileWriter(new File("change.dll"));
        String fin = "";
        while (br.ready()) {
//        while (scan.hasNext()) {
            String te = br.readLine();
//            String te = scan.nextLine();
            char ch[] = te.toCharArray();
//            System.out.println(te);
            String allow = "!@#$%^&*()_+-=[]\\{}|;\':\",./<>?`~";
            for (char c : ch) {
                if (Character.isLetterOrDigit(c) || allow.contains(c + "")) {
                    fin += c;
                } else {
                    fin += " ";
                }
            }
        }
//        fin = fin.replaceAll("    ", "\r\n");
//        fin = fin.replace("  ", " ");
        fw.write(fin);
        fw.flush();
        fw.close();
        br.close();
    }

}
