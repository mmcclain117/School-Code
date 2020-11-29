
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Random Sort
//        Points: 9
        Scanner scan = new Scanner(new File("prob09.txt"));
        ArrayList<String> wordlist = new ArrayList<>();
        String alphabet = scan.nextLine(); // Get Random Alphabet

        /* Create word list*/
        while (scan.hasNext()) {
            String tmp = scan.nextLine().trim();
            wordlist.add(tmp);
        }
        Collections.sort(wordlist, new RandomSortComparator(alphabet));

        /* Print sortes List */
        for (int i = 0; i < wordlist.size(); i++) {
            System.out.println(wordlist.get(i));
        }
    }
}

class RandomSortComparator implements Comparator {

    private String alphabet = null;

    public RandomSortComparator(String a) {
        alphabet = a;
    }

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString().toUpperCase();
        String s2 = o2.toString().toUpperCase();
        int con = 0;

        while (con < s1.length() && con < s2.length()) {
            if (alphabet.indexOf(s1.charAt(con)) == alphabet.indexOf(s2.charAt(con))) {
                con++; // Letters match
            } else { // if s1 < s2 (Negative), if s1 > s2 (Positive)
                return alphabet.indexOf(s1.charAt(con)) - alphabet.indexOf(s2.charAt(con));
            }
        }
        return s1.length() - s2.length(); // s1 shorter (Negative), s1 longer (Positive), Same (0)
    }
}
