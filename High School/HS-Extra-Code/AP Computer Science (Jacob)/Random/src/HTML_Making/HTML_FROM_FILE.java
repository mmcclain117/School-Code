package HTML_Making;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class HTML_FROM_FILE {

    public static void main(String[] args) throws Exception {
//        Scanner sda = new Scanner(new File("List of Websites.txt"));
//        Scanner scan = new Scanner(new File("C:\\Users\\Jacob\\Dropbox\\Secret\\Login\\Website\\List of Websites.txt"));
//        String a = scan.nextLine();
//        FileWriter fw = new FileWriter(new File("Files.txt"));
//        while (scan.hasNextLine()) {
//            fw.write(a + "\n");
//            a = scan.nextLine();
//        }
//        fw.flush();
//        fw.close();
//        scan.close();
        Scanner in = new Scanner(new File("Files.txt"));
        while (in.hasNextLine()) {
            String u = in.nextLine().trim();
            String ui = u;
            String name = u.substring(0, (ui.length() - 4));
            String c = "C:\\Users\\Jacob\\Dropbox\\Secret\\Login\\Website\\";
            String d = c + name + ".URL";
            String where = d;
            String target = u;
            out.println(name + " " + where + " " + target + " " + u + " " + ui);
            String icon = "http://www.server.com/favicon.ico";
            createInternetShortcut(name, where, target, icon);
        }
    }

    public static void createInternetShortcut(String name, String where, String target, String icon) throws Exception {
        FileWriter fw = new FileWriter(where);
        fw.write("[InternetShortcut]\n");
        fw.write("URL=" + target + "\n");
        if (!icon.equals("")) {
            fw.write("IconFile=" + icon + "\n");
        }
        fw.flush();
        fw.close();
    }
}
