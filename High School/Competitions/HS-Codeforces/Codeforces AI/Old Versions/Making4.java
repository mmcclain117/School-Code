package ASomething;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class Making4 {

    private static ArrayList<String> fileList; // List of already made files
    private static ArrayList<String> foldList; // list of already made folders in non complete
    private static ArrayList<String> vocab; // List of the words
// Look at FileSystems

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
//        Path path = FileSystems.getDefault().getPath("src\\NotDone\\Auto");
//        Path path = FileSystems.getDefault().getPath("src\\NotDone", "Auto");
//        out.println(path.toFile().toString());
//        Files.deleteIfExists(path);
        boolean bol = true;
        testStage(bol); // Could do it to check if file exist but am lazy
        setUp();
        HashMap<String, String> xxx = getData(3, 3);// Path, Html Data
//        HashMap<String, String> xxx = getData(100, 1);// Path, Html Data
        ArrayList<ArrayList> types = new ArrayList();
        Collection<String> datas = xxx.values();
        ArrayList<Object> x = new ArrayList();
        Set<String> keys = xxx.keySet();
        Object[] sxdx = keys.toArray();
        for (String d : datas) {
            x.add(d);
        }
        x.add(Arrays.asList(datas.toArray()));
        Set<String> sds = xxx.keySet();
        ArrayList<Object> data2 = new ArrayList();
        data2.add(sds.toArray());
        for (int i = 0; i < x.size(); i++) {
            String a = x.get(i).toString();
            types.add(HtmlVariables(a));
            if (i >= sxdx.length) {
                types.get(i).add(0); // 12 round number
            } else {
                types.get(i).add(sxdx[i]); // 12  round number
            }
        }
        ArrayList de = new ArrayList(); // Name of all duplicate files

        for (int i = 0; i < types.size(); i++) {
            out.println(Arrays.toString(types.get(i).toArray()));
            if (fileExist(types.get(i).get(10).toString())) {
                de.add(types.get(i).get(10).toString());
            } else {
                String[] temper = types.get(i).get(12).toString().split("/");
                roundFoldExist(Integer.parseInt(temper[0]));
                write(types.get(i));
            }
        }
        FileWriter pp = new FileWriter("vocab.txt");
        ArrayList<String> nonRep = new ArrayList();
//        out.println(Arrays.toString(vocab.toArray())+ " "+ vocab.size());
        while (!vocab.isEmpty()) {
            String tempo = vocab.get(0);
            nonRep.add(tempo);
            while (vocab.contains(tempo)) {
                vocab.remove(tempo);
            }
        }
        for (String yu : nonRep) {
            pp.write(yu + "\n");
        }
        pp.flush();
        pp.close();
    }

    private static void testStage(boolean a) throws IOException {
        if (a) {
            File x = new File("src\\notDone\\Auto");
            x.delete();
        }
        File x = new File("src\\notDone\\Auto");
        x.mkdir();
    }

    private static void setUp() throws IOException {
        File x[] = new File("src").listFiles();
        fileList = listOfFiles(x);
//        File y[] = new File("src\\notDone").listFiles();
        File y[] = new File("src\\notDone\\Auto").listFiles();
        foldList = listOfFold(y);
        vocab = new ArrayList();

    }

    private static ArrayList<String> listOfFiles(File x[]) throws IOException {
        ArrayList<String> files = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        temp.addAll(Arrays.asList(x));
        while (!temp.isEmpty()) {
            if (temp.get(0).isDirectory()) {
                File tempFile[] = temp.remove(0).listFiles();
                for (int i = 0; i < tempFile.length; i++) {
                    temp.add(tempFile[i]);
                }
            } else {
                files.add(temp.remove(0).getName());
            }
        }
        return files;
    }

    private static ArrayList<String> listOfFold(File y[]) throws IOException {
        ArrayList<String> fold = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        for (int i = 0; i < y.length; i++) {
            temp.add(y[i]);
        }
//        temp.addAll(Arrays.asList(y));
        while (!temp.isEmpty()) {
            if (temp.get(0).isDirectory()) {
                fold.add(temp.get(0).getName());
                File tempFile[] = temp.remove(0).listFiles();
                for (int i = 0; i < tempFile.length; i++) {
                    temp.add(tempFile[i]);
                }
            } else {
                temp.remove(0);
            }
        }
        return fold;
    }

    private static HashMap<String, String> getData(int round, int letter) {
        HashMap<String, String> hm = new HashMap();
        String startHttp = "http://codeforces.com/problemset/problem/";
        for (int i = 1; i < round; i++) {
            for (int j = 0; j < letter; j++) {
                URL url;
                try {
                    String uPath = i + "/" + ((char) (j + 65));
                    url = new URL(startHttp + uPath);
                    URLConnection conn = url.openConnection();

                    // open the stream and put it into BufferedReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    String inputLine;

                    // save it anywhere in local machine for offline use
                    String fileName = "test.html";
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
                    fw.close();
                    long sizing = Files.size(file.toPath());
                    if (!((sizing >= 180000))) {
                        Scanner scan = new Scanner(new File("test.html"));
                        String temp = "";
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
                        hm.put(uPath, temp);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hm;
    }

    private static String narrowBody(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"pageContent\" class=\"content-with-sidebar\">"));
        String f = e.substring(e.indexOf("<div class=\"problemindexholder\" problemindex="));
        String g = f.substring(f.indexOf("<div class=\"ttypography\">"));
        String h = g.substring(g.indexOf("<div class=\"problem-statement\">"));
        return h.substring(0, h.indexOf("<script type=\"text/javascript\">"));
    }

    private static String narrowTags(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"sidebar\">"));
        String f = e.substring(e.indexOf("<span class=\"tag-box\""));
        // This needs work if their is more thatn one tag
        return f.substring(0, f.indexOf("<div style"));
//        needs More breaking Down
    }

    private static ArrayList HtmlVariables(String a) {
        ArrayList var = new ArrayList();
        var.addAll(bodyVariables(a));
        var.add(tagsVariable(a));
        return var;
    }

    private static ArrayList<String> bodyVariables(String htmlData) {
        FileWriter fw = null;
        ArrayList<String> ss = new ArrayList();
        String sm = narrowBody(htmlData);
        //        Setting the parameters
        String title = sm.substring(sm.indexOf("title\">"));
        title = title.substring(7, title.indexOf("</div"));
        sm = sm.substring(sm.indexOf(title) + title.length());
        String timeLimit = sm.substring(sm.indexOf("time limit per test") + 25);
        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
        sm = sm.substring(sm.indexOf("memory limit per test") + 27);
        String memoryLimit = sm.substring(0, sm.indexOf(" "));
        sm = sm.substring(sm.indexOf(">input<") + 12);
        String input = sm.substring(0, sm.indexOf("<"));
        sm = sm.substring(sm.indexOf(">output<") + 13);
        String output = sm.substring(0, sm.indexOf("<"));
        sm = sm.substring(sm.indexOf("<") + 20);
        //        Paragraph
        String parPattern = "</p><p>";
        String parts[] = sm.split(parPattern);
        String story = "";
        for (int i = 0; i < parts.length - 1; i++) {
            story += parts[i] + "\n";
        }
        String partsCur = parts[parts.length - 1];
        story += partsCur.substring(0, partsCur.indexOf("<"));
        sm = sm.substring(story.length());
        sm = sm.substring(sm.indexOf("<"));
        //        Input and Output Story
        /*
         Not Fully to text so can adjust that later though
         */
        sm = sm.substring(sm.indexOf(">Input<") + 15);
        String inputStory = sm.substring(0, sm.indexOf("</p"));
        sm = sm.substring(sm.indexOf(">Output<") + 16);
        String outputStory = sm.substring(0, sm.indexOf("</p"));
        sm = sm.substring(sm.indexOf("</p") + 3);
        //        Input and outputs
        /*
         Can still work on this formatting also
         */
        String Examples = sm.substring(sm.indexOf(">Examples<") + 9);
        Examples = Examples.substring(Examples.indexOf(">Input<") + 17);
        String inputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        Examples = Examples.substring(Examples.indexOf(">Output<") + 18);
        String outputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        //        Name of the file
        String name = title.replace('.', '_');
        name = name.replaceAll(" ", "");
        name = name.replaceAll("[?!-:/+,.]+", "");
        name += ".java";
        //        The adding order and variable reperesentation
        ss.add(title); // 0
        ss.add(timeLimit); // 1
        ss.add(memoryLimit); // 2
        ss.add(input); // 3
        ss.add(output); // 4
        ss.add(story);// 5
        ss.add(inputStory); // 6
        ss.add(outputStory);// 7
        ss.add(inputVal);// 8
        ss.add(outputVal);// 9
        ss.add(name);// 10
        try {
            fw = new FileWriter(new File("x.txt"));
            for (String sd : ss) {
                fw.write(sd + "\n");
            }
            fw.flush();
            fw.close();
            fw.close();
//            return ss;
        } catch (IOException ex) {
            Logger.getLogger(Making4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ss;
    }

    private static String tagsVariable(String a) {
        String sm = narrowTags(a);
        String[] sst = sm.split("<span");
        String ret = "";
        for (int i = 1; i < sst.length; i++) {
            ret += getTag(sst[i]) + "\n";
        }
        return ret; // 11
    }

    private static String getTag(String a) {
        String b = a.substring(a.indexOf("title=") + 5);
        String c = b.substring(1, b.indexOf("</span>"));
        String d = c.replace('>', '\n');
        return d.replace("\"", "");
    }

    private static boolean fileExist(String tempHtmlData) {
        return fileList.contains(tempHtmlData);
    }

    /*
     0   Title
     1   Time Limit
     2   Memory Limit
     3   Input
     4   Output
     5   Story
     6   Input story
     7   Output Story
     8   Input values
     9   Output Values
     10  Name
     11  Tags
     12  Round
     */
    private static void write(ArrayList a) throws IOException {
        out.println(a.get(12) + " " + a.get(10));
        int round = Integer.parseInt(a.get(12).toString().substring(0, a.get(12).toString().indexOf("/")));
        File cur = new File("src\\notDone\\Auto\\Round_" + round + "\\" + a.get(10).toString());
        FileWriter fw = new FileWriter(cur);
        fw.write("package notDone.Auto.Round_" + round + "\n"
                + "\n" + (printTags(a.get(11).toString())) + "\n"
                + "import java.util.*;\n"
                + "\n"
                + "public class " + a.get(10).toString() + " {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "        Scanner scan = new Scanner(" + a.get(3) == "system input" ? "System.in);\n" : ");\n");
        boolean outDef = a.get(4) == "standard output"; // Default output
        fw.write(body(a.get(6), a.get(7), a.get(8), a.get(9), outDef));
        fw.write("        \n"
                + "    }\n"
                + "}\n"
                + ""
        );

        fw.flush();
        fw.close();
    }

    private static void roundFoldExist(int i) {
        String rounds = "Round_" + i;
        if (!(foldList.contains(rounds))) {
            File x = new File("src\\notDone\\Auto\\Round_" + i);// The path tso the folder notDone);
            x.mkdirs();
        }
    }

    private static String body(Object get, Object get0, Object get1, Object get2, boolean outDef) {
        String fin = "";
        String inputS = get.toString();
        String outputS = get0.toString();
        String inputV = get1.toString();
        String outputV = get2.toString();
        String mod = inputS.replaceAll("<i>", "(((");
        mod = mod.replaceAll("</i>", ")))");
        String in[] = mod.split("\\s+");
        for (String y : in) {
            vocab.add(y);
        }
//        String var[] = getVariable(inputS);
//        out.println(Arrays.toString(var));
        return fin;
    }

    private static String printTags(String tag) {
        String ret = "";
        String part[] = tag.split("\n");
        for (String a : part) {
            ret += "//" + a;
        }
        return ret;
    }
    /*
     private static String[] getVariable(String inputS) {
     ArrayList<String> x = new ArrayList();
     String a[] = inputS.split("<i>");
     ArrayList<String> ii = new ArrayList();
     for (String v : a) {
     int uu = v.indexOf("</i>");
     out.println(uu);
     if (!(uu == -1)) {
     x.add(v.substring(0, uu));
     }
     }
     String y[] = new String[x.size()];
     for (int i = 0; i < x.size(); i++) {
     y[i] = x.get(i);
     }
     return y;
     }
     */

}
