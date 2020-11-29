package ASomething;

import static ASomething.Making2.notDonePath;
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

/**
 *
 * @author Master
 */
public class Making3 {

    private static ArrayList<String> fileList; // List of already made files
    private static ArrayList<String> foldList; // list of already made folders in non complete

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        setUp();
//        File k = new File("src\\DontKnow");
//        out.println(k.isDirectory());
//        out.println(k.isFile());
//        out.println(k.getAbsolutePath());
        HashMap<String, String> xxx = getData(3, 4);// Path, Html Data
        ArrayList<ArrayList> types = new ArrayList();
        Collection<String> datas = xxx.values();
        ArrayList<Object> x = new ArrayList();
        Set<String> keys = xxx.keySet();
        Object[] sxdx = keys.toArray();
//        out.println(Arrays.toString(sxdx));
//        out.println(Arrays.toString(datas.toArray()));
//        out.println(datas.size());
//        out.println(x.size());
        for (String d : datas) {
            x.add(d);
        }
//        out.println(x.size());
        x.add(Arrays.asList(datas.toArray()));
        Set<String> sds = xxx.keySet();
        ArrayList<Object> data2 = new ArrayList();
        data2.add(sds.toArray());
//        out.println(x.get(0));
        for (int i = 0; i < x.size(); i++) {
//            ArrayList<String> data = new ArrayList();
            String a = x.get(i).toString();
            types.add(HtmlVariables(a));
            if (i >= sxdx.length) {
                types.get(i).add(0); // 12
            } else {
                types.get(i).add(sxdx[i]); // 12
            }
        }
        ArrayList de = new ArrayList(); // Name of all duplicate files

        for (int i = 0; i < types.size(); i++) {
            if (fileExist(types.get(i).get(10).toString())) {
                de.add(types.get(i).get(10).toString());
            } else {
                String[] temper = types.get(i).get(12).toString().split("/");
                roundFoldExist(Integer.parseInt(temper[0]));
//                out.println(xxx.containsKey(types.get(i)));
//                out.println(xxx.containsValue(types.get(i)));
                write(types.get(i));
            }
        }
    }

    private static void setUp() throws IOException {
        File x[] = new File("src").listFiles();
        fileList = listOfFiles(x);
        File y[] = new File("src\\notDone").listFiles();
        foldList = listOfFold(y);
//        out.println(foldList.size() + " " + Arrays.toString(foldList.toArray()));
//        fileList = new ArrayList();

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
        temp.addAll(Arrays.asList(y));
        while (!temp.isEmpty()) {
            if (temp.get(0).isDirectory()) {
                fold.add(temp.get(0).getName());
                File tempFile[] = temp.remove(0).listFiles();
                for (int i = 0; i < tempFile.length; i++) {
                    temp.add(tempFile[i]);
                }
            } else {
                temp.remove(0);
//                fold.add(temp.remove(0).getName());
            }
        }
        return fold;
    }

    private static HashMap<String, String> getData(int round, int letter) {
        HashMap<String, String> hm = new HashMap();
        String startHttp = "http://codeforces.com/problemset/problem/";
//        ArrayList<String> data = new ArrayList();
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
                    long sizing = Files.size(file.toPath());
//                    out.println(sizing);
                    if (!((sizing >= 180000))) {
                        Scanner scan = new Scanner(new File("test.html"));
                        String temp = "";
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
//                        out.println(narrowTags(temp));
//                        out.println(uPath);
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
//        out.println(f);
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
        ArrayList<String> ss = new ArrayList();
        String sm = narrowBody(htmlData);

//        Setting the parameters        
        String title = sm.substring(sm.indexOf("title\">"));
        title = title.substring(7, title.indexOf("</div"));
//        out.println("Title: " + title);
        sm = sm.substring(sm.indexOf(title) + title.length());
        String timeLimit = sm.substring(sm.indexOf("time limit per test") + 25);
        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
//        out.println("Time Limit: " + timeLimit + (Integer.parseInt(timeLimit) == 1 ? " second" : " seconds"));
        sm = sm.substring(sm.indexOf("memory limit per test") + 27);
        String memoryLimit = sm.substring(0, sm.indexOf(" "));
//        out.println("Memory Limit: " + memoryLimit + " megabytes");
        sm = sm.substring(sm.indexOf(">input<") + 12);
        String input = sm.substring(0, sm.indexOf("<"));
//        out.println("Input: " + input);
        sm = sm.substring(sm.indexOf(">output<") + 13);
        String output = sm.substring(0, sm.indexOf("<"));
//        out.println("Output: " + output);
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
//        out.println(story);
        sm = sm.substring(story.length());
        sm = sm.substring(sm.indexOf("<"));
//        Input and Output Story
        /*
         Not Fully to text so can adjust that later though
         */
        sm = sm.substring(sm.indexOf(">Input<") + 15);
        String inputStory = sm.substring(0, sm.indexOf("</p"));
//        out.println("Input Story: " + inputStory);
        sm = sm.substring(sm.indexOf(">Output<") + 16);
        String outputStory = sm.substring(0, sm.indexOf("</p"));
//        out.println("Output Story: " + outputStory);
        sm = sm.substring(sm.indexOf("</p") + 3);
//        Input and outputs
        /*
         Can still work on this formatting also
         */
        String Examples = sm.substring(sm.indexOf(">Examples<") + 9);
        Examples = Examples.substring(Examples.indexOf(">Input<") + 17);
        String inputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
//        out.println("Input Values: " + inputVal);
        Examples = Examples.substring(Examples.indexOf(">Output<") + 18);
        String outputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
//        out.println("Output Values: " + outputVal);
//        Name of the file
        String name = title.replace('.', '_');
        name = name.replaceAll(" ", "");
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
//        out.print("\n\n\n\n");
        return ss;
    }

    private static String tagsVariable(String a) {
//        ArrayList<String> ss = new ArrayList();
        String sm = narrowTags(a);
//        out.println(sm);
        String[] sst = sm.split("<span");
//        out.println(Arrays.toString(sst));
        String ret = "";
        for (int i = 1; i < sst.length; i++) {
            ret += getTag(sst[i]) + "\n";
        }
//        out.println(sst.length);
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

    private static void write(ArrayList a) {

    }

    /**
     *
     */
    /**
     *
     */
    /**
     *
     */
    private static void write(String fileName) throws IOException {
        out.println(fileName);
        /*
         FileWriter fw = new FileWriter(fileName + ".java");
         fw.write("package NotDone.Round_1;\n"
         + "\n"
         + "import static java.lang.System.out;\n"
         + "import java.util.Arrays;\n"
         + "import java.util.Scanner;\n"
         + "\n"
         + "// Round 1\n"
         + "public class B_Spreadsheets {\n"
         + "\n"
         + "    public static void main(String[] args) {\n"
         + "        Scanner scan = new Scanner(System.in);\n"
         + "     }\n"
         + "}");
         fw.flush();
         fw.close();
         */
    }

    /**
     * Grabs the problem set information only
     *
     * @see Paragraph and need the tags
     *
     * @param a
     * @return
     */
    private static void roundFoldExist(int i) {
        String rounds = "Round_" + i;
        if (!(foldList.contains(rounds))) {
            File x = new File(notDonePath + "\\Round_" + i);// The path to the folder notDone);
            x.mkdirs();
        }
    }

}
