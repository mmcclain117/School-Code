package DoesntWork;

import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class WordLadder {

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(new File("dictionary.txt"));
        HashSet<String> dictionary = new HashSet<>();
        while (in.hasNext()) {
            dictionary.add(in.next().trim());
        }
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()) {
            String start = scan.next().trim();
            String end = scan.next().trim();
            if (start.equals(end)) {
                out.println(end);
            } else if (start.length() != end.length()) {
                out.println("There is no word ladder from " + start + " to " + end);
            } else {
                boolean finished = false;
                char[] startChar = start.toCharArray();
                HashSet<String> usedWords = new HashSet<>();
                usedWords.add(start);
                LinkedList ladders = new LinkedList();
                LinkedList xx = new LinkedList();
                xx.add(start);
                ladders.add(xx);
                while (!finished) {
                    if (ladders.size() == 0) {
                        finished = true;
                        System.out.println("There is no word ladder between " + start + " " + end + "!");
                    }
                    LinkedList lad = (LinkedList) ladders.dequeue();
                    if (((String) lad.peek()).equals(end)) {
                        ArrayList<String> answer = new ArrayList();
                        for (int i = lad.size() - 1; i > -1; i--) {
                            answer.add((String) lad.get(i));
                        }
                        System.out.println(answer);
                        break;
                    } else {
                        String tops = (String) lad.peek();
                        char[] word = tops.toCharArray();
                        for (int x = 0; x < tops.length(); x++) {
                            char[] copy = new char[word.length];
                            for (int i = 0; i < word.length; i++) {
                                copy[i] = word[i];
                            }
                            for (int i = 0; i < word.length; i++) {
                                for (int p = 97; p < 123; p++) {
                                    char original = copy[i];
                                    copy[i] = (char) p;
                                    String nw = String.copyValueOf(copy);
                                    copy[i] = original;
                                    if (dictionary.contains(nw) && !usedWords.contains(nw)) {
                                        usedWords.add(nw);
                                        LinkedList stack = new LinkedList();
                                        for (int v = lad.size() - 1; v > -1; v--) {
                                            stack.add((String) lad.get(v));
                                        }
                                        stack.add(nw);
                                        ladders.add(stack);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
