
import java.util.*;
import java.io.*;

/**
 *
 * @author Master
 */
public class PaperbackWriter {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("Writer.txt"));
        String b = scan.nextLine();
        int a = scan.nextInt();
        for (int aa = 0; a > aa; aa++) {
            String c = scan.next();
            String d = scan.nextLine();
            if (b.contains(c)) {
                b.replace(c, d);
            }
            System.out.println(b);
        }
        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("Writer.txt");
        fw.write("Where can I get a Coke ?\n"
                + "3\n"
                + "Where zebra crossing\n"
                + "Coke cold drink\n"
                + "jalapenos green chili");
        fw.flush();
        fw.close();
    }
}
