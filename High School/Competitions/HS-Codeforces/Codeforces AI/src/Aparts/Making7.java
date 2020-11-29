package Aparts;

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
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Making7 {

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
        setUp();
        getData(3, 2);
//        getData(100, 3);
    }

    private static void setUp() throws IOException {
        File x[] = new File("src").listFiles();
        fileList = listOfFiles(x);
        File y[] = new File("src\\notDone\\Auto").listFiles();
        foldList = listOfFold(y);
        vocab = new ArrayList();

    }

    /**
     *
     * @param x
     * @return List of Files in SRC
     * @throws IOException
     */
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

    /**
     *
     * @param y
     * @return List of Files in SRC
     * @throws IOException
     */
    private static ArrayList<String> listOfFold(File y[]) throws IOException {
        ArrayList<String> fold = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        for (int i = 0; i < y.length; i++) {
            temp.add(y[i]);
        }
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

    /**
     *
     * @param round
     * @param letter
     * @throws IOException
     */
    public static void getData(int round, int letter) throws IOException {
//        ArrayList<ArrayList<String>> type = new ArrayList();
        String startHttp = "http://codeforces.com/problemset/problem/";
//        ArrayList<String> ts = new ArrayList();
        for (int i = 1; i < round; i++) {
            for (int j = 0; j < letter; j++) {
                URL url;
                try {
                    char let = (char) (j + 65);
                    String uPath = i + "/" + let;
                    url = new URL(startHttp + uPath);
                    URLConnection conn = url.openConnection();

                    // open the stream and put it into BufferedReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    String inputLine;

                    // save it anywhere in local machine for offline use
                    String fileName = i + (let + "") + ".html";
                    File file = new File(fileName);

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    while ((inputLine = br.readLine()) != null) {
                        bw.write(inputLine);
                    }
                    bw.close();
                    br.close();
                    fw.close();
                    long sizing = Files.size(file.toPath());
                    out.println(sizing + " " + file.getName());
                    String temp = "";
                    if (!((sizing >= 180000))) {
                        Scanner scan = new Scanner(new File(file.getName()));
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
                    }
//                    String body = narrowBody(temp);
//                    String tag = narrowTags(temp);
//                    FileWriter fs = new FileWriter(new File("src/notDone/Auto/T.txt"));
//                    fs.write("Body \n" + body + "\nTags\n" + tag);
//                    fs.flush();
//                    fw.close();
                    String testVar;
                    /*
                     Writing All the components
                     */
//                    testVar = "Name: " + getName(body) + "\nTitle: " + getTitle(body) + "\nTime Limit: " + getTimeLimit(body) + "\nMemory Limit: " + getMemoryLimit(body);
//                    testVar += "\nInput: " + getInput(body) + "\nOutput: " + getOutput(body) + "\nStory: " + getStory(body);
////                    testVar += "\nInput Story: " + getInputStory(body) + "\nOutput Story: " + getOutputStory(body) + "\nInput Variable: " + getInputVar(body);
//                    testVar += "\nInput Story: " + getInputStory(temp) + "\nOutput Story: " + getOutputStory(body) + "\nInput Variable: " + getInputVar(body);
//                    testVar += "\nOutput Var: " + getOutputVar(body);
//                    testVar += "\nTags: " + tag;
//                    testVar += "\nTag Var: " + tagsVariable(tag) + "\nTags: " + getTag(tag);
//                    write("Body: " + body + "\nTags: " + tag);
//                    write(testVar);
//                    ts.add(getTitle(body));
//                    bodyVariables(temp);
//                    BodyVar s = new BodyVar(body);
                    BodyVar s = new BodyVar(temp);
                    TagVar t = new TagVar(temp);
//                    out.println(getTitle(body));
                    out.println(s.getTitle());
                    out.println(t.tagsVariable());
//                    out.println(tagsVariable(tag));
                    write(s, t, round);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.gc();
            }
        }
//        out.println(Arrays.toString(ts.toArray()));
    }

//    private static void bodyVariables(String a) {
//        String sm = narrowBody(a);
//        //        Setting the parameters
//        String title = sm.substring(sm.indexOf("title\">"));
//        title = title.substring(7, title.indexOf("</div"));
//        sm = sm.substring(sm.indexOf(title) + title.length());
//        String timeLimit = sm.substring(sm.indexOf("time limit per test") + 25);
//        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
//        sm = sm.substring(sm.indexOf("memory limit per test") + 27);
//        String memoryLimit = sm.substring(0, sm.indexOf(" "));
//        sm = sm.substring(sm.indexOf(">input<") + 12);
//        String input = sm.substring(0, sm.indexOf("<"));
////        out.println(input);
//        sm = sm.substring(sm.indexOf(">output<") + 13);
//        String output = sm.substring(0, sm.indexOf("<"));
//        sm = sm.substring(sm.indexOf("<") + 20);
//        //        Paragraph
//        String parPattern = "</p><p>";
//        String parts[] = sm.split(parPattern);
//        String story = "";
//        for (int i = 0; i < parts.length - 1; i++) {
//            story += parts[i] + "\n";
//        }
//        String partsCur = parts[parts.length - 1];
//        story += partsCur.substring(0, partsCur.indexOf("<"));
//        sm = sm.substring(story.length());
//        sm = sm.substring(sm.indexOf("<"));
//        //        Input and Output Story
//        /*
//         Not Fully to text so can adjust that later though
//         */
//        sm = sm.substring(sm.indexOf(">Input<") + 15);
//        String inputStory = sm.substring(0, sm.indexOf("</p"));
//        sm = sm.substring(sm.indexOf(">Output<") + 16);
//        String outputStory = sm.substring(0, sm.indexOf("</p"));
//        sm = sm.substring(sm.indexOf("</p") + 3);
//        //        Input and outputs
//        /*
//         Can still work on this formatting also
//         */
//        String Examples = sm.substring(sm.indexOf(">Examples<") + 9);
//        Examples = Examples.substring(Examples.indexOf(">Input<") + 17);
//        String inputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
//        Examples = Examples.substring(Examples.indexOf(">Output<") + 18);
//        String outputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
//        //        Name of the file
//        String name = title.replace('.', '_');
//        name = name.replaceAll(" ", "");
//        name = name.replaceAll("[?!-:/+,.]+", "");
//        name += ".java";
//        //        The adding order and variable reperesentation
////        out.println(name + " " + title);
////        out.println(story.equals(getStory(a)));
//
//    }
    private static boolean fileExist(String fileName) {
        return fileList.contains(fileName);
    }

//    public static void write(String a) throws IOException {
//        Scanner s = new Scanner(a);
//        s.next();
//        String as = s.next();
//        out.println(as);
//        FileWriter fw = new FileWriter(new File("src/notDone/Auto/" + as));
////        out.println(a);
//        as = as.replaceAll(".java", "");
//        fw.write("package notDone.Auto;\n");
//        fw.write("public class " + as + "{\n");
//        fw.write("public static void main(String args[]) {\n}\n}");
////        fw.write(a);
//        fw.flush();
//        fw.close();
//    }
    public static void write(BodyVar b, TagVar t, int round) throws IOException {
        roundFoldExist(round);
        FileWriter fw = new FileWriter(new File("src/notDone/Auto/Round_" + round + "/" + b.getName() + ".java"));
        fw.write("package notDone.Auto;\n\n"
                + "/**\n"
                + "* Tags: " + t.tagsVariable()
                + "**/"
                + "\npublic class " + b.getName() + " {\n\n\t");
        fw.write("public static void main(String args[]) {\n\n\t\t");
        if ("standard input".equals(b.getInput())) {
            fw.write("Scanner scan = new Scanner(System.in);");
            String inpVa = b.getInputVar();
            ArrayList<Integer> varPlace = new ArrayList();
            String pat = "<span class=\"tex-span\">";
            while (inpVa.contains("pat")) {
                int oy = inpVa.indexOf(pat);
                varPlace.add(oy);
                inpVa = inpVa.replaceFirst(pat, "");
            }
            fw.write(inpVa + "\n\n" + Arrays.toString(varPlace.toArray()));
            fw.flush();
            fw.close();
        } else {
            fw.flush();
            fw.close();
        }
    }

    private static void roundFoldExist(int i) {
        String rounds = "Round_" + i;
        if (!(foldList.contains(rounds))) {
            File x = new File("src\\notDone\\Auto\\Round_" + i);// The path tso the folder notDone);
            x.mkdirs();
        }
    }

    /*
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
     return fin;
     }
     */
}
