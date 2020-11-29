package Aparts;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ReadHtml {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(new File("Codeforces Test.html"));
        Scanner scan = new Scanner(new File("test.html"));
        String a = scan.nextLine();
        scan.close();
        String info = getSteps(a);
        out.println(info);
        /*
         out.println(a.indexOf("title"));
         //        out.println(a.substring(a.indexOf("problem-statement")));
         out.println((a.indexOf("section")));
         out.println(a.indexOf("problem"));
         String y = a.substring(a.indexOf("problem"));
         out.println(y.indexOf("title"));
         out.println(a.indexOf("<title>"));
         out.println(a.lastIndexOf("<title>"));
         out.println(a.substring(a.indexOf("<title>")));
         */
    }

    private static String getSteps(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"pageContent\" class=\"content-with-sidebar\">"));
        String f = e.substring(e.indexOf("<div class=\"problemindexholder\" problemindex="));
        String g = f.substring(f.indexOf("<div class=\"ttypography\">"));
        String h = g.substring(g.indexOf("<div class=\"problem-statement\">"));
        return h.substring(0, h.indexOf("<script type=\"text/javascript\">"));
    }

}
