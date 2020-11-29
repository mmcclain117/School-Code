
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: QWERTY Sort
//        Points: 7
        Scanner scan = new Scanner(new File("prob07.txt"));
        ArrayList<String> ar = new ArrayList<>();
        String s = scan.nextLine();
        while (!s.equals(".")) {
            ar.add(s);
            s = scan.nextLine();
        }
        Collections.sort(ar, new SortComparator());

        /* Print sortes List */
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }
}

class SortComparator implements Comparator {

    private String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM"; // Sorting order

    public SortComparator() {
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
