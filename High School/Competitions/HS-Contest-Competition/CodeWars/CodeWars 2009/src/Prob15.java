
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward and Don Brace
 */
public class Prob15 {

    public static void main(String[] args) throws Exception {
//        Problem: Robert the Constructor
//        Points: 11
        Scanner scan = new Scanner(new File("prob15.txt"));
        int n = scan.nextInt(); // Number of words
        while (n != 0) {
            String words[] = new String[n]; // Array of words
            /* Read in the input */
            for (int i = 0; i < n; i++) {
                words[i] = scan.next();
            }
            String goalWord = words[0]; // First word in input is goal word.
            // Build up the word
            // Pass down one word from outer loop, then loop thru other words looking for a match.
            for (int i = 1; i < n; i++) {
                boolean found = false;
                for (int j = 1; j < n; j++) {
                    //System.out.println("Goal:" + goalWord + " strWord1:" + strWord[i] + " strWord2:" + strWord[j]);
                    String solution = FindGoalWord(goalWord, words[i], words[j]); // Solution String
                    if (solution != null) {
                        System.out.println(goalWord + " " + solution);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            n = scan.nextInt();
        }
    }

    // Simple algorighm to split up the goal word info left and right hand sub words.
    // Then look for those subwords in the two recycled words.
    // Use indexOf() and substring() member functions of the String class.
    static String FindGoalWord(String goal, String word1, String word2) {
        int index;// Index
        int len; // Length
        String subWordL; // Left Substring
        String subWordR; // Right Substring
        String sub1; // Sub 1 Left Substring
        String sub2; // Sub 1 Right Substring
        String sub3; // Sub 2 Left Substring
        String sub4; // Sub 2 Right Substring

        // Loop over the goal word length breaking it up into left and right substrings.
        //System.out.println(goal + ' ' + word1 + ' ' + word2);
        for (int i = 0; i <= goal.length(); i++) {
            subWordL = goal.substring(0, i); // Left substring.
            subWordR = goal.substring(i, goal.length()); // Right substring.

            // Now look for the left and right substrings in the recycled words.
            sub1 = "";
            index = word1.indexOf(subWordL);
            len = subWordL.length();
            if ((index >= 0) && (len > 0)) {
                sub1 = word1.substring(index, index + len);
            }
            sub2 = "";
            index = word1.indexOf(subWordR);
            len = subWordR.length();
            if ((index >= 0) && (len > 0)) {
                sub2 = word1.substring(index, index + len);
            }
            sub3 = "";
            index = word2.indexOf(subWordL);
            len = subWordL.length();
            if (index >= 0 && len > 0) {
                sub3 = word2.substring(index, index + len);
            }
            sub4 = "";
            index = word2.indexOf(subWordR);
            len = subWordR.length();
            if (index >= 0 && len > 0) {
                sub4 = word2.substring(index, index + len);
            }
            // Now just combine the substrings back into a string and compere the result to the goal word
            // To preserve ordering, return the words in the proper ordeer as a return value.
            String s = sub1 + sub3;
            if (s.equals(goal)) {
                return word1 + " " + word2;
            }
            s = sub3 + sub1;
            if (s.equals(goal)) {
                return word2 + " " + word1;
            }
            s = sub1 + sub4;
            if (s.equals(goal)) {
                return word1 + " " + word2;
            }
            s = sub4 + sub1;
            if (s.equals(goal)) {
                return word2 + " " + word1;
            }
            s = sub2 + sub3;
            if (s.equals(goal)) {
                return word1 + " " + word2;
            }
            s = sub3 + sub2;
            if (s.equals(goal)) {
                return word2 + " " + word1;
            }
            s = sub2 + sub4;
            if (s.equals(goal)) {
                return word1 + " " + word2;
            }
            s = sub4 + sub2;
            if (s.equals(goal)) {
                return word2 + " " + word1;
            }
        }
        return null;
    }

}
