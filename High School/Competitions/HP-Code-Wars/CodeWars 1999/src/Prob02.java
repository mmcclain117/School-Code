
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Spellbinder
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        while (scan.hasNext()) {
            String w1 = scan.next(); // Original Word
            String w2 = scan.next(); // Modified word
            char ch1[] = w1.toCharArray(); // Original Char array
            char ch2[] = w2.toCharArray(); // Modiifed Char array
            System.out.print("Ripping the ");
            for (int i = 0; i < ch1.length; i++) {
                if (ch1[i] != ch2[i]) { // If different
                    if (Character.isUpperCase(ch1[i])) {
                        System.out.print("capital ");
                    } else {
                        System.out.print("lower-case ");
                    }
                    System.out.print("\"" + ch1[i] + "\"");
                    System.out.println(" from his shirt, Letterman changes ");
                }
            }
            System.out.println("\"" + w2 + "\" back to \"" + w1 + "\"");
        }
    }
}
