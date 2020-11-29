package DoesntWork;

import java.io.File;
import static java.lang.System.out;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author 199892
 */
public class WordLadder2 {

    public static void main(String args[]) throws Exception {

        Scanner inputScan = new Scanner(new File("input.txt"));

        while (inputScan.hasNextLine()) {
            //           Scanner dictionaryScan = new Scanner(new File("dictionary.txt"));
            Scanner dictionaryScan = new Scanner(new File("dictionary.txt"));
            String start = inputScan.next().trim();
            String end = inputScan.next().trim();
            boolean finished = false;
            char[] startChar = start.toCharArray();
            HashSet<String> usedWords = new HashSet<>();
            HashSet<String> dictionary = new HashSet<>();

            usedWords.add(start);
            LinkedList ladders = new LinkedList();
//            out.println(dictionaryScan.next());

            while (dictionaryScan.hasNextLine()) {
                dictionary.add(dictionaryScan.next().trim());
            }

            LinkedList xx = new LinkedList();
            xx.add(start);
            ladders.add(xx);

            while (finished == false) {
                if (ladders.size() == 0) {
                    finished = true;
                    System.out.println("There is no word ladder between " + start + " " + end + "!");
                }
                LinkedList lad;
                //try{
                lad = (LinkedList) ladders.dequeue();
                if (((String) lad.peek()).equals(end)) {
//                    out.println(lad.toString());
                    finished = true;
                    HashSet<String> answer = new HashSet<>();
                    for (int i = lad.size() - 1; i > -1; i--) {
                        out.println((String) lad.get(i));
                        answer.add((String) lad.get(i));
                    }
                    System.out.println(answer);
                } else {
                    boolean newWordo = false;
                    String topper = (String) lad.peek();
                    char[] word = topper.toCharArray();
                    for (int x = 0; x < topper.length(); x++) {
                        char[] copy = new char[word.length];
                        for (int i = 0; i < word.length; i++) {
                            copy[i] = word[i];
                        }
                        for (int i = 0; i < word.length; i++) {
                            for (int p = 97; p < 123; p++) {
                                char original = copy[i];
                                copy[i] = (char) p;
                                String newWord = String.copyValueOf(copy);

                                copy[i] = original;
                                if (dictionary.contains(newWord) && !usedWords.contains(newWord)) {
                                    usedWords.add(newWord);
                                    LinkedList stack = new LinkedList();
                                    for (int v = lad.size() - 1; v > -1; v--) {
                                        stack.add((String) lad.get(v));

                                    }
                                    stack.add(newWord);
                                    ladders.add(stack);
                                    newWordo = true;
                                }
                            }
                        }
                    }
                    //}
                    //catch(ClassCastException exception){
                    //System.out.println("L");
                    //}
                }
            }
        }
    }
}
