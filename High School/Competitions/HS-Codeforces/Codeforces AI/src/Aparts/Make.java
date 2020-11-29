package Aparts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Make {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("User or File");
//        String s = scan.nextLine();
        String s = "File";
        if (s.equalsIgnoreCase("user")) {
            start(new Scanner(System.in));
        } else {
//            File f = new File("newRounds.txt");
            File f = new File("newRoundTest.txt");
            start(new Scanner(f));
        }
    }

    /**
     *
     *
     * @see Problem Letter
     * @see Problem Naming
     * @see Round Number
     * @see Reading Input ending in ##
     *
     * @param scan
     * @throws Exception
     */
    private static void start(Scanner scan) throws IOException {
        while (scan.hasNext()) {
            String fileName = "";
            String probLet = scan.nextLine();
            fileName += probLet + "_";
            String probName = scan.nextLine();
            String probNameMod = "";
            String[] pNS = probName.toLowerCase().split("\\s+");
            for (String s : pNS) {
                s = (s.substring(0, 1).toUpperCase()) + s.substring(1);
                fileName += s;
                probNameMod += s;
            }
            ArrayList<String> inputLines = new ArrayList();
            int roundNumb = scan.nextInt();
            String x = scan.nextLine();
            while (!(x.equals("##"))) {
                inputLines.add(x);
                x = scan.nextLine();
            }
            inputLines.add(0, fileName);
            inputLines.add(1, probNameMod);
            inputLines.add(2, roundNumb + "");
            out.println(Arrays.toString(inputLines.toArray()));
            write(inputLines);
        }
    }

    /**
     * Writing the file
     *
     * @see InputLines (fileName, probName, Round NUmber, commands,....)
     *
     */
    private static void write(ArrayList<String> inputLines) throws IOException {
        File currentFile = new File(inputLines.get(0) + ".java");
        inputLines.remove(0);
        FileWriter fw = new FileWriter(currentFile);
        ArrayList<String> lines = new ArrayList();
        /*
         Adding the startup
         */
        lines.add("public class " + inputLines.get(0) + "{");
        inputLines.remove(0);
        int round = Integer.parseInt(inputLines.remove(0));
        lines.add("public static void main(String args[]) {");
        lines.add("Scanner scan = new Scanner(System.in);");
        while (!(inputLines.isEmpty())) {
//            String tempLine = inputLines.remove(0);
            String tempLine = inputLines.get(0);
            inputLines.remove(0);
//            String command = findCommand(tempLine);
            String command = fndCmd(tempLine, false);
            out.println(command);
        }
        lines.add("}");
        lines.add("}");

        //Write the file
        for (String s : lines) {
            fw.write(s + "\n");
        }
        fw.flush();
        fw.close();
    }

    /*
     private static String findCommand(String tempLine) {
     tempLine.replaceAll(" ", "");
     out.println(tempLine);
     //        String sp[] = tempLine.toLowerCase().split("\\s+");
     String sp[] = tempLine.toLowerCase().split("[ ;,()]+");
     HashMap<String, Integer> hm = new HashMap();
     for (String cur : sp) {
     switch (cur) {
     case "string":
     hm.put("String", 10);
     break;
     case "int":
     hm.put("int", 10);
     break;
     case "long":
     hm.put("long", 10);
     break;
     case "double":
     hm.put("double", 10);
     break;
     case "short":
     hm.put("short", 10);
     break;
     case "boolean":
     hm.put("boolean", 10);
     break;
     case "next":
     hm.put("scan.next();", 6);
     break;
     case "nextline":
     hm.put("scan.nextLine();", 6);
     break;
     case "=":
     hm.put(" = ", 8);
     break;
     default:
     hm.put(cur, 0);
     break;
     }
     }
     String ret = "";
     Collections.synchronizedMap(hm);
     for (String p : hm.keySet()) {
     ret += p;
     }
     out.println("Key Set: " + Arrays.toString(hm.keySet().toArray()));
     out.println("Value Set: " + Arrays.toString(hm.values().toArray()));
     return ret;
     }
     */
    public static String fndCmd(String tempLine, boolean loop) {
        tempLine = tempLine.toLowerCase(); // Just as precaution
        if (loop) {
            //Do a looop type of formatting thing
        } else {
            if (tempLine.contains("next")) {
                String variable = tempLine.substring(0, tempLine.indexOf("="));
                int r = tempLine.indexOf("next");
                String temp = tempLine.substring(r - 1);
                if (temp.contains("double")) {
                    return "double " + variable + "= scan.nextDouble();";
                } else if (temp.contains("long")) {
                    return "long " + variable + "= scan.nextLong();";
                } else if (temp.contains("int")) {
                    return "int " + variable + "= scan.nextInt();";
                } else if (temp.contains("line")) {
                    return "String " + variable + "= scan.nextLine();";
                } else if (temp.contains("boolean")) {
                    return "boolean " + variable + "= scan.nextBoolean();";
                } else {
                    return "//String " + variable + "= scan.next();";
                }
            } else if (tempLine.contains("[]")) {
                int y = tempLine.indexOf("[]");
                int e = tempLine.lastIndexOf("[");
                int en = tempLine.lastIndexOf("]") + 1;
                String end = tempLine.substring(e, en) + ";";
                if (tempLine.contains("int")) {
                    String varName = tempLine.substring(4, y);
                    return "int " + varName + " = new int" + end;
                } else if (tempLine.contains("string")) {
                    String varName = tempLine.substring(7, y);
                    return "String " + varName + " = new String" + end;
                } else if (tempLine.contains("long")) {
                    String varName = tempLine.substring(5, y);
                    return "long " + varName + " = new long" + end;
                } else if (tempLine.contains("double")) {
                    String varName = tempLine.substring(7, y);
                    return "double " + varName + " = new double" + end;
                } else if (tempLine.contains("boolean")) {
                    String varName = tempLine.substring(8, y);
                    return "boolean " + varName + "[] = new boolean" + end;
                } else {
                    return tempLine;
                }
            }
        }
        return null;
    }
}
