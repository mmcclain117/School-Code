
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Main {

    public static ArrayList<String> names;

    public static void main(String args[]) throws Exception {
        names = getNames(new File("Helpful Txt Files/Names.txt"));
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file path");
//        String filePath = in.nextLine();
        String filePath = "TestFile";
        String fileName = ".txt";
        Scanner scan = new Scanner(new File(filePath + fileName));
        String all = "";
        while (scan.hasNext()) {
            all += scan.nextLine();
        }
        String yu[] = all.split("\\s+");
        System.out.println("Standard or Advance");
        String fin = ""; // The Final String
        boolean choose = false;
        while (!choose) {
//            String select = in.nextLine();
//            String select = "standard";
            String select = "Advance";
            if (select.equals("standard")) {
                fin = fix(yu);
                choose = true;
            } else if (select.equals("Advance")) {
                fin = fin.toLowerCase();
                fin = fix(yu);
                fin = Comp(fin.split("\\s+"));
                String temp = adv(fin.split("\\s+"));
                choose = true;
                fin = temp;
            } else {
                System.out.println("Not an option, choose again");
            }
        }
//		  Writing the revised 
//        String revFilePath = filePath + (fileName.substring(0, fileName.lastIndexOf(".") - 1)) + "revised" + (fileName.substring(fileName.lastIndexOf(".")));
        String revFilePath = filePath + " Revised" + fileName;
        FileWriter fw = new FileWriter(new File(revFilePath));
//        fw.write(fin);
        fw.write(fin);
        fw.flush();
        fw.close();
        scan.close();
    }

    /**
     * @see Places
     * @see Day of the week
     * @param set
     * @return
     */
    public static String fix(String set[]) {
        String fin = "";
        for (String cur : set) {
//            fin += " ";
            if (cur.equals("i")) {
                fin += "I";
            } else if (cur.equalsIgnoreCase("nad") || cur.equalsIgnoreCase("adn")) {
                fin += "and";
            } else if (cur.equalsIgnoreCase("didnt")) {
                fin += "didn't";
            } else if (cur.equalsIgnoreCase("havent")) {
                fin += "haven't";
            } else if (cur.equalsIgnoreCase("cant")) {
                fin += "can't";
            } else if (cur.equalsIgnoreCase("isnt")) {
                fin += "isn't";
            } else if (cur.equalsIgnoreCase("teh")) {
                fin += "the";
            } else if (cur.equalsIgnoreCase("hte")) {
                fin += "the";
            } else if (cur.equalsIgnoreCase("ot")) {
                fin += "to";
            } else if (cur.equalsIgnoreCase("wiht")) {
                fin += "with";
            } else if (cur.equalsIgnoreCase("wathc")) {
                fin += "watch";
            } else if (cur.equalsIgnoreCase("thne")) {
                fin += "then";
            } else if (cur.equalsIgnoreCase("whiel")) {
                fin += "while";
            } else if (cur.equalsIgnoreCase("couldnt")) {
                fin += "couldn't";
            } else if (cur.equalsIgnoreCase("dont")) {
                fin += "don't";
            } else if (cur.equalsIgnoreCase("doesnt")) {
                fin += "doesn't";
            } else if (cur.equalsIgnoreCase("tkae")) {
                fin += "take";
            } else if (cur.equalsIgnoreCase("nothign")) {
                fin += "nothing";
            } else if (cur.equalsIgnoreCase("peopel")) {
                fin += "people";
            } else if (cur.equalsIgnoreCase("taht")) {
                fin += "that";
            } else if (cur.equalsIgnoreCase("hoem")) {
                fin += "home";
            } else if (cur.equalsIgnoreCase("we")) {
                fin += "we";
            } else if (cur.equalsIgnoreCase("becuase")) {
                fin += "because";
            } else if (cur.equalsIgnoreCase("bakc")) {
                fin += "back";
            } else if (cur.equalsIgnoreCase("buisy")) {
                fin += "busy";
            } else if (cur.equalsIgnoreCase("wasnt")) {
                fin += "wasn't";
            } else if (cur.equalsIgnoreCase("aroudn")) {
                fin += "around";
            } else {
                fin += cur;
            }
            fin += " ";
        }
        return fin;
    }

    public static String Comp(String set[]) {
        String fin = "";
        for (int i = 0; i < set.length; i++) {
            if (i + 1 < set.length) {
                String comp = set[i + 1];
                String setTe = set[i]; // Temporary for set[i]
                if (setTe.equals("a") || setTe.equals("an")) {
                    char c = comp.charAt(0);
                    // Check to see on y
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'U') {
                        fin += "an";
                    } else {
                        fin += "a";
                    }
                } else if (setTe.equals(".") || setTe.equals("?")) { // do all of the punctuation
                    fin += setTe + " " + comp.substring(0, 1).toUpperCase() + comp.substring(1);
                } else if (isName(set[i])) {
                    fin += (set[i].substring(0, 1).toUpperCase() + set[i].substring(1));
                } else {
                    fin += set[i];
                }
                fin += " ";
            }
        }
        return fin;
//        . /to . ?
    }

    /**
     * Makes into an arraylist the names
     *
     */
    public static ArrayList<String> getNames(File a) throws Exception {
        Scanner te = new Scanner(a);
        ArrayList<String> fin = new ArrayList();
        while (te.hasNext()) {
            fin.add(te.next().toLowerCase());
        }
        return fin;
    }

    /**
     * Need to fix
     *
     * @param test
     * @return
     */
    private static boolean isName(String test) {
        boolean co = test.contains("'s");
        if (co) {
            test = test.substring(0, test.length() - 2);
        }
        for (String s : names) {
//            if (s.equalsIgnoreCase(test)) {
            if (s.equals(test)) {
                return true;
            }
        }
        return false;
    }

    private static String adv(String[] split) {
        String fin = "";
        for (String p : split) {
            fin += p;
            fin += " ";
        }
        return fin;
    }
}
