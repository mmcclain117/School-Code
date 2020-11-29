
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Queen Ann
//        Difficulty: Very Easy
//        Subject: Repetition
        Scanner scan = new Scanner(new File("prob03.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            HashSet<Character> hs = new HashSet();
            char ch[] = b.toCharArray();
            for (char c : ch) {
                hs.add(c);
            }
            System.out.println((hs.size() != b.length() ? "likes " : "hates ") + b);
        }
    }

}
