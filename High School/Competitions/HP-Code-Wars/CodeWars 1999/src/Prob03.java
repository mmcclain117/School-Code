
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Palindrome
//        Points: 2
        Scanner scan = new Scanner(new File("prob03.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            System.out.println(line);
            String mod = line.toLowerCase().replaceAll("[^a-z]", "");
            char origCh[] = mod.toCharArray(); // Original Phrase
            char reverCh[] = reverse(origCh); // Reverse Phrase
            boolean isPali = comp(origCh, reverCh);
            System.out.println("\t" + (isPali ? "is " : "is *not* ") + "a palindrome.");
        }
    }

    private static char[] reverse(char ch[]) {
        char tmp[] = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            tmp[ch.length - (i + 1)] = ch[i];
        }
        return tmp;
    }

    /* compares both of the arrays to see if similar */
    private static boolean comp(char ch[], char ch1[]) {
        int con = 0;
        while (con < ch.length) {
            if (ch[con] != ch1[con]) {
                return false;
            }
            con++;
        }
        return true;
    }
}
