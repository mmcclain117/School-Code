package ASomething;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.HttpURLConnection;
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
public class Making {

    public static ArrayList<String> comb;
    public static ArrayList<String> fileList;

    // @see Suggestions Put the Combonations break by testing eachone while adding it
    /**
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(new File("XXX.txt"));
        String a = "";
//        comb = getUrlCombo(700, 26);
        comb = getUrlCombo(2, 4);
//        File posU = File.createTempFile("possibleUrl", ".txt");
//        ArrayList<String> valUR = validateUrl(comb);
//        ArrayList<String> valUR = validateUrl2(comb);
//        out.println(comb.size() + " - " + valUR.size() + " = " + (comb.size() - valUR.size()) + " invalid");
//        ArrayList<String> htmlData = getHtmlData(valUR);
        ArrayList<String> htmlData = getHtmlData(comb);
        fileList = fileList();
        for (String tempHtmlData : htmlData) {
            boolean alreadyExist = fileExist(tempHtmlData);
            if (!alreadyExist) {
                makeFile(tempHtmlData);
            } else {
                comb.remove(tempHtmlData);
                htmlData.remove(tempHtmlData);
            }
        }
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
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        conn.getInputStream()));
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
                if (sizing < 110000) {
                    Scanner scan = new Scanner(new File("test.html"));
                    String temp = "";
                    while (scan.hasNext()) {
                        temp += scan.nextLine();
                    }
                    scan.close();
                    data.add(temp);
                } else {
                    comb.remove(valUR.remove(o));
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
//                    out.println(url.sameFile(new URL("http://codeforces.com/problemset/page/30")));
//                    out.println(url.sameFile(new URL("http://codeforces.com/problemset")));
//                    out.println(url.getPath());
//                    out.println(url.getQuery());
//                    out.println(url.getFile());
//                    out.println(url.getUserInfo());
                    uc.connect();
//                    out.println(uc.getConnectTimeout());
//                    uc.setConnectTimeout(100000);
//                    out.println(uc.getConnectTimeout());
//                    out.println(uc.getContentLength());
//                    out.println(uc.getOutputStream().toString());
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
        File x = new File("C:\\Users\\Jacob\\Dropbox\\Computer Science Extra\\CodeForces\\src");
        File stx[] = x.listFiles();
        temp.addAll(Arrays.asList(stx));
        while (!temp.isEmpty()) {
            if (temp.get(0).isDirectory()) {
                File tempFile[] = temp.remove(0).listFiles();
//                out.println(Arrays.toString(tempFile));
                for (int i = 0; i < tempFile.length; i++) {
                    temp.add(tempFile[i]);
                }
            } else {
                files.add(temp.remove(0).getCanonicalPath());
            }
        }
        return files;
    }

    /**
     * Makes the File off of all the criteria
     *
     * @param htmlData
     */
    private static void makeFile(String htmlData) {
        String sm = narrowDownFile(htmlData);
        String title = sm.substring(sm.indexOf("title\">"));
        title = title.substring(7, title.indexOf("</div"));
        out.println("Title: " + title);
//        out.println(sm.indexOf(title));
//        sm.replaceFirst(title, " ");
        sm = sm.substring(sm.indexOf(title) + title.length());
//        out.println(sm);
//        String timeLimit = sm.substring(sm.indexOf("</div"));
        String timeLimit = sm.substring(sm.indexOf("time limit per test") + 25);
//        sm = sm.substring(sm.indexOf("</div"));
//        timeLimit = timeLimit.substring(25, timeLimit.indexOf("</div"));
//        out.println(timeLimit);
//        out.println(sm);
        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
//        25
//        timeLimit = timeLimit.substring(0, timeLimit.indexOf("</div"));
        out.println("Time Limit: " + timeLimit + (Integer.parseInt(timeLimit) == 1 ? " second" : " seconds"));
//        out.println(sm);
        sm = sm.substring(sm.indexOf("memory limit per test") + 27);
//        sm = sm.substring(sm.indexOf("time limit per test"));
        String memoryLimit = sm.substring(0, sm.indexOf(" "));
//        sm = sm.substring(sm.indexOf("</div"));
//        memoryLimit = memoryLimit.substring(0, memoryLimit.indexOf("</div"));
        out.println("Memory Limit: " + memoryLimit + " megabytes");
//        out.println(sm);
//        out.println(sm.indexOf(">input<"));
        sm = sm.substring(sm.indexOf(">input<") + 12);
        out.println(sm);
        String input = sm.substring(0, sm.indexOf("<"));
//        sm = sm.substring(sm.indexOf("</div"));
//        input = input.substring(0, input.indexOf("</div"));
        out.println("Input: " + input);
        sm = sm.substring(sm.indexOf(">output<") + 13);
//        sm = sm.substring(sm.indexOf("</div"));
//        String output = sm.substring(sm.indexOf("</div"));
        String output = sm.substring(0, sm.indexOf("<"));
//        output = output.substring(0, output.indexOf("</div"));
        out.println("Output: " + output);
//        out.println("Remaining: " + sm);
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
}
