package Pool_Time_Cal;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Time {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("px.txt"));
        String a = scan.nextLine();
        FileWriter fw = new FileWriter(new File("Min.txt"));
        FileWriter fx = new FileWriter(new File("Sec.txt"));
        while (scan.hasNext()) {
            String y[] = a.split("\\s+");
            if (a.equalsIgnoreCase("N/a")) {
                fw.write("0" + "\n");
                fx.write("0" + "\n");
            } else if (y[1].equalsIgnoreCase("Min")) {
                int b = Integer.parseInt(y[0]);
                fw.write(b + "\n");
            } else {
                int b = Integer.parseInt(y[0]);
                fx.write(b + "\n");
            }
            a = scan.nextLine();
        }
        fw.flush();
        fw.close();
        fx.flush();
        fx.close();
        scan.close();
    }
}
