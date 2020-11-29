
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Abbreviation Expansion
//        Difficulty: Medium
//        Subject: Replacement
        Scanner scan = new Scanner(new File("prob12.txt"));
        Vector word_list = new Vector();
        Vector abb_list = new Vector();
        String word;
        boolean separator_found = false;
        while (scan.hasNext()) {
            word = scan.next();
            if (word.equals("~")) {
                break;
            }
            if (word.equals("|")) {
                separator_found = true;
                continue;
            }
            if (separator_found) {
                abb_list.add(word);
            } else {
                word_list.add(word);
            }
        }
        DecodeJitter(word_list, abb_list);
    }

    static String LookupWord(Vector wl, String abv) {
        int i;
        int j;
        int k;
        int index;
        int found;
        int foundLen = 100;
        int[] lengths = new int[wl.size()];/* Track lengths of matches*/
        int nummatches = 0;
        String foundString = null;

        String punctuation = FindPunctuation(abv);
        int len = abv.length();
        if (punctuation != null) {
            --len;
        }
        for (i = 0; i < wl.size(); i++) {
            String word = (String) wl.get(i);
//            Narrow down more
            found = 0;
            k = 0;
            for (j = 0; j < len; j++) {
                String l1 = abv.substring(j, j + 1);
                index = word.indexOf(l1, j);
                /*
				 * Each successive letter in the abbreviation
				 * must be at a higher index to preserve
				 * ordering.
                 */
                if (index < k) {
                    found = 0;
                    break;
                }

                ++found;
                k = index;
            }

            if (found < len) /* Must find all abbv. letters */ {
                continue;
            }
            if (word.length() < foundLen) {
                foundString = word;
                foundLen = word.length();
            }

            lengths[nummatches] = word.length();
            ++nummatches;

        }
        /* for */

 /*
		 * If no match found, use abbreviation
         */
        if (foundString == null) {
            return abv;
        }
        if (nummatches >= 2) { // Two ore more matches
            k = 0;
            for (i = 0; i < nummatches; i++) {
                if (foundString.length() == lengths[i]) {
                    ++k;
                }
            }
            if (k >= 2) {
                return abv;
            }
        }
        if (punctuation != null) { // Add Punctuation
            foundString += punctuation;
        }

        return foundString;
    }

    static String FindPunctuation(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            String p = s.substring(i, i + 1);
            p = p.toUpperCase();
            Integer I = new Integer(p.charAt(0));
            int c = I;
            if ((c > 'Z') || (c < 'A')) {
                return s.substring(i, i + 1);
            }
        }
        return null;
    }

    static void DecodeJitter(Vector wl, Vector al) { // Decode the message 
        int i;
        String s;
        String p;
        for (i = 0; i < al.size(); i++) {
            s = (String) al.get(i);
            p = LookupWord(wl, s);
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
