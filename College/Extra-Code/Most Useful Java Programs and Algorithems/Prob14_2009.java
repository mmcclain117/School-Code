
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Anagram Finder
//        Points: 8
        Scanner scan = new Scanner(new File("prob14.txt"));
        String a = scan.nextLine();
        String b[] = a.split(",");
//        System.out.println(Arrays.toString(b));
        String q[] = new String[b.length]; // For the anagrams
        for (int i = 0; i < b.length; i++) {
            q[i] = ana(b[i]);
        }
        boolean used[] = new boolean[q.length]; // Word already used up
        Arrays.fill(used, true);
        for (int i = 0; i < q.length - 1; i++) {
            for (int o = i + 1; o < q.length; o++) {
                if (q[i].equals(q[o])) { // Found one
                    if (used[i] && used[o]) { // Not been used yet
                        System.out.println(b[i] + ":" + b[o]);
                        // Words can't be used again
                        used[i] = false;
                        used[o] = false;
                    }
                }
            }
        }
    }

    /* Turns the String into a sorted string */
    private static String ana(String string) {
        char ch[] = string.toCharArray();
        Arrays.sort(ch);
        String fin = "";
        for (int i = 0; i < ch.length; i++) {
            fin += ch[i];
        }
        return fin;
    }
}
