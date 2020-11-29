
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Distinct Letters
//        Difficulty: Easy
//        Subject: Repetition, HashSet
        Scanner scan = new Scanner(new File("prob08.txt"));
        String a = scan.nextLine();
        while (!a.equals(".")) {
            char ch[] = a.toCharArray();
            HashSet<Character> hs = new HashSet();
            for (char c : ch) {
                hs.add(c);
            }
            System.out.println(a + (hs.size() == a.length() ? " USES DISTINCT LETTERS" : " DOES NOT USE DISTINCT LETTER"));
            a = scan.nextLine();
        }
    }

}
