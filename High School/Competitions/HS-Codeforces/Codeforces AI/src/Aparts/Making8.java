package Aparts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Making8 {

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
//        getData(3, 2);
//        getData(100, 3);
        getData(10, 5);
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
    public static void getData(int round, int letter) throws IOException {
        String startHttp = "http://codeforces.com/problemset/problem/";
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
//                    out.println(sizing + " " + file.getName());
                    String temp = "";
                    if (!((sizing >= 180000 || sizing < 100))) {
                        Scanner scan = new Scanner(new File(file.getName()));
                        while (scan.hasNext()) {
                            temp += scan.nextLine();
                        }
                        scan.close();
//                    }
//                        String testVar;
                        /*
                         Writing All the components
                         */
//                    out.println(temp);
                        try {
                            BodyVar s = new BodyVar(temp);
                            TagVar t = new TagVar(temp);
                            out.println(s.getTitle());
                            out.println(s.getTitle());
//                    out.println(t.tagsVariable());
                            out.println(s.getInputStory());
                            out.println(s.getTitle());
//                        out.println(s.getName());
//                        out.println(s.getTitle());
//                            writeBody(s , round);
//                            writeTag(t, round);
                            if (!fileExist(s.getName() + ".java")) {
                                write(s, t, i);
                            } else {
//                                out.println(file.getName());
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.gc();
            }
            System.gc();
        }
    }

    private static boolean fileExist(String fileName) {
        return fileList.contains(fileName);
    }

    public static void write(BodyVar b, TagVar t, int round) throws IOException {
        roundFoldExist(round);
        FileWriter fw = new FileWriter(new File("src/notDone/Auto/Round_" + round + "/" + b.getName() + ".java"));
        fw.write("package notDone.Auto.Round_" + round + ";\nimport java.util.Scanner;\n"
                + "/**\n"
                + "* Tags: " + t.tagsVariable()
                + "**/"
                + "\npublic class " + b.getName() + " {\n\n\t");
        fw.write("public static void main(String args[]) {\n\t\t");
        String nam = b.getName();
//        out.println(nam + " "+ b.getName());
        if ("standard input".equals(b.getInput())) {
            fw.write("Scanner scan = new Scanner(System.in);");
            String inpVa = b.getInputStory();
//            ArrayList<Integer> varPlace = new ArrayList();
            String pat = "<span class=\"tex-span\">";
            int o = 0;
            while (inpVa.contains(pat)) {
                int oy = inpVa.indexOf(pat);
//                varPlace.add(oy);
                o++;
                inpVa = inpVa.replaceFirst(pat, "");
                inpVa = inpVa.replaceFirst("<//span>", "");
            }
//            out.println("Number of times: " + o);
//            out.println(b.body);
//            out.println(b.getName());
            File yi = new File("InputWord/" + round + nam.substring(0, 1) + ".txt");
            FileWriter inpu = new FileWriter(yi);
            Scanner ty = new Scanner(inpVa);
            while (ty.hasNext()) {
                inpu.write(ty.nextLine());
            }
            inpu.flush();
            inpu.close();
            ty.close();
//            figure(inpVa);
//            fw.write(inpVa + "\n\n" + Arrays.toString(varPlace.toArray()) + "\t}\n}");
//            out.println(inpVa + "\n" + Arrays.toString(varPlace.toArray()));
            fw.write("\n\n\t}\n}");
//            out.println("x");
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

//    private static void figure(String inpVa) throws IOException {
//        String yu[] = inpVa.split("\\s+");
//        File p = new File("letters.txt");
//        boolean ba = fileExist(p.getName());
//        String now = "";
//        FileWriter fp = new FileWriter(p);
//        if (ba) {
//            Scanner scan = new Scanner(p);
//            while (scan.hasNext()) {
//                now += scan.nextLine() + "\n";
//            }
//        }
//        fp.write(now);
//        for (String i : yu) {
//            fp.write(i + "\n");
//        }
//        fp.flush();
//        fp.close();
//        sum(p);
//    }
//
//    private static void sum(File p) throws FileNotFoundException, IOException {
////        FileReader scan = new FileReader(p);
//        Scanner scan = new Scanner(new FileReader(p));
//        ArrayList<String> ty = new ArrayList();
//        while (scan.hasNext()) {
//            ty.add(scan.next());
//        }
//        FileWriter pp = new FileWriter(new File("lettersSumed.txt"));
//        while (!ty.isEmpty()) {
//            String te = ty.remove(0);
//            for (int i = 0; i < ty.size(); i++) {
////            for (String u : ty) {
//                if (ty.get(i).equals(te)) {
//                    ty.remove(i);
//                }
//            }
//            pp.write(te + "\n");
//        }
//        pp.flush();
//        pp.close();
//    }
}
