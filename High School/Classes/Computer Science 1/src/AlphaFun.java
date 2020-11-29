
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class AlphaFun {

    public static void main(String args[]) throws IOException {
        Scanner kb = new Scanner(new File("alphafun.dat"));
        TreeSet<String> ts = new TreeSet<>();
        while (kb.hasNext()) {
            String temp = "";
            String word = kb.nextLine().trim();	// extract 4 letters for alphabetizing
            temp += word.charAt(1);				// 2nd letter
            if (word.length() < 4) // 4th letter or space
            {
                temp += ' ';
            } else {
                temp += word.charAt(3);
            }
            temp += word.charAt(word.length() - 1);  // last letter
            temp += word.charAt(0);					 // first letter
            temp += word.charAt(2);					 // 3rd letter
            if (word.length() > 4) {					 // letters 5 through end of word
                for (int i = 4; i < word.length(); i++) {
                    temp += word.charAt(i);
                }
            }

            temp = temp + " " + word;	// concatenate word to alpha keys
            ts.add(temp);				// add to tree to alphabetize
        }
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();	// extract keys from word
            // out.println(s);	
            String sp[] = s.split(" ");
            out.println(sp[sp.length - 1]);  // print word
        }
    }
}
