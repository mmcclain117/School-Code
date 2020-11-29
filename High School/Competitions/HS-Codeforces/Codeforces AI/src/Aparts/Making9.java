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
public class Making9 {

    private static ArrayList<String> fileList; // List of already made files
    private static ArrayList<String> foldList; // list of already made folders in non complete
    private static ArrayList<String> vocab; // List of the words
// Look at FileSystems
// Looks and Writes all the files values

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        setUp();
//        getData(3, 2);
//        getData(100, 3);
//        getData(100, 20);
//        getData(20, 20);
//        getData(6, 10);
//        getData(1, 2 , 10);
//        for (int i = 1; i < 723; i++) {
        for (int i = 700; i < 723; i++) {
            getData(i, i + 1, 26);
        }
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
     * Try and make into temp files
     *
     * @param round
     * @param letter
     * @throws IOException
     */
//    public static void getData(int round, int letter) throws IOException {
    public static void getData(int startingNumb, int round, int letter) throws IOException {
        String startHttp = "http://codeforces.com/problemset/problem/";
        for (int i = startingNumb; i < round; i++) {
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
//                    out.println(fileName);
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    while ((inputLine = br.readLine()) != null) {
                        bw.write(inputLine);

                    }
                    bw.close();
                    br.close();
                    fw.close();
                    long sizing = Files.size(file.toPath());
//                    out.println(sizing + " " + file.getName());
                    String temp = "";
                    if (!(sizing >= 100000 || sizing < 100)) {
                        Scanner scan = new Scanner(new File(fileName));
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
//                    }
//                        String testVar;
                        /*
                         Writing All the components
                         */
//                        out.println(temp);
                        try {
//                            System.gc();
//                            writeBody(new BodyVar(temp), new TagVar(temp), round);
                            /**
                             * Writing the body
                             */
                            BodyVar u = new BodyVar(temp);
//                            String u = new BodyVar(temp).body;
                            String sta = "Var Files/";
                            File vf = new File(sta + "Input");
                            vf.mkdirs();
                            File v1 = new File(sta + "Input Story");
                            v1.mkdirs();
                            File v2 = new File(sta + "Name");
                            v2.mkdirs();
                            File v3 = new File(sta + "Tags");
                            v3.mkdirs();
                            String num = u.getName().substring(0, 1);
                            String en = round + num + ".txt";
                            FileWrite(u.getName(), sta + "Name/" + en);
//                            FileWrite(u.getTitle(), sta + "Title/" + en);
//                            FileWrite(u.getTimeLimit(), sta + "Time Limit/" + en);
//                            FileWrite(u.getMemoryLimit(), sta + "Memory Limit/" + en);
                            FileWrite(u.getInput(), sta + "Input/" + en);
//                            FileWrite(u.getOutput(), sta + "Output/" + en);
//                            FileWrite(u.getStory(), sta + "Story/" + en);
                            FileWrite(u.getInputStory(), sta + "Input Story/" + en);
//                            FileWrite(u.getOutputStory(), sta + "Output Story/" + en);
//                            FileWrite(u.getInputVar(), sta + "Input Variables/" + en);
//                            FileWrite(u.getOutputVar(), sta + "Output Variables/" + en);
                            FileWrite(new TagVar(temp).tagsVariable(), sta + "Tags/" + en);

                            File nui = new File(sta + "Name/" + en);
                            FileWriter fwi = new FileWriter(nui);
                            fwi.write(u.getName());
                            fwi.flush();
                            fwi.close();

                            boolean writing = true;
                            if (writing) {
                                BodyVar s = new BodyVar(temp);
                                TagVar t = new TagVar(temp);
//                                writeBody(s, t, round);
//                            } else if (!(fileExist(new BodyVar(temp).getName() + ".java"))) {
//                                write(s, t, i);
                            } else {
//                                out.println(file.getName());
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            e.printStackTrace();
                            break;
                        }
                    } else {
                        out.println(file.toPath() + " XX");
                        break;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.gc();
            }
//            System.gc();
        }
    }

    private static boolean fileExist(String fileName) {
        return fileList.contains(fileName);
    }

    public static void write(BodyVar b, TagVar t, int round) throws IOException {
        roundFoldExist(round);
        String nam = b.getName();
        String temperary = "src/notDone/Auto/Round_" + round + "/" + nam + ".java";
//        File temper = File.createTempFile(temperary, "");
        File temper = new File(temperary);
        FileWriter fw = new FileWriter(temper);
        fw.write("package notDone.Auto.Round_" + round + ";\nimport java.util.Scanner;\n"
                + "/**\n"
                + "* Tags: " + t.tagsVariable()
                + "**/"
                + "\npublic class " + nam + " {\n\n\t");
        fw.write("public static void main(String args[]) {\n\t\t");
        if ("standard input".equals(b.getInput())) {
            fw.write("Scanner scan = new Scanner(System.in);");
            String inpVa = b.getInputStory();
            String pat = "<span class=\"tex-span\">";
            while (inpVa.contains(pat)) {
                inpVa = inpVa.replaceFirst(pat, "");
                inpVa = inpVa.replaceFirst("<//span>", "");
            }
            File yi = new File("InputWord/" + round + nam.substring(0, 1) + ".txt");
            FileWriter inpu = new FileWriter(yi);
            Scanner ty = new Scanner(inpVa);
            while (ty.hasNext()) {
                inpu.write(ty.nextLine());
            }
            inpu.flush();
            inpu.close();
            ty.close();
            fw.write("\n\n\t}\n}");
            fw.flush();
            fw.close();
            System.gc();
        } else {
            fw.write("\t}\n}");
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

    private static void writeBody(BodyVar s, TagVar t, int round) throws IOException {
        String a = s.body;
//        out.println(a);
        String sta = "Var Files/";
        String f = s.getName();
        String num = f.substring(0, 1);
        String en = round + num + ".txt";
        String l = s.getTitle();
        String k = s.getTimeLimit();
        String e = s.getMemoryLimit();
        String b = s.getInput();
        String g = s.getOutput();
        String j = s.getStory();
        String c = s.getInputStory();
        String h = s.getOutputStory();
        String d = s.getInputVar();
        String i = s.getOutputVar();
        String n = t.tagsVariable();
//        FileWrite(f, en);
//        FileWriter fww = new FileWriter(new File(sta + "Name/" + en));
//        fww.write(f);
//        fww.flush();
//        fww.close();
        FileWrite(f, sta + "Name/" + en);
        FileWrite(a, sta + "Title/" + en);
        FileWrite(k, sta + "Time Limit/" + en);
        FileWrite(e, sta + "Memory Limit/" + en);
        FileWrite(b, sta + "Input/" + en);
        FileWrite(g, sta + "Output/" + en);
        FileWrite(j, sta + "Story/" + en);
        FileWrite(c, sta + "Input Story/" + en);
        FileWrite(h, sta + "Output Story/" + en);
        FileWrite(d, sta + "Input Variables/" + en);
        FileWrite(i, sta + "Output Variables/" + en);
        FileWrite(n, sta + "Tags/" + en);

//        out.println("Name: " + f + "\nTitle: " + l);
//        out.println("Input: " + b);
//        out.println("InputStory: " + c);
//        out.println("InputVar: " + d);
//        out.println("Output: " + g);
//        out.println("OutputStory: " + h);
//        out.println("OutputVar: " + i);
//        out.println("MemLimit: " + e);
//        out.println("Story: " + j);
//        out.println("TimeLimit: " + k);
//        out.println("PrintTag: " + m);
//        out.println("TagVar: " + n);
//        out.println("BODY: " + s.body.replaceAll(a, ""));
        String xxx[] = c.split("[!.?]");
        String p = "";
        for (int o = 0; o < xxx.length; o++) {
            p += xxx[o] + "\n";
        }
        FileWrite(p, sta + "Splited/" + en);
    }

    private static void FileWrite(String a, String b) throws IOException {
        File n = new File(b);
        FileWriter fw = new FileWriter(n);
        fw.write(a);
        fw.flush();
        fw.close();
//        out.println("We made it");
//        out.println(new Scanner(n).nextLine());
    }
}
