
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: Word Sorter
//        Points: 6
        Scanner scan = new Scanner(new File("prob10.txt"));
        ArrayList<String> full = new ArrayList();
        ArrayList<String> ar = new ArrayList();
        Comparator<String> cm = new sorting();
        while (scan.hasNext()) {
            String tmp = scan.nextLine().trim().replaceAll("[^A-Za-z']", " ");
            String line[] = tmp.split("[ ]+");
            for (String s : line) {
                ar.add(s);
                full.add(s.toLowerCase());
            }
            Collections.sort(ar, cm);
            for (int i = 0; i < ar.size(); i++) {
                System.out.print(ar.get(i) + " ");
            }
            System.out.println();
            ar.clear();
        }
        Collections.sort(full, cm);

        /* EXTRA prints out the occurances */
        while (!full.isEmpty()) {
            int curCon = 1; // Frequency of current word
            String curWord = full.remove(0); // Get Current word
            while (full.size() > 0) {
                if (curWord.equals(full.get(0))) {
                    curCon++;
                    full.remove(0);
                } else {
                    System.out.println(curWord + " " + curCon);
                    curCon = 0;
                    break;
                }
            }
            /* For when it is the last word */
            if (curCon != 0) {
                System.out.println(curWord + " " + curCon);
            }
        }
    }
}

/* Treats Compare as equal IE Lowercase = UPPERCASE */
class sorting implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.toLowerCase().compareTo(b.toLowerCase());
    }
}
