
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class WordLadder {

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(new File("dictionary.txt"));
        HashSet<String> dictionary = new HashSet();
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
                boolean finish = false;
                HashSet<String> used = new HashSet();
                used.add(start);
                LinkedList ladders = new LinkedList();
                LinkedList xx = new LinkedList();
                xx.add(start);
                ladders.add(xx);
                while (!finish) {
                    if (ladders.size() == 0) {
                        finish = true;
                        out.println("There is no word ladder between " + start + " " + end + "!");
                    }
                    LinkedList lad = (LinkedList) ladders.dequeue();
                    if ((lad.peek()).equals(end)) {
                        ArrayList<String> answer = new ArrayList();
                        for (int i = lad.size() - 1; i > -1; i--) {
//                            answer.add((String) lad.get(i));
                            answer.add(lad.get(i).toString());
                        }
                        out.println(answer);
                        break;
                    } else {
                        String t = lad.peek().toString();
                        char[] word = t.toCharArray();
                        for (int x = 0; x < t.length(); x++) {
                            char[] copy = t.toCharArray();
//                            for (int i = 0; i < word.length; i++) {
//                                copy[i] = word[i];
//                            }
                            for (int i = 0; i < word.length; i++) {
                                for (int p = 97; p < 123; p++) {
                                    char orig = copy[i];
                                    copy[i] = (char) p;
                                    String nw = String.copyValueOf(copy);
                                    copy[i] = orig;
                                    if (dictionary.contains(nw) && !used.contains(nw)) {
                                        used.add(nw);
                                        LinkedList st = new LinkedList();
                                        for (int v = lad.size() - 1; v > -1; v--) {
//                                            stack.add((String) lad.get(v));
                                            st.add(lad.get(v));
                                        }
                                        st.add(nw);
                                        ladders.add(st);
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
