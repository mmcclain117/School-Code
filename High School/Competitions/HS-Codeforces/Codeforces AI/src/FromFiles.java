
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class FromFiles {

    /**
     * Tags:
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String var = "Var Files";
//        File f1 = new File("Input");
        File f1 = new File(var + "\\Input");
        f1.mkdirs();
//        File f3 = new File("Input Story");
        File f3 = new File(var + "\\Input Story");
        f3.mkdirs();
//        File f2 = new File("Output");
//        File f4 = new File("Input Variables");
//        File f5 = new File("Memory Limit");
//        File f6 = new File("Name");
        File f6 = new File(var + "\\Name");
        f6.mkdirs();
//        File f7 = new File("Output Story");
//        File f8 = new File("Output Variables");
//        File f9 = new File("Story");
//        File f10 = new File("Tags");
        File f10 = new File(var + "\\Tags");
        f10.mkdirs();
//        File f11 = new File("Time Limit");
//        File f12 = new File("Title");
        File inp[] = f1.listFiles();
        int ti = inp.length;
//        File fold = new File("Test");
//        fold.mkdir();
        String all = "";
        for (int i = 0; i < ti; i++) {
            String fil = inp[i].getName(); // File Name
            int round = (Integer.parseInt(fil.substring(0, fil.indexOf(".") - 1)) - 1); // Round
            String nam = Scan(f6.getPath() + "\\" + fil); // Name
            nam = nam.replaceAll("'", "");
            File ff = new File("src\\auto\\Round_" + round);
            ff.mkdirs();
//            File f = new File("src\\auto\\Round_" + round + "\\" + fil.substring(0, fil.length() - 3) + "java");
            File f = new File("src\\auto\\Round_" + round + "\\" + nam + ".java");
            FileWriter fw = new FileWriter(f);
            String tag = "";
            try {
                Scanner sf10 = new Scanner(new File(f10.getPath() + "\\" + fil));
                while (sf10.hasNext()) {
                    String temp = sf10.nextLine();
                    tag += temp.substring(0, 1).toUpperCase() + temp.substring(1) + ", ";
                }
            } catch (FileNotFoundException e) {
                tag = "None";
                e.printStackTrace();
            }
            String inputing = Scan(f1.getPath() + "\\" + fil);
//            String fin = "package Round_" + round + ";\n\n"
            String fin = "package auto.Round_" + round + ";\n\n"
                    + "import static java.lang.System.out;\n"
                    + "import java.util.Scanner;\n"
                    + "import java.io.File;\n\n"
                    + "public class " + nam + " {\n\n"
                    + "\t/**\n"
                    + "\t * Tags: " + tag + "\n"
                    + "\t *\n"
                    + "\t * @param args\n"
                    + "\t */\n"
                    + "\tpublic static void main(String args[])throws Exception {\n";
            if ("standard input".equals(inputing)) {
                fin += "\t\tScanner scan = new Scanner(System.in);\n";
            } else {
                fin += "\t\tScanner scan = new Scanner(new File(\"" + inputing + "\"));\n";
            }
            Scanner sf3 = new Scanner(new File(f3.getPath() + "\\" + fil));
            String inStore = "";
            while (sf3.hasNext()) {
                inStore += sf3.nextLine();
            }
            String trys = figure(inStore);
//            all += inStore + "\n";
            fin += trys + "\n";
//            Including the Output
//            Scanner f2s = new Scanner(f2);
//            String outs = "";
//            while(f2s.hasNext()) {
//                outs+= f2s.nextLine() + "\n";
//            }
//            fin+= outs;
            fin += "\t}\n"
                    + "}";
            fw.write(fin);
            fw.flush();
            fw.close();
        }

//        File bo = new File("vocab.txt");
//        FileWriter vocab = new FileWriter(bo);
//        vocab.write(all);
//        vocab.flush();
//        vocab.close();
    }

    private static String Scan(String string) throws Exception {
        Scanner scan = new Scanner(new File(string));
        String fin = "";
        while (scan.hasNext()) {
            fin += scan.nextLine();
        }
        return fin;
    }

    private static String figure(String inStore) {
        String fin = "\t\t";
        if (inStore.contains("The first line contains an integer number")) {
            fin += "int n = scan.nextInt();\n";
        } else if (inStore.contains("The first (and the only) input line contains integer number")) {
            fin += "int n = scan.nextInt();\n";
        } else if (inStore.contains("The first line contains the only number")) {
            fin += "int n = scan.nextInt();\n";
        } else if (inStore.contains("The first line of the input contains a single integer")) {
            fin += "int n = scan.nextInt();\n";
        }
        return fin;
    }
}
