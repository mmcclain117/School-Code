
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
public class Main2 {

    public static void main(String[] args) throws Exception {
        String SFP = "I:\\__Seperating\\Videos\\Movies"; // Source File path
        String u = "https://www.rottentomatoes.com"; // Url base
        String ex = "/m/"; // Extension
        int counters = 0;
//        String nam = "rogue_one_a_star_wars_story";
//        String nam = "15_Minutes";
        File naming[] = new File(SFP).listFiles(); // List of Source Folder's Files
        String[] MN = new String[naming.length]; // Movie Names
        for (int i = 0; i < naming.length; i++) {
            MN[i] = naming[i].getName().replaceAll("\\s", "_");
        }
        for (int i = 0; i < MN.length; i++) {
            String nam = MN[i]; // Current Movie Name
            URL url;
            try {
                url = new URL(u + ex + nam);
                URLConnection conn = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                String fileName = (nam.substring(0, nam.lastIndexOf("."))) + ".html";
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
                FileWriter ff = new FileWriter(new File(((nam.substring(0, nam.lastIndexOf("."))) + ".txt")));
//            ff.write(getMovieInfo(readFile(fileName)));
                String ss = (getMovieInfo(readFile(fileName))) + "\n\n";
                String finalSolution = "";
                Scanner temper = new Scanner(ss);
                while (temper.hasNext()) {
//                finalSolution += temper.nextLine() + (((char) 133) + "");
                    finalSolution += temper.nextLine() + System.getProperty("line.separator");
                    temper.nextLine();
                }
                ff.write(finalSolution);
                ff.flush();
                ff.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(nam + " Not Found");
                counters++;
//                e.printStackTrace();
            }
        }
        System.out.println(counters);
    }

    private static String readFile(String fileName) throws Exception {
        Scanner scan = new Scanner(new File(fileName));
        String fin = "";
        while (scan.hasNext()) {
            String te = scan.nextLine();
            fin += te;
        }
        return fin;
    }

    private static String getList(String fin) {
        fin = fin.substring(fin.indexOf("<ul"));
        fin = fin.substring(0, fin.indexOf("</ul"));
        String te[] = fin.split("\"meta-label");
        for (int i = 0; i < te.length; i++) {
            System.out.println(te[i].replaceAll("\\s+", " "));
        }
        return fin;
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
        String tes[] = ul.replaceAll("<div class=\"meta-label subtle\">", "(((").split("[(((]");
        fin = "";
        for (String y : tes) {
            y = y.trim();
            String tt = y.replaceAll("<", "#");
            tt = tt.replaceAll(">", "#");
            String fs = " ";
            fs = remove(tt).replaceAll("\\s+", " ").trim();
            fin += fs.trim() + (("".equals(fs.trim()) ? "\n" : ""));
        }
        return fin.substring(3);
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
