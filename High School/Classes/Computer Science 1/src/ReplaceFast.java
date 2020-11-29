
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ReplaceFast {

    public static void main(String[] args) throws Exception {
        String file = "Y_Encrypt.txt";
        Scanner scan = new Scanner(new File(file));
        String lineOfCode = "";
        while (scan.hasNext()) {
            lineOfCode += scan.nextLine() + "\n";
        }
        out.println(lineOfCode);
        FileWriter fw = new FileWriter(new File(file));
        Scanner ii = new Scanner(lineOfCode);
//        while (ii.hasNext()) {
//            String cur = ii.next() + " ";
//            fw.write(cur);
//        }
        fw.write("\n");
        Scanner in = new Scanner(System.in);
        out.println("Enter the variable that is writen then a space then variable you want to replace with");
        out.println("And enter Done to stop");
        String y = in.nextLine().trim();
        while (!y.equalsIgnoreCase("Done")) {
            char ch[] = y.toCharArray();
            char b = ch[0];
            char v = ch[2];
            lineOfCode = lineOfCode.replace(b, v);
            y = in.next();
        }
        Scanner u = new Scanner(lineOfCode);
        while (u.hasNext()) {
            String cur = u.next() + " ";
            fw.write(cur);
        }
        fw.flush();
        fw.close();
        scan.close();
        in.close();
        u.close();
    }
}
