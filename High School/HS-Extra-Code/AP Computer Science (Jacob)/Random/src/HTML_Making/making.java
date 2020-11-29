package HTML_Making;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class making {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        while (!a.equalsIgnoreCase("Done")) {
            Write(a);
            a = scan.nextLine();
        }
    }

    private static void Write(String a) throws Exception {
        FileWriter fw = new FileWriter(new File(("C:\\Users\\Jacob\\Dropbox\\Secret\\Journal\\" + a + ".txt")));
        fw.write("");
        fw.flush();
        fw.close();
    }
}
