package HTML_Making;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class HTML {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(new File("C:\\Users\\Jacob\\Dropbox\\Secret\\Bookmark Bar\\bookmarks_7_2_15.html"));
        String a = scan.nextLine();
        FileWriter fw = new FileWriter(new File("Files.txt"));
        while (scan.hasNext()) {
            if (a.contains("HREF")) {
                int b = a.indexOf("http");
                int c = a.indexOf("ADD");
                String y = a.substring(b, c - 2) + "\n";
                fw.write(y);
            }
            if (a.contains("</A>")) {
                int b = a.indexOf("</A");
                int c = a.lastIndexOf("\">");
                String y = a.substring(c + 2, b).replaceAll("[!|,-?]+", "_") + "\n";
                fw.write(y);
                out.println(c + " " + b + "    " + y);
            }
            a = scan.nextLine();
        }
        fw.flush();
        fw.close();
        scan.close();
        Scanner in = new Scanner(new File("Files.txt"));
        while (!in.hasNext(" ")) {
            String u = in.nextLine().trim();
            String ui = in.nextLine().trim();
            String name = ui;
            String c = "C:\\Users\\Jacob\\Dropbox\\Secret\\Bookmark Bar\\Test Folder7\\";
            String d = c + ui + ".URL";
            String where = d;
            String target = u;
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
