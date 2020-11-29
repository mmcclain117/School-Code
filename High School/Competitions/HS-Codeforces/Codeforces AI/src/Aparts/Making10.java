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
public class Making10 {

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
        for (int i = 0; i < 800; i++) {
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

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    String inputLine;

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
                    String temp = "";
                    if (!(sizing >= 100000 || sizing < 100)) {
                        Scanner scan = new Scanner(new File(fileName));
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
                        /*
                         Writing All the components
                         */
                        try {
                            /**
                             * Writing the body
                             */
                            BodyVar u = new BodyVar(temp);
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
                            FileWrite(u.getInput(), sta + "Input/" + en);
                            FileWrite(u.getInputStory(), sta + "Input Story/" + en);
                            FileWrite(new TagVar(temp).tagsVariable(), sta + "Tags/" + en);

                            File nui = new File(sta + "Name/" + en);
                            FileWriter fwi = new FileWriter(nui);
                            fwi.write(u.getName());
                            fwi.flush();
                            fwi.close();

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
            }
        }
    }

    public static void write(BodyVar b, TagVar t, int round) throws IOException {
        roundFoldExist(round);
        String nam = b.getName();
        String temperary = "src/notDone/Auto/Round_" + round + "/" + nam + ".java";
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

    private static void FileWrite(String a, String b) throws IOException {
        File n = new File(b);
        FileWriter fw = new FileWriter(n);
        fw.write(a);
        fw.flush();
        fw.close();
    }
}
