package DoesntWork;

import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Master
 */
public class WordLadder3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
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
                            answer.add(lad.get(i).toString());
                        }
                        out.println(answer);
                        break;
                    } else {
                        String t = lad.peek().toString();
                        char[] word = t.toCharArray();
                        for (int x = 0; x < t.length(); x++) {
                            char[] copy = word;
                            for (int i = 0; i < word.length; i++) {
                                for (int p = 97; p < 123; p++) {
                                    copy = word;
//                                    char orig = copy[i];
                                    copy[i] = (char) p;
                                    String nw = String.copyValueOf(copy);
//                                    copy[i] = orig;

                                    if (dictionary.contains(nw) && !used.contains(nw)) {
                                        used.add(nw);
                                        LinkedList st = new LinkedList();
                                        for (int v = lad.size() - 1; v > -1; v--) {
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

    private static int differ(String get, String end) {

        boolean change = false;

        char ch[] = get.toCharArray();
        char ch1[] = end.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!(ch[i] == ch1[i])) {
                if (change) {
                    return 3;
                } else {
                    change = true;
                }
            }
        }
        int y = change ? 1 : 0;
        return y;
    }

}
