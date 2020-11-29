package ASomething;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Making2 {

    public static ArrayList<String> comb;
    public static ArrayList<String> fileList;
    public static String foldPath;
    public static ArrayList<String> foldList;
    public static String user = System.getProperty("user.name");
    public static String notDonePath = "C:\\Users\\" + user + "\\Dropbox\\Computer Science Extra\\CodeForces\\src\\NotDone";

    //@see Suggestions Put the Combonations break by testing eachone while adding it
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperties().toString());
        String a = "";
        foldList = getFoldList();
//        comb = getUrlCombo(700, 26);
        comb = getUrlCombo(2, 10);
        out.println(Arrays.toString(comb.toArray()));
        ArrayList<String> htmlData = getHtmlData(comb);
        fileList = fileList();
        for (int i = 0; i < htmlData.size(); i++) {
            String tempHtmlData = htmlData.get(i);
            out.println(tempHtmlData);
//            out.println(Arrays.toString(htmlData.toArray()));
//        for (String tempHtmlData : htmlData) {
            makeFile(tempHtmlData);
            comb.remove(tempHtmlData);
            htmlData.remove(tempHtmlData);
        }
//        out.println(Arrays.toString(comb.toArray()));
    }

    /**
     * Gets a list of all the URL combonations based on round and letter count
     *
     * @param round
     * @param letterCount
     * @return
     */
    private static ArrayList<String> getUrlCombo(int round, int letterCount) {
        String startHttp = "http://codeforces.com/problemset/problem/";
        ArrayList<String> p = new ArrayList();
        for (int i = 1; i < round; i++) {
            for (int j = 0; j < letterCount; j++) {
                p.add((startHttp + i + "/" + ((char) (65 + j))));
            }
        }
        return p;
    }

    /**
     * Checking to see if the URL are valid
     *
     * @param comb
     * @return
     */
    private static ArrayList<String> validateUrl(ArrayList<String> comb) {
        URL url;

        ArrayList<String> valid = new ArrayList();
        for (String t : comb) {
            try {
                // enter any url to get its content
                url = new URL(t);
                URLConnection conn = url.openConnection();
                // open the stream and put it into BufferedReader
                conn.connect();

                valid.add(t);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return valid;
    }

    /**
     * Gets the html file info and returns each file in accordance with valUR
     *
     * @param valUR
     * @return
     */
    private static ArrayList<String> getHtmlData(ArrayList<String> valUR) {
        ArrayList<String> data = new ArrayList();
        for (int o = 0; o < valUR.size(); o++) {
            URL url;
            try {
                // enter any url to get its content
                url = new URL(valUR.get(o));
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
                out.println(sizing);
                if (!((sizing >= 180000))) {
//                if (!((sizing == 187860))) {
                    Scanner scan = new Scanner(new File("test.html"));
                    String temp = "";
                    while (scan.hasNext()) {
                        temp += scan.nextLine();
                    }
                    scan.close();
                    data.add(temp);
                } else {
                    comb.remove(valUR.remove(o));
                    o--;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return data;
    }

    /**
     * Second Attempt on checking the URL to make sure they are valid and not
     * redirecting
     *
     * @param comb
     * @return
     * @throws IOException
     */
    private static ArrayList<String> validateUrl2(ArrayList<String> comb) throws IOException {

        for (int p = 0; p < comb.size(); p++) {

            try {
                URL url = new URL(comb.get(p));
                InputStream i = null;

                try {
                    i = url.openStream();
                    URLConnection uc = url.openConnection();
                    uc.connect();
                    out.println(uc.getURL());
                    out.println(url.toExternalForm());
                } catch (UnknownHostException ex) {
                    System.out.println("THIS URL IS NOT VALID");
                    comb.remove(p);
                    p--;
                }
                if (i != null) {
                    System.out.println("Its working");
                    out.println(comb.get(p));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            /*
             HttpURLConnection connection = null;
             try {
             URL myurl = new URL(comb.get(p));
             connection = (HttpURLConnection) myurl.openConnection();
             //Set request to header to reduce load as Subirkumarsao said.       
             connection.setRequestMethod("HEAD");
             int code = connection.getResponseCode();
             System.out.println("" + code);
             } catch (MalformedURLException e)  {
             e.printStackTrace();
             }
             */
        }
        return comb;
    }

    /**
     * Returns if the file exist already
     *
     * @param tempHtmlData
     * @return
     */
    private static boolean fileExist(String tempHtmlData) {
        return fileList.contains(tempHtmlData);
    }

    /**
     * Makes a file array of all the files that already Exist
     *
     * @return
     * @throws IOException
     */
    private static ArrayList<String> fileList() throws IOException {
        ArrayList<String> files = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        File x = new File("C:\\Users\\" + user + "\\Dropbox\\Computer Science Extra\\CodeForces\\src");
//        File x = new File("C:\\Users\\Master\\Dropbox\\Computer Science Extra\\CodeForces\\src");
        File stx[] = x.listFiles();

        temp.addAll(Arrays.asList(stx));
        while (!temp.isEmpty()) {
            if (temp.get(0).isDirectory()) {
//                out.println(temp.get(0).getPath() + "\n" + temp.get(0).getName());
//                String tempName = temp.get(0).getName();
//                foldList.add(temp.get(0).getPath());
//                foldList.add(tempName);
                File tempFile[] = temp.remove(0).listFiles();
                for (int i = 0; i < tempFile.length; i++) {
                    temp.add(tempFile[i]);
                }
            } else {
//                files.add(temp.remove(0).getCanonicalPath());
                files.add(temp.remove(0).getName());
            }
        }
        out.println(foldList.size() + " " + Arrays.toString(foldList.toArray()));
//        out.println(Arrays.toString(files.toArray()));
        return files;
    }

    /**
     * Makes the File off of all the criteria
     *
     * @param htmlData
     */
    private static void makeFile(String htmlData) throws IOException {
        String sm = narrowDownFile(htmlData);
//        out.println(sm);
//        Setting the parameters        
        String title = sm.substring(sm.indexOf("title\">"));
        title = title.substring(7, title.indexOf("</div"));
        out.println("Title: " + title);
        sm = sm.substring(sm.indexOf(title) + title.length());
        String timeLimit = sm.substring(sm.indexOf("time limit per test") + 25);
        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
        out.println("Time Limit: " + timeLimit + (Integer.parseInt(timeLimit) == 1 ? " second" : " seconds"));
        sm = sm.substring(sm.indexOf("memory limit per test") + 27);
        String memoryLimit = sm.substring(0, sm.indexOf(" "));
        out.println("Memory Limit: " + memoryLimit + " megabytes");
        sm = sm.substring(sm.indexOf(">input<") + 12);
//        out.println(sm);
        String input = sm.substring(0, sm.indexOf("<"));
        out.println("Input: " + input);
        sm = sm.substring(sm.indexOf(">output<") + 13);
        String output = sm.substring(0, sm.indexOf("<"));
        out.println("Output: " + output);
        sm = sm.substring(sm.indexOf("<") + 20);
//        Paragraph
        String parPattern = "</p><p>";
        String parts[] = sm.split(parPattern);
//        out.println(parts.length);
        String story = "";
        for (int i = 0; i < parts.length - 1; i++) {
            story += parts[i] + "\n";
        }
        String partsCur = parts[parts.length - 1];
        story += partsCur.substring(0, partsCur.indexOf("<"));
        out.println(story);
        sm = sm.substring(story.length());
        sm = sm.substring(sm.indexOf("<"));
//        Input and Output Story
        /*
         Not Fully to text so can adjust that later though
         */
        sm = sm.substring(sm.indexOf(">Input<") + 15);
//        out.println(sm);
        String inputStory = sm.substring(0, sm.indexOf("</p"));
        out.println("Input Story: " + inputStory);
        sm = sm.substring(sm.indexOf(">Output<") + 16);
        String outputStory = sm.substring(0, sm.indexOf("</p"));
        out.println("Output Story: " + outputStory);
//        out.println(sm);
        sm = sm.substring(sm.indexOf("</p") + 3);
//        Input and outputs
        /*
         Can still work on this formatting also
         */
        String Examples = sm.substring(sm.indexOf(">Examples<") + 9);
//        out.println(Examples);
        Examples = Examples.substring(Examples.indexOf(">Input<") + 17);
//        out.println(sm);
        String inputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        out.println("Input Values: " + inputVal);
        Examples = Examples.substring(Examples.indexOf(">Output<") + 18);
        String outputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        out.println("Output Values: " + outputVal);
        out.print("\n\n\n\n");
//        String name = title.replace(".", "");
//        name = name.replaceAll(" ", "_");
        String name = title.replace('.', '_');
        name = name.replaceAll(" ", "");
        name += ".java";
        out.println(name);
        out.println(fileExist(name));
        out.println(Arrays.toString(comb.toArray()));
//        out.println(htmlData);
//        Finds if there is the round already
//        RoundFoldExist(round);

//        Write the file
        write("");
    }

    private static void write(String fileName) throws IOException {

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
    }

    /**
     * Grabs the problem set information only
     *
     * @param a
     * @return
     */
    private static String narrowDownFile(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"pageContent\" class=\"content-with-sidebar\">"));
        String f = e.substring(e.indexOf("<div class=\"problemindexholder\" problemindex="));
        String g = f.substring(f.indexOf("<div class=\"ttypography\">"));
        String h = g.substring(g.indexOf("<div class=\"problem-statement\">"));
        return h.substring(0, h.indexOf("<script type=\"text/javascript\">"));
    }

    private static void RoundFoldExist(int i) {
        String rounds = "Round_" + i;
        if (!(foldList.contains(rounds))) {
            File x = new File(notDonePath + "\\Round_" + i);// The path to the folder notDone);
            x.mkdirs();
        }
    }

    private static ArrayList<String> getFoldList() {
        File x[] = new File(notDonePath).listFiles();
        ArrayList<String> ss = new ArrayList();
        for (int i = 0; i < x.length; i++) {
            ss.add(x[i].getName());
        }
        return ss;
    }
}
