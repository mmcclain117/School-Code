
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Download {

    public static void main(String[] args) throws Exception {
        String u = "https://www.rottentomatoes.com";
        String ex = "/m/rogue_one_a_star_wars_story";
        URL url;
        try {
            url = new URL(u + ex);
            URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String fileName = "testAlt.html";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }
            bw.close();
            br.close();
            FileWriter ff = new FileWriter(new File("test.txt"));
            ff.write(getMovieInfo(readFile(fileName)));
            ff.flush();
            ff.close();
//            readFile(fileName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) throws Exception {
//        FileWriter fw = new FileWriter(new File("text.txt"));
        Scanner scan = new Scanner(new File(fileName));
        String fin = "";
        while (scan.hasNext()) {
            String te = scan.nextLine();
//            fw.write(te + "\n");
//            fin += te + "\n";
            fin += te;
        }
        return fin;
//        int start = fin.indexOf("Movie Info");
//        fin = fin.substring(start);
//        int end = fin.indexOf("Critic Reviews");
//        fin = fin.substring(0, end);
//        String bullets = getList(fin);
//        System.out.println(bullets);
//        fw.write(fin);
//        fw.flush();
//        fw.close();
//        scan.close();
//        System.out.println("Index of Unordered List is " + fin.indexOf("<ul"));
//        FileWriter ff = new FileWriter(new File("Line.txt"));
//        String yy[] = fin.split("\\s+");
//        for (String p : yy) {
//            ff.write(p + "\n");
//            ff.flush();
//        }
//        ff.close();
    }

    private static String getList(String fin) {
        fin = fin.substring(fin.indexOf("<ul"));
        fin = fin.substring(0, fin.indexOf("</ul"));
        String te[] = fin.split("\"meta-label");
        for (int i = 0; i < te.length; i++) {
//            System.out.println(te[i]);
            System.out.println(te[i].replaceAll("\\s+", " "));
        }
        return fin;
//        return Arrays.toString(te);
    }

    /**
     * Has a problem with the Directed by and the Rating
     *
     * @param fin
     * @return
     */
    private static String getMovieInfo(String fin) {
        fin = fin.substring(fin.indexOf("movieSynopsis")); // The start
        fin = fin.substring(0, fin.indexOf("</section")); // The end
        String ul = fin.substring(fin.indexOf("<ul"), fin.indexOf("</ul>"));
        String co = fin.substring(fin.indexOf(">") + 1, fin.indexOf("<")).trim(); // Comments at beginning
//        String ra = fin.substring(co.indexOf(co)); // Rating
//        System.out.println(ul);
        String tes[] = ul.replaceAll("<div class=\"meta-label subtle\">", "(((").split("[(((]");
//        System.out.println(Arrays.toString(tes));
        fin = "";
        for (String y : tes) {
            y = y.trim();
            String tt = y.replaceAll("<", "#");
            tt = tt.replaceAll(">", "#");
            String fs = "";
//            System.out.println(y + " \n" + tt);
//            fs = remove(tt);
//            System.out.println(remove(tt).replaceAll("\\s+", " "));
            fs = remove(tt).replaceAll("\\s+", " ");
//            while (tt.contains("#")) {
//                fs += tt.substring(0, tt.indexOf("#")).trim();
//                tt = tt.substring(tt.indexOf("#") + 1).trim();
//                tt = tt.substring(tt.indexOf("#") + 1).trim();
//            }
//            System.out.println(tt);
//            System.out.println("Final: " + fs.trim());
//            System.out.println("".equals(fs.trim()));
            fin += fs.trim() + (("".equals(fs.trim()) ? "\n" : ""));
//            if (!"".equals(fs)) {
//            fin += fs.trim() + "\n";
//            System.out.println(y.trim());
        }
//        }
//        String temp = fin;
//        String f = "";
//        System.out.println(fin);
//        System.out.println(temp.indexOf("<"));
//        while (temp.indexOf(">") < temp.indexOf("<") && temp.indexOf("<") < temp.length()) {
////            System.out.println(f);
//            f += temp.substring(fin.indexOf(">"), fin.indexOf("<")).trim();
//            temp = temp.substring(temp.indexOf("<"));
//        }
//        System.out.println(f);
//        System.out.println(co);
        return fin;
    }

    private static String remove(String a) {
        String fin = "";
        String s[] = a.split("#");
        for (int i = 0; i < s.length; i++) {
            fin += s[i];
            i++;
        }
        return fin;
    }
}
