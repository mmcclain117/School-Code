
import java.util.*;
import java.io.*;

/**
 * @author Master Ward and Powell Hazzard HP
 *
 */
public class Prob17 {

    static HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) throws Exception {
//        Problem: Return of the Vowels
//        Points: 12
        parseWordList("wordlist.txt");
        BufferedReader inbr = new BufferedReader(new FileReader("prob17.in"));
        String inLine;
        while ((inLine = inbr.readLine()) != null) {
            if (inLine.startsWith(">>>>>")) {
                break; // end of input file
            }
            String[] words = inLine.split(" ");
            boolean beginLine = true;
            for (int i = 0; i < words.length; i++) {
                if (!matchFound(words[i])) {
                    System.out.print("?CODE?");
                    beginLine = false;
                } else {
                    ArrayList<String> list = getDictList(removeVowels(words[i]));
                    int count = 0;
                    String outStr = "";
                    for (String temp : list) {
                        if (count > 0) {
                            outStr += "/";
                        }
                        if (!checkVowelMatch(temp, getVowels(temp))) {
                            continue;
                        }
                        outStr += temp;
                        count++;
                    }
                    if (!beginLine) {
                        System.out.print(" ");
                    }
                    if (count > 1) {
                        System.out.print("?" + outStr + "?");
                    } else {
                        System.out.print(outStr);
                    }
                    if (count == 0) {
                        System.out.print("?CODE?");  // safety check
                    }
                    beginLine = false;
                }
            }
            System.out.println();
        }
        inbr.close();
    }

    public static String removeVowels(String word) {
        String retKey = "";
        for (int i = 0; i < word.length(); i++) {
            char checkChar = word.charAt(i);
            switch (checkChar) {
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'A':
                    continue;
                default:
                    retKey += checkChar;
            }
        }
        return retKey;
    }

    public static String getVowels(String word) {
        String retKey = "";
        for (int i = 0; i < word.length(); i++) {
            char checkChar = word.charAt(i);
            switch (checkChar) {
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'a':
                    retKey += checkChar;
                default:
            }
        }
        return retKey;
    }

    public static boolean matchFound(String in) {
        return dict.containsKey(removeVowels(in));
    }

    public static ArrayList<String> getDictList(String key) {
        return dict.get(key);
    }

    public static void storeWord(String in) {
        String key = removeVowels(in);
        ArrayList<String> list;
        if (matchFound(in)) { // Dup found add
            list = getDictList(key);
        } else { // First Time
            list = new ArrayList<String>();
            dict.put(key, list);
        }
        list.add(in);
    }

    public static void parseWordList(String in) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            storeWord(strLine.toUpperCase());
        }
        br.close();
    }

    public static boolean checkVowelMatch(String word, String vowelList) {
        for (int i = 0; i < vowelList.length(); i++) {
            if (!word.contains("" + vowelList.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
