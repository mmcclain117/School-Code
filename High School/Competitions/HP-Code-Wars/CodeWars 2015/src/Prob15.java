
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward and Sebastian Schagerer
 */
public class Prob15 {

    public static String simpleOrComplex = null;
    public static String partialOrComplete = null;

    public static void main(String[] args) throws Exception {
//        Problem: Analysis of Acronyms
//        Points: 11
        Scanner scan = new Scanner(new File("prob15.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            String acronym = scan.next();
            String words = scan.nextLine();
            simpleOrComplex = null;
            partialOrComplete = "COMPLETE";
            boolean match;
            match = findMatch(acronym, words);
            if (match) {
                System.out.println(acronym + " is a " + partialOrComplete + " " + simpleOrComplex + " acronym.");
            } else {
                System.out.println(acronym + " is NOT an acronym");
            }
        }
    }

    private static boolean findMatch(String acronym, String allWords) {
        String[] words = allWords.split("[ -]");
        boolean oneWordRemaing = false;
        if (words.length == 1 && false == words[0].isEmpty()) {
            oneWordRemaing = true;
        }
        // base conditions
        if (acronym.isEmpty()
                && (allWords.isEmpty() || oneWordRemaing)) {
            if (oneWordRemaing) {
                partialOrComplete = "PARTIAL"; // skipping last word
            }
            return true;
        } else if (acronym.isEmpty()) {
            return false;
        } else if (allWords.isEmpty()) {
            return false;
        }
        // recurse condition
        // try to match 1st char of acronym with 1st char of words
        char acronymFirst = Character.toUpperCase(acronym.charAt(0));
        char wordsFirst = Character.toUpperCase(allWords.charAt(0));
        int nextWordIndex = (words[0].length() + 1);
        String remainder = "";
        if (words.length > 1) {
            remainder = allWords.substring(nextWordIndex);
        }
        if (acronymFirst == wordsFirst) {
            boolean firstMatch = findMatch(acronym.substring(1), remainder);
            if (firstMatch) {
                if (null == simpleOrComplex) {
                    simpleOrComplex = "SIMPLE";
                }
                return true;
            }
            // try to match 2 char of acronym with 2 char of words
            if (acronym.length() > 1 && allWords.length() > 1) {
                char acronymSecond = Character.toUpperCase(acronym.charAt(1));
                char wordsSecond = Character.toUpperCase(allWords.charAt(1));
                if (acronymSecond == wordsSecond) {
                    boolean secondMatch = findMatch(acronym.substring(2), remainder);
                    if (secondMatch) {
                        simpleOrComplex = "COMPLEX";
                        return true;
                    }
                    boolean skipWord = findMatch(acronym.substring(2), remainder);
                    if (skipWord) {
                        partialOrComplete = "PARTIAL";
                        return true;
                    }
                }
                boolean skipWord = findMatch(acronym.substring(1), remainder);
                if (skipWord) {
                    partialOrComplete = "PARTIAL";
                    return true;
                }
            }
        }
        boolean skipWord = findMatch(acronym, remainder);
        if (skipWord) {
            partialOrComplete = "PARTIAL";
            return true;
        }
        return false;
    }
}
