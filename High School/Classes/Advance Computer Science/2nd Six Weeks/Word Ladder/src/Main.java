
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        Scanner in = new Scanner(new File("dictionary.txt"));
        ArrayList<String> dict = new ArrayList();
        while (in.hasNext()) {
            dict.add(in.nextLine());
        }
//        out.println(dict.size());
        while (scan.hasNext()) {
            String start = scan.next();
            String end = scan.next();
            ArrayList<String> tempList = new ArrayList();
            if (start.equals(end)) {
                out.println(end);
            } else if (start.length() != end.length()) {
                out.println("There is no word ladder from " + start + " to " + end);
            } else {
//                out.println(start.length());
                for (int i = 0; i < dict.size(); i++) {
                    if (dict.get(i).length() == start.length()) {
                        tempList.add(dict.get(i));
                    }
                }
                Collections.sort(tempList);
//                out.println(tempList.get(0));
                if (tempList.contains(start) && tempList.contains(end)) {
                    out.println("There is no word ladder from " + start + " to " + end);
                }
//                out.println("There are " + tempList.size() + " Words that have " + start.length());
            }
        }
    }

    /*
     Works perfectly
     */
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
//    }
}
